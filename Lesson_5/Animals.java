//* Создать классы Собака и Кот с наследованием от класса Животное.
        //Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
        //У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
        //Добавить подсчет созданных котов, собак и животных.


class Animal {
private static int count = 0;

public Animal() {
count++;
}

public static int getCount() {
return count;
}

public void run(int distance) {
System.out.println("Животное пробежало " + distance + " м.");
}

public void swim(int distance) {
System.out.println("Животное проплыло " + distance + " м.");
}
}

class Dog extends Animal {
private static int count = 0;
private final int maxRunDistance = 500;
private final int maxSwimDistance = 10;

public Dog() {
super();
count++;
}

public static int getCount() {
return count;
}

@Override
public void run(int distance) {
if (distance <= maxRunDistance) {
System.out.println("Собака пробежала " + distance + " м.");
} else {
System.out.println("Собака не может пробежать такое расстояние.");
}
}

@Override
public void swim(int distance) {
if (distance <= maxSwimDistance) {
System.out.println("Собака проплыла " + distance + " м.");
} else {
System.out.println("Собака не может проплыть такое расстояние.");
}
}
}

class Cat extends Animal {
private static int count = 0;
private final int maxRunDistance = 200;

public Cat() {
super();
count++;
}

public static int getCount() {
return count;
}

@Override
public void run(int distance) {
if (distance <= maxRunDistance) {
System.out.println("Кот пробежал " + distance + " м.");
} else {
System.out.println("Кот не может пробежать такое расстояние.");
}
}

@Override
public void swim(int distance) {
System.out.println("Кот не умеет плавать.");
}
}

public class Main {
public static void main(String[] args) {
Dog dogBobik = new Dog();
at catMurzik = new Cat();

dogBobik.run(150);
dogBobik.swim(5);

catMurzik.run(250);
catMurzik.swim(3);

System.out.println("Всего создано животных: " + Animal.getCount());
System.out.println("Всего создано собак: " + Dog.getCount());
ystem.out.println("Всего создано котов: " + Cat.getCount());

}
