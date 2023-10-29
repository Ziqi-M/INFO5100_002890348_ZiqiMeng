abstract class Shape {
    protected String color;
    protected static String shapeName;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract double calculateArea();

    public abstract double calculatePerimeter();

    public static String getShapeName() {
        return shapeName;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;
    private double side1;
    private double side2;
    private double side3;

    static {
        shapeName = "Triangle";
    }

    public Triangle(String color, double base, double height, double side1, double side2, double side3) {
        super(color);
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    static {
        shapeName = "Rectangle";
    }

    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

class Circle extends Shape {
    private double radius;

    static {
        shapeName = "Circle";
    }

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Square extends Rectangle {
    static {
        shapeName = "Square";
    }

    public Square(String color, double side) {
        super(color, side, side);
    }

    @Override
    public double calculateArea() {
        return super.calculateArea();
    }

    @Override
    public double calculatePerimeter() {
        return super.calculatePerimeter();
    }
}

public class Main {
    public static void main(String[] args) {
        Shape triangle = new Triangle("Red", 6, 8, 5, 5, 7);
        Shape rectangle = new Rectangle("Blue", 4, 6);
        Shape circle = new Circle("Green", 5);
        Shape square = new Square("Yellow", 4);

        Shape[] shapes = {triangle, rectangle, circle, square};

        for (Shape shape : shapes) {
            System.out.println("Shape: " + Shape.getShapeName());
            System.out.println("Color: " + shape.getColor());
            System.out.println("Area: " + shape.calculateArea());
            System.out.println("Perimeter: " + shape.calculatePerimeter());
            System.out.println();
        }
    }
}
