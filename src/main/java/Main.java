import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<Call> queue = new ConcurrentLinkedQueue<>();

        new Thread(new Calls(queue), "Поток-АТС").start();

        new Thread(new Operator(queue), "Оператор 1").start();

        new Thread(new Operator(queue), "Оператор 2").start();

        new Thread(new Operator(queue), "Оператор 3").start();
    }
}
