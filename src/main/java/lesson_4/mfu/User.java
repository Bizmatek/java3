package lesson_4.mfu;

public class User {
    private static MFU mfu =MFU.getInstance();
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void print(int pagesCount){
        System.out.printf("User %s started printing%n", name);
        mfu.print(pagesCount);
        System.out.printf("User %s finished printing%n", name);
    }

    public void scan(int pagesCount){
        System.out.printf("User %s started scanning%n", name);
        mfu.scan(pagesCount);
        System.out.printf("User %s finished scanning%n", name);
    }

    public void copy(int pagesCount){
        System.out.printf("User %s started copying%n", name);
        mfu.copy(pagesCount);
        System.out.printf("User %s finished copying%n", name);
    }
}
