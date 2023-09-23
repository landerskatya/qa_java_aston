
/* Создать класс со следующим содержимым:

        Collection<Student> students = Arrays.aslist(
        new Student ("Дмитрий", 17, Gender.MAN),
        new Student ("Максим", 20, Gender.MAN),
        new Student ("Екатерина", 20, Gender.WOMAN),
        new Student ("Михаил", 28, Gender.MAN),
        );
private enum Gender {
    MAN,
    WOMAN
}
private static class Student {
    private final String name;
    private final Integer age;
    private final Sex gender;
}
    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }
    public Gender getGender() {
        return gender;
    }
    @Override
    public String toString() {
        return " { " +
                "name=' " + name + '\' ' +
                " , age=" + age +
                " , gender=" + gender +
                ' } ';
    }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (this ! (o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(age, student.age) &&
                Objects.equals(gender, student.gender):
    }
    @Override
    public int hashCode () {
        return Objects.hash(name, age, gender);
    }

1. Необходимо узнать средний возраст студентов мужского пола;

2. Кому из студентов грозит получение повестки в этом году при условии,
        что призывной возраст установлен в диапазоне от 18 до 27 лет */

public class Students {
    private enum Gender {
        MAN,
        WOMAN
    }

    private static class Student {
        private final String name;
        private final Integer age;
        private final Gender gender;

        public Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return " { " +
                    "name='" + name + '\'' +
                    " , age=" + age +
                    " , gender=" + gender +
                    " } ";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) &&
                    Objects.equals(age, student.age) &&
                    Objects.equals(gender, student.gender);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, gender);
        }
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 20, Gender.WOMAN),
                new Student("Михаил", 28, Gender.MAN)
        );

        // 1. Средний возраст студентов мужского пола
        OptionalDouble averageAgeOfMales = students.stream()
                .filter(student -> student.getGender() == Gender.MAN)
                .mapToDouble(Student::getAge)
                .average();
        if (averageAgeOfMales.isPresent()) {
            System.out.println("Средний возраст студентов мужского пола: " + averageAgeOfMales.getAsDouble());
        } else {
            System.out.println("Нет студентов мужского пола.");
        }

        // 2. Кто получит повестку в этом году
        Calendar now = Calendar.getInstance();
        int currentYear = now.get(Calendar.YEAR);
        int draftYear = currentYear - 18;

        List<Student> draftCandidates = students.stream()
                .filter(student -> student.getGender() == Gender.MAN)
                .filter(student -> student.getAge() >= 18 && student.getAge() <= 27)
                .collect(Collectors.toList());

        if (!draftCandidates.isEmpty()) {
            System.out.println("Студенты, которым грозит получение повестки в " + draftYear + " году:");
            for (Student candidate : draftCandidates) {
                System.out.println(candidate.getName());
            }
        } else {
            System.out.println("Нет студентов, которым грозит получение повестки в " + draftYear + " году.");
        }
    }
}