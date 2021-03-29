package lesson_4.mfu;

public class MFU {
    private final Object scanMonitor = new Object();
    private final Object printMonitor = new Object();
    private static MFU instance = null;

    private MFU(){}

    public static MFU getInstance(){
        if(instance == null){
            instance = new MFU();
        }
        return instance;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {

        });
        Thread t2 = new Thread(() -> {
        });
        Thread t3 = new Thread(() -> {
        });
    }


    public void print(int pagesCount) {
        synchronized (printMonitor) {
            System.out.println("Printing started");
            for (int i = 0; i < pagesCount; i++) {
                try {
                    System.out.printf("print %d page%n", i);
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Printing ended");
        }
    }

    public void scan(int pagesCount) {
        synchronized (scanMonitor) {
            System.out.println("Scanning started");
            for (int i = 0; i < pagesCount; i++) {
                try {
                    System.out.printf("scan %d page%n", i);
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Scanning ended");
        }
    }

    public void copy(int pagesCount) {
        synchronized (scanMonitor){
            synchronized (printMonitor){
                System.out.println("Copying started");
                for (int i = 0; i < pagesCount; i++) {
                    try {
                        System.out.printf("Copy %d page%n", i);
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Copying ended");
            }
        }


    }
}

