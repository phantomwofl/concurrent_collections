import java.util.concurrent.ConcurrentLinkedQueue;

public class Calls {

    final int GENERATION_TIME = 1000;
    private ConcurrentLinkedQueue<Call> queue;

    Calls (ConcurrentLinkedQueue<Call> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                for (int i = 0; i < 60; i++) {
                    queue.add(new Call());
                    System.out.println("Поступил звонок");
                }
                Thread.sleep(GENERATION_TIME);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
