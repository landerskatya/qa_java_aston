
public class Tasks {
    public static void main(String[] args) {
        System.out.println(Between10and20(11, 20));
        System.out.println(Between10and20(-1, 9));
        System.out.println(Between10and20(2, 16));

        PosOrNeg(0);
        PosOrNeg(1);
        PosOrNeg(-2);

        PosOrNeg2(-1);
        PosOrNeg2(0);
        PosOrNeg(1);

        printIt("hi", 5);

        System.out.println(leapYear(2023));
    }
    /** 1.
     * Написать метод, принимающий на вход 2 целых числа и проверяющий,
     * что их сумма лежит в пределах от 10 до 20 включительно, если да - вернуть true,
     * в противном случае вернуть false
     **/

    static boolean Between10and20(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    /** 2.
     * Написать метод, которому в качестве параметра передаётся целое число,
     *  метод должен напечатать в консоль,
     *  положительное ли число передали или отрицательное ( 0 - положительное)
     **/
    static void PosOrNeg(int a) {
        System.out.println(a> = 0? "Положительное" : "Отрицательное");}
}
    /** 3.
     * Написать метод, которому в качестве параметра передается целое число.
     * Метод должен вернуть true, если число положительное,
     * и вернуть false, если число - отрицательное
     **/
    static boolean PosOrNeg2(int a) {
        return a < 0;
    }
    /** 4.
     * Написать метод, которому в качестве аргументов даются строка и число,
     * метод должен отпечатать в консоль указанную строку,
     * указанное количество раз
     **/
    static void printIt(String line, int c) {
        for (int i = 0; i < c; i++)
            System.out.println(line);
    }
    /** 5.
     * Написать метод, который определяет, является ли год високосным,
     * возвращает boolean (true - високосный, false -  не високосный.
     * Каждый четвёртый год - високосный, кроме каждого сотого,
     * при этом каждый четырёхсотый - високосный.
     **/
    static boolean leapYear(int year) {
        return year % 100 != && year % 4 == 0 || year % 400 == 0;
    }

/** МАССИВЫ.
 * 6.
 * Задать целочисленный массив, состоящий из элементов 0 и 1.
 * Например: [1, 1, 0, 0, 1, 0, 1, 1, 0, 0].
 * С помощью цикла и условия заменить 0 на 1 и 1 на 0.
 **/
public class Main {
    public static void main(String[] args) {
        int[] changeNumbers = {1, 1, 0, 0, 1, 0, 1, 1, 0, 1};
        {
            for (int i = 0; i < changeNumbers.length; i++) {
                changeNumbers[i] = (changeNumbers[i] > 0) ? 0 : 1;
                System.out.print(changeNumbers[i] + " ");
            }
        }
    }
    /** 7.
     * Задать пустой целочисленный массив длиной 100.
     * С помощью цикла заполнить его значениями от 1 до 100 последовательно
     */
    public class Main {
        public static void main(String[] args) {
            int[] fillArrow = new int[100];
            for (int i = 0; i < 100; i++) {
                fillArrow[i] = i + 1;
                System.out.print(fillArrow[i] + "");
            }
        }

        /** 8.
         * Задать массив [1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1],
         * пройти по нему циклом и числа меньше 6 умножить на 2.
         */
        public class Main {
            public static void main(String[] args) {
                int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
                int maxArr = arr.length;
                for(int i = 0; i < maxArr; i++) {
                    if (arr[i] < 6) arr[i] = arr[i] * 2;
                }
                for(int i = 0; i < maxArr; i++) {
                    System.out.print (i + "-" + arr[i]+" ");
                }
            }

            /** 9.
             * Создать квадратный двумерный целочисленный массив.
             * С помощью циклов заполнить его диагональные элементы единицами
             * (можно одну из диагоналей)
             * Определить элементы одной из диагоналей можно по следующему принципу:
             * индексы таких элементов равны, т.е., [0][0], [1][1] и т.д.
             * прописала слева направо
             */
            public class Main {
                public static void diagonal(int x, int y) {
                }
                int[][] arr = new int[x][y];
    for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr.length; j++) {
                        arr[i][i] = 1;
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            /** 10.
             * Написать метод, принимающий на вход два аргумента:
             * len и initialValue, возвращающий одномерный массив
             * типа int
             * длиной len
             * каждая ячейка которого равна initialValue
             */

            public static int[] retLenArr (int len, int initialValue){
                int arr[] = new int[len];
                for (int i = 0; i < len; i++) {
                    arr[i] = initialValue;
                    System.out.print("[" + i + "]" + arr[i] + " ");
                }
                System.out.println();
            }
        }

