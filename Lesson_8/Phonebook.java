

//Написать простой класс Телефонный Справочник,
// который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи,
// а с помощью метода get() искать номер телефона по фамилии.
// Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
// тогда при запросе такой фамилии должны выводиться все телефоны

import java.util.*;

public class Phonebook {
    private Map<String, List<String>> phonebook;

    public Phonebook() {
        phonebook = new HashMap<>();
    }

    // Метод для добавления записи в Телефонный Справочник
    public void add(String lastName, String phoneNumber) {
        List<String> phones = phonebook.getOrDefault(lastName, new ArrayList<>());
        phones.add(phoneNumber);
        phonebook.put(lastName, phones);
    }

    // Метод для поиска телефонов по фамилии
    public List<String> get(String lastName) {
        return phonebook.getOrDefault(lastName, Collections.emptyList());
    }

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

        // Добавление записей в Телефонный Справочник
        phonebook.add("Иванов", "1234567890");
        phonebook.add("Петров", "9876543210");
        phonebook.add("Иванов", "5555555555");

        // Поиск телефонов по фамилии
        System.out.println("Телефоны по фамилии Иванов:");
        List<String> ivanovPhones = phonebook.get("Иванов");
        for (String phone : ivanovPhones) {
            System.out.println(phone);
        }

        System.out.println("\nТелефоны по фамилии Петров:");
        List<String> petrovPhones = phonebook.get("Петров");
        for (String phone : petrovPhones) {
            System.out.println(phone);
        }
    }
}
