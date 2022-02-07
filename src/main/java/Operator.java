import java.util.concurrent.ConcurrentLinkedQueue;

public class Operator extends Thread {

    final int THREE = 3000;
    final int SEC = 1000;
    private ConcurrentLinkedQueue<Call> queue;

    Operator (ConcurrentLinkedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run () {
        try {
            Thread.sleep(SEC);
            while (queue.size() != 0) {
                Thread.sleep(THREE);
                queue.poll();
                System.out.println("Звонок принят");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
