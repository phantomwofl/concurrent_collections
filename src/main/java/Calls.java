import java.util.concurrent.ConcurrentLinkedQueue;

public class Calls extends Thread {

    final int SEC = 1000;
    private ConcurrentLinkedQueue<Call> queue;

    Calls (ConcurrentLinkedQueue<Call> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(SEC);
                for (int i = 0; i < 60; i++) {
                    queue.add(new Call());
                    System.out.println("Поступил звонок");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ConcurrentLinkedQueue<Call> getQueue() {
        return queue;
    }
}
