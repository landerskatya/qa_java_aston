
/* ужно написать программу, которая будет принимать от пользователя ввод различных логинов.
Как только пользователь введет пустую строку - программа должна прекратить приём данных
от пользователя и вывести в консоль логины,
начинающиеся на букву f (строчную).
 */


public class Logins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> logins = new ArrayList<>();

        System.out.println("Введите логин:");
        while (true) {
            String login = scanner.nextLine().trim();
            if (login.isEmpty()) {
                break;
            }
            logins.add(login);
        }

        System.out.println("Пустая строка влечёт за собой отображение логинов, начинающихся с 'f':");
        for (String login : logins) {
            if (login.startsWith("f")) {
                System.out.println(login);
            }
        }
    }
}