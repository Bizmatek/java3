import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        String[] array = {"a", "b", "c"};
        Integer[] array2 = {1, 2, 3};

        Application app = new Application();
        System.out.println("arrays");
        System.out.println(Arrays.toString(app.exchange(array, 0, 2)));
        System.out.println(Arrays.toString(app.exchange(array2, 1, 2)));

        System.out.println("lists");
        List<String> stringList = app.makeList(array);
        List<Integer> intList = app.makeList(array2);
        System.out.println(stringList);
        System.out.println(intList);
    }

    //    Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
    private <T extends Object> T[] exchange(T[] array, int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
        return array;
    }

    //    Написать метод, который преобразует массив в ArrayList;
    private <T> List<T> makeList(T[] array) {
        List<T> list = new ArrayList<T>();
        for (T e : array) {
            list.add(e);
        }
        return list;
    }
}
