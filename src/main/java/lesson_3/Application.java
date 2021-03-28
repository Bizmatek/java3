package lesson_3;

import java.io.File;
import java.util.*;

public class Application {
    private FileService fileService;

    public Application() {
        fileService = new FileService();
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.execute();
    }

    public void execute() {
        System.out.printf("%ntask 1:");
        task1();
        System.out.printf("%ntask 2:");
        task2();
        System.out.printf("%ntask 3:");
        task3();
    }

    private void task1(){
        File fileToRead = getFileByName("task1File.txt");
        fileService.readFile(fileToRead);
    }

    private void task2(){
        List<File> files = new ArrayList<>();
        Arrays.asList("task2File1.txt", "task2File2.txt")
                .forEach(fn ->
                        files.add(getFileByName(fn))
                );
        File result = fileService.combineFiles(files);
        System.out.printf("result saved in %s%n", result.getAbsoluteFile());
    }
    private void task3(){
        File file = getFileByName("task3File.txt");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the page number");
        int pageNum = scanner.nextInt() - 1;

        System.out.println(fileService.readPage(file, pageNum));
    }

    public static  File getFileByName(String filename){
        return new File(Objects.requireNonNull(Application.class
                .getClassLoader()
                .getResource(filename))
                .getFile());
    }
}
