public class Geometry {
    interface Shape {
        double getPerimeter();

        double getArea();

        String getFillColor();

        String getBorderColor();
    }

    // Абстрактный класс для хранения цвета
    abstract class ColoredShape implements Shape {
        private String fillColor;
        private String borderColor;

        public ColoredShape(String fillColor, String borderColor) {
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        public String getFillColor() {
            return fillColor;
        }

        public String getBorderColor() {
            return borderColor;
        }
    }

    // Класс для круга
    class Circle extends ColoredShape {
        private double radius;

        public Circle(double radius, String fillColor, String borderColor) {
            super(fillColor, borderColor);
            this.radius = radius;
        }

        @Override
        public double getPerimeter() {
            return 2 * Math.PI * radius;
        }

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }
    }

    // Класс для прямоугольника
    class Rectangle extends ColoredShape {
        private double width;
        private double height;

        public Rectangle(double width, double height, String fillColor, String borderColor) {
            super(fillColor, borderColor);
            this.width = width;
            this.height = height;
        }

        @Override
        public double getPerimeter() {
            return 2 * (width + height);
        }

        @Override
        public double getArea() {
            return width * height;
        }
    }

    // Класс для треугольника
    class Triangle extends ColoredShape {
        private double side1;
        private double side2;
        private double side3;

        public Triangle(double side1, double side2, double side3, String fillColor, String borderColor) {
            super(fillColor, borderColor);
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }

        @Override
        public double getPerimeter() {
            return side1 + side2 + side3;
        }

        @Override
        public double getArea() {
            // Формула Герона для вычисления площади треугольника
            double s = getPerimeter() / 2;
            return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        }
    }

    public class Main {
        public static void main(String[] args) {
            Circle circle = new Circle(5.0, "Red", "Black");
            Rectangle rectangle = new Rectangle(4.0, 6.0, "Blue", "Green");
            Triangle triangle = new Triangle(3.0, 4.0, 5.0, "Yellow", "Brown");

            displayShapeInfo(circle);
            displayShapeInfo(rectangle);
            displayShapeInfo(triangle);
        }

        public static void displayShapeInfo(Shape shape) {
            System.out.println("Фигура: " + shape.getClass().getSimpleName());
            System.out.println("Периметр: " + shape.getPerimeter());
            System.out.println("Площадь: " + shape.getArea());
            System.out.println("Цвет фона: " + shape.getFillColor());
            System.out.println("Цвет границы: " + shape.getBorderColor());
            System.out.println();
        }
    }
}
