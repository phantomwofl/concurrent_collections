import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

    volatile static ConcurrentLinkedQueue<Call> queue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) {

        Calls calls = new Calls(queue);

        new Thread(calls::run, "Поток-АТС").start();

        new Thread(new Operator(queue), "Оператор 1").start();

        new Thread(new Operator(queue), "Оператор 2").start();

        new Thread(new Operator(queue), "Оператор 3").start();
    }
}
