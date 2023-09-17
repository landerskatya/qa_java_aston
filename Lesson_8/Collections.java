
        //Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        //Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        //Посчитать, сколько раз встречается каждое слово. (реализовать с использованием коллекций)

import java.util.*;

        public class Collections {
            public static void main(String[] args) {
                String[] words = {
                        "apple", "banana", "cherry", "apple", "date",
                        "banana", "elderberry", "fig", "date", "grape",
                        "honeydew", "cherry", "kiwi", "lemon", "mango",
                        "orange", "pear", "grape", "lemon", "pineapple"
                };

                // Создаем список для уникальных слов и карту для подсчета количества слов
                List<String> uniqueWords = new ArrayList<>();
                Map<String, Integer> wordCount = new HashMap<>();

                // Проходим по массиву слов
                for (String word : words) {
                    if (!uniqueWords.contains(word)) {
                        uniqueWords.add(word);
                    }

                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }

                // Вывод уникальных слов и их количества
                System.out.println("Уникальные слова:");
                for (String word : uniqueWords) {
                    System.out.println(word + ": " + wordCount.get(word) + " раз");
                }
            }
        }