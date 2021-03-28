package lesson_3;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class FileService {
    //    1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
    public void readFile(File file) {
        try (FileInputStream fin = new FileInputStream(file)) {
            int x = 0;
            byte[] arr = new byte[50];
            while ((x = fin.read(arr)) > 0) {
                System.out.println(new String(arr, 0, x, StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    2. Последовательно сшить 5 файлов в один (файлы примерно 100 байт).
//    Может пригодиться следующая конструкция:
//    ArrayList<InputStream> al = new ArrayList<>(); ... Enumeration<InputStream> e = Collections.enumeration(al);

    public File combineFiles(File... file) {
        return combineFiles(Arrays.asList(file));
    }

    public File combineFiles(List<File> files) {
        List<InputStream> inList = new ArrayList<>();

        files.forEach(f -> {
            try {
                inList.add(new FileInputStream(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

        int x;
        File file = new File(Objects.requireNonNull(getClass()
                .getClassLoader()
                .getResource("result.txt"))
                .getFile());

        try (SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(inList));
            FileOutputStream outputStream = new FileOutputStream(file);
        ) {
            while ((x = sequenceInputStream.read()) > 0) {
                outputStream.write(x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

//    3. Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb).
//    Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль.
//    Контролируем время выполнения: программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.
    public String readPage(File file, int pageNum){
        final int PAGE_SIZE = 1800;
        byte[] page = new byte[PAGE_SIZE];

        try(RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")){
            randomAccessFile.seek(PAGE_SIZE * pageNum);
            randomAccessFile.read(page);
            return new String(page, 0, PAGE_SIZE, StandardCharsets.UTF_8);
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.printf("Unable to read text on page %s", pageNum);
        return null;
    }
}
