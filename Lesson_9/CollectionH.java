//Задана коллекция, состоящая из строк: «Highload», «High», «Load», «Highload». Нужно с ней выполнить следующие манипуляции:

       // 2.1. Посчитать, сколько раз объект «High» встречается в коллекции;

      //  2.2. Определить, какой элемент в коллекции находится на первом месте. Если мы получили пустую коллекцию, то пусть возвращается 0;

       // 2.3. Необходимо вернуть последний элемент, если получили пустую коллекцию, то пусть возвращается 0;

public class CollectionH {
    public static void main(String[] args) {
        List<String> collection = Arrays.asList("Highload", "High", "Load", "Highload");

        // 2.1. Посчитать, сколько раз объект "High" встречается в коллекции
        long highCount = collection.stream()
                .filter(s -> s.equals("High"))
                .count();
        System.out.println("Количество 'High' в коллекции: " + highCount);

        // 2.2. Определить, какой элемент в коллекции находится на первом месте
        String firstElement = collection.stream()
                .findFirst()
                .orElse("0");
        System.out.println("Первый элемент в коллекции: " + firstElement);

        // 2.3. Вернуть последний элемент
        String lastElement = collection.stream()
                .reduce((first, second) -> second)
                .orElse("0");
        System.out.println("Последний элемент в коллекции: " + lastElement);
    }
}