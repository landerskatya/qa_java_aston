
//Написать программу(-ы), позволяющую(-ие) выполнить следуюющее:
//
//Для любого набора случайно-сгенерированных чисел нужно определить количество чётных чисел.

public class RandomNumbers {
    public static void main(String[] args) {
        int countEvenNumbers = 0;
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(20);
            System.out.println("Случайное число: " + randomNumber);
            if (randomNumber % 2 == 0) {
                countEvenNumbers++;
                System.out.println(“Это четное число”);
            } else {
                System.out.println(“Это нечетное число”);
            }
        }
        System.out.println("Количество четных чисел: " + countEvenNumbers);
    }
}
