import java.io.*;
import java.util.*;
public class AppData {
    private String[] header;
    private List<int[]> data;

    public AppData(String[] header, List<int[]> data) {
        this.header = header;
        this.data = data;
    }

    // Метод для создания CSV файла и сохранения данных
    public void save(String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            // Записываем заголовок
            writer.println(String.join(";", header));

            // Записываем данные
            for (int[] row : data) {
                String rowString = Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(";"));
                writer.println(rowString);
            }

            System.out.println("Данные успешно сохранены в файл: " + filePath);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении данных: " + e.getMessage());
        }
    }

    // Метод для загрузки данных из CSV файла
    public static AppData load(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Считываем заголовок
            String headerLine = reader.readLine();
            String[] header = headerLine.split(";");

            // Считываем данные
            List<int[]> data = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                int[] row = Arrays.stream(values)
                        .mapToInt(Integer::parseInt)
                        .toArray();
                data.add(row);
            }

            System.out.println("Данные успешно загружены из файла: " + filePath);

            return new AppData(header, data);
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке данных: " + e.getMessage());
            return null;
        }
    }

    public String[] getHeader() {
        return header;
    }

    public List<int[]> getData() {
        return data;
    }

    public static void main(String[] args) {
        // Пример использования
        String[] header = {"Value 1", "Value 2", "Value 3"};
        List<int[]> data = new ArrayList<>();
        data.add(new int[]{100, 200, 123});
        data.add(new int[]{300, 400, 500});

        AppData appData = new AppData(header, data);

        // Путь к создаваемому CSV файлу
        String filePath = "data.csv";

        // Сохраняем данные в CSV файл
        appData.save(filePath);

        // Загружаем данные из CSV файла
        AppData loadedData = AppData.load(filePath);
        if (loadedData != null) {
            System.out.println("Заголовок: " + String.join(", ", loadedData.getHeader()));
            System.out.println("Данные:");
            for (int[] row : loadedData.getData()) {
                System.out.println(Arrays.toString(row));
            }
        }
    }
}