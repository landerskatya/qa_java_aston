// Задана коллекция, содержащая элементы "f10", "f15", "f2", "f4", "f4".
// Необходимо отсортировать строки в алфавитном порядке и добавить их в массив;


public class CollectionF {
    public static void main(String[] args) {
        List<String> collection = Arrays.asList("f10", "f15", "f2", "f4", "f4");

        // Сортируем коллекцию в алфавитном порядке и преобразуем ее в массив
        String[] sortedArray = collection.stream()
                .distinct() // Убираем дубликаты, если они есть
                .sorted()
                .toArray(String[]::new);

        // Выводим отсортированный массив
        for (String item : sortedArray) {
            System.out.println(item);
        }
    }
}