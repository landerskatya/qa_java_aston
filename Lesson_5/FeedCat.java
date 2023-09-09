
 /* 5. Расширить задачу про котов и тарелки с едой
         * Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается съесть 15-20)
         * Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось поесть (хватило еды), сытость = true
         * 4Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
         * Создать массив котов и тарелку с едой, попросить всех котов поесть из этой тарелки и потом вывести информацию о сытости котов в консоль
         * Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
         */

 class Cat {
     private String name;
     private int appetite;
     private boolean isHungry;

     public Cat(String name, int appetite) {
         this.name = name;
         this.appetite = appetite;
         this.isHungry = true;
     }

     public void eat(Plate plate) {
         if (isHungry && plate.decreaseFood(appetite)) {
             System.out.println(name + " поел из тарелки.");
             isHungry = false;
         } else {
             System.out.println(name + " печалится, так как еды недостаточно.");
         }
     }

     public boolean isHungry() {
         return isHungry;
     }
 }

 class Plate {
     private int food;

     public Plate(int food) {
         this.food = food;
     }

     public boolean decreaseFood(int amount) {
         if (amount <= food) {
             food -= amount;
             return true;
         } else {
             return false;
         }
     }

     public void addFood(int amount) {
         food += amount;
     }

     public void info() {
         System.out.println("В тарелке осталось " + food + " еды.");
     }
 }

 public class Main {
     public static void main(String[] args) {
         Cat[] cats = {
                 new Cat("Мурзик", 5),
                 new Cat("Барсик", 10),
                 new Cat("Том", 7)
         };

         Plate plate = new Plate(15);

         System.out.println("Начальное состояние тарелки:");
         plate.info();

         for (Cat cat : cats) {
             cat.eat(plate);
         }

         System.out.println("\nСостояние тарелки после кормежки:");
         plate.info();

         System.out.println("\nСостояние голодных котов:");
         for (Cat cat : cats) {
             System.out.println(cat.getName() + ": Голоден - " + cat.isHungry());
         }
     }
 }