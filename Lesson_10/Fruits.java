/* Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
        2. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
        3. Для хранения фруктов внутри коробки можно использовать ArrayList;
        4. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
        5. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
        6. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
        7. Не забываем про метод добавления фрукта в коробку. */

class Fruit {
    private float weight; // Вес фрукта

    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }
}

class Apple extends Fruit {
    public Apple() {
        super(1.0f); // Вес яблока
    }
}

class Orange extends Fruit {
    public Orange() {
        super(1.5f); // Вес апельсина
    }
}

class Box<T extends Fruit> {
    private List<T> fruits = new ArrayList<>(); // Хранение фруктов в коробке

    // Метод добавления фрукта в коробку
    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    // Метод вычисления общего веса коробки
    public float getWeight() {
        float totalWeight = 0;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    // Метод сравнения коробок по весу
    public boolean compare(Box<?> otherBox) {
        return Math.abs(this.getWeight() - otherBox.getWeight()) < 0.0001;
    }

    // Метод пересыпки фруктов из текущей коробки в другую
    public void transferTo(Box<T> otherBox) {
        if (this == otherBox) {
            return;
        }
        for (T fruit : fruits) {
            otherBox.addFruit(fruit);
        }
        fruits.clear(); // Очищаем текущую коробку
    }
}

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(new Apple());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        System.out.println("Weight of appleBox1: " + appleBox1.getWeight());
        System.out.println("Weight of appleBox2: " + appleBox2.getWeight());
        System.out.println("Weight of orangeBox: " + orangeBox.getWeight());

        System.out.println("Is appleBox1 equal to appleBox2? " + appleBox1.compare(appleBox2));
        System.out.println("Is appleBox1 equal to orangeBox? " + appleBox1.compare(orangeBox));

        appleBox1.transferTo(appleBox2);
        System.out.println("After transfer:");
        System.out.println("Weight of appleBox1: " + appleBox1.getWeight());
        System.out.println("Weight of appleBox2: " + appleBox2.getWeight());
    }
}