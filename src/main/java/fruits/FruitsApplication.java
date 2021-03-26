package fruits;

public class FruitsApplication {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Apple> anotherAppleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        System.out.println(appleBox.getBoxWeight());

        orangeBox.addFruit(new Orange());
        System.out.println(orangeBox.getBoxWeight());

        System.out.println(appleBox.compareTo(orangeBox));

        appleBox.moveFruitsToAnotherBox(anotherAppleBox);
        System.out.println(appleBox.getBoxWeight());
        System.out.println(anotherAppleBox.getBoxWeight());
    }
}
