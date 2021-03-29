package lesson_4;

public class homework {
    char currentChar;
    char previousChar;

    public static void main(String[] args) {
        homework app = new homework();
        app.task1();
    }

    public void task1() {
        currentChar = 'C';
        previousChar = currentChar;
        Thread t1 = new Thread((Runnable) (() -> {
            int i = 0;
            while (i < 5) {
                print('C', 'A');
                i++;
            }
        }));

        Thread t2 = new Thread(() -> {
            int i = 0;
            while (i < 5) {
                print('A', 'B');
                i++;
            }
        });

        Thread t3 = new Thread(() -> {
            int i = 0;
            while (i < 5) {
                print('B', 'C');
                i++;
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void print(char previous, char next) {
        while (currentChar != previous) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(next);
        currentChar = next;
        notifyAll();
    }
}
