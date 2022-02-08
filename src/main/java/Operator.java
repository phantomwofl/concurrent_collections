import java.util.concurrent.ConcurrentLinkedQueue;

public class Operator extends Thread {

    final int PROCESSING = 3000;
    private ConcurrentLinkedQueue<Call> queue;

    Operator (ConcurrentLinkedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run () {
        try {
            while (!queue.isEmpty()) {
                queue.poll();
                System.out.println("Звонок принят");
                Thread.sleep(PROCESSING);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
