package fruits;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit>{
    private List<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
            fruits.add(fruit);
    }

    public float getBoxWeight(){
        return (float) fruits.stream()
                .mapToDouble(f -> f.getWeight())
                .sum();

    }

    public boolean compareTo(Box box){
        return this.getBoxWeight() == box.getBoxWeight();
    }

    public void moveFruitsToAnotherBox(Box<T> box){
        fruits.forEach(box::addFruit);
        fruits = new ArrayList<>();
    }
}
