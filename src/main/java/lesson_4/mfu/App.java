package lesson_4.mfu;

import java.util.Arrays;
import java.util.List;

public class App {
    private User user1;
    private User user2;
    private User user3;
    private User user4;

    public App() {
        user1 = new User("user1");
        user2 = new User("user2");
        user3 = new User("user3");
        user4 = new User("user4");
    }

    public static void main(String[] args) {
        App app = new App();
        app.execute();
    }

    public void execute() {
        Thread t1 = new Thread(() -> {
            user1.print(5);
        });

        Thread t2 = new Thread(() -> {
            user2.scan(3);
        });

        Thread t3 = new Thread(() -> {
            user3.print(4);
        });

        Thread t4 = new Thread(() -> {
            user4.copy(2);
        });

        List<Thread> threads = Arrays.asList(t1, t2, t3, t4);
        threads.forEach(Thread::start);

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
