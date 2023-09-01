
/* Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
        * Конструктор класса должен заполнять эти поля при создании объекта;
        * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
        * Создать массив из 5 сотрудников
        * С помощью цикла вывести информацию только о сотрудниках старше 40 лет
         */
public class Lesson_4 {
    public static void main(String[] args) {
        Employee[] empCorp = new Employee[5];
        empCorp[0] = new Employee("Severyanin Igor", "Technical Writer", "severyanin@mail.ru", "89116051887",70000,33);
        empCorp[1] = new Employee("Anna Akhmatova", "Poetess", "akhmatova@mail.ru", "89111061889",69000,31);
        empCorp[2] = new Employee("Nikolay Gumilyov", "Poet", "gumilyov@mail.ru", "89115041886",68000,34);
        empCorp[3] = new Employee("Vladimir Mayakovskiy", "Innovator", "schen@mail.ru", "89106071893",67000,27);
        empCorp[4] = new Employee("Alexander Block", "Word Artist", "night_street_lantern@mail.ru.com", "89128111880",66000,40);
        for (Employee employee : empCorp)
            if (employee.getAge() > 40)
                System.out.println(employee);

    }
}
class Employee {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    @Override
    public String toString(){
        return(name+ "\n-"
                +position+ "\n-"
                +email+ "\n-"
                +phone+ "\n-"
                +salary+ "\n-"
                +age);
    }
}

/* Создать класс Park с внутренним классом,
    с помощью объектов которого можно хранить информацию
        об аттракционах,
        времени их работы
        и стоимости.
    */


        public class Park {
        public static Scanner ob = new Scanner(System.in);
public info info;
public String park;
public Park() {
        System.out.print("Введите название парка");
        setPark(ob.next());
        info = new info();
        }
public String getPark(){
        return park;
        }
        publicvoid setPark(String park) {
        this.park = park;
        }
        public class info {
        int att, wh, cost;
public info() {
        System.out.print("Количество аттракционов в городе:");
        setAtt(ob.nextInt());
        System.out.print("Часы работы:");
        setWh(ob.nextInt());
        System.out.print("Стоимость:");
        setCost(ob.nextInt());
        }
        public int getAtt() {
        return att;
        }
        public void setAtt(int att) {
        this.att = att;
        }
        public int getWh() {
        return wh;
        }
        public void setWh(int wh) {
        this.wh = wh;
        }
        public int getCost() {
        return cost;
        }
        public void setCost(int cost) {
        this.cost = cost;
        }
        public void print() {
        System.out.print("В парке" + getPark() + " " + getAtt( ) + "аттракционов," + getWh()+ "часы работы парка - " + getCost() + ", а стоимость посещения - ");
        }
            }