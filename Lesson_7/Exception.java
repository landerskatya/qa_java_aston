
//Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
        //При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
       // Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
        //Если в каком-то элементе массива преобразование не удалось
        //(например, в ячейке лежит символ или текст вместо числа),
        //должно быть брошено исключение MyArrayDataException с детализацией,
        //в какой именно ячейке лежат неверные данные.
        //В методе main() вызвать полученный метод,
       // обработать возможные исключения MyArraySizeException и MyArrayDataException
        //и вывести результат расчета.

public class Exception {

        public static void main(String[] args) {
            String[][] inputArray = {
                    {"1", "2", "3", "4"},
                    {"5", "6", "7", "8"},
                    {"9", "10", "11", "12"},
                    {"13", "14", "15", "16"}
            };

            try {
                int result = sumArrayElements(inputArray);
                System.out.println("Сумма элементов массива: " + result);
            } catch (MyArraySizeException e) {
                System.err.println("Ошибка размера массива: " + e.getMessage());
            } catch (MyArrayDataException e) {
                System.err.println("Ошибка данных в ячейке: " + e.getMessage());
            }
        }

        public static int sumArrayElements(String[][] array) throws MyArraySizeException, MyArrayDataException {
            if (array.length != 4 || array[0].length != 4) {
                throw new MyArraySizeException("Размер массива должен быть 4x4");
            }

            int sum = 0;

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    try {
                        sum += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("Ошибка в ячейке [" + i + "][" + j + "]: " + array[i][j]);
                    }
                }
            }

            return sum;
        }
    }

    class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    class MyArrayDataException extends Exception {
        public MyArrayDataException(String message) {
            super(message);
        }
    }
