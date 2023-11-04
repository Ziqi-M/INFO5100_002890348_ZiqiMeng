import java.io.*;

abstract class Shape implements Serializable {
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

class Triangle extends Shape implements Serializable {
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

class Rectangle extends Shape implements Serializable {
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

class Circle extends Shape implements Serializable {
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

class Square extends Rectangle implements Serializable {
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

        // Serialize and deserialize the objects
        try {
            // Serialize the objects
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("shapes.ser"));
            out.writeObject(triangle);
            out.writeObject(rectangle);
            out.writeObject(circle);
            out.writeObject(square);
            out.close();

            // Deserialize the objects
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("shapes.ser"));
            Shape deserializedTriangle = (Shape) in.readObject();
            Shape deserializedRectangle = (Shape) in.readObject();
            Shape deserializedCircle = (Shape) in.readObject();
            Shape deserializedSquare = (Shape) in.readObject();
            in.close();

            // Display the deserialized objects
            System.out.println("Deserialized Triangle: " + deserializedTriangle.getShapeName());
            System.out.println("Deserialized Rectangle: " + deserializedRectangle.getShapeName());
            System.out.println("Deserialized Circle: " + deserializedCircle.getShapeName());
            System.out.println("Deserialized Square: " + deserializedSquare.getShapeName());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
