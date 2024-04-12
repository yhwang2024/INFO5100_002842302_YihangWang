import java.io.*;

abstract class Shape implements Serializable {
    abstract double calculateArea();
    abstract double calculatePerimeter();
}

class Triangle extends Shape implements Serializable {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    double calculatePerimeter() {
        return 3 * base; // Assuming it's an equilateral triangle for simplicity
    }
}

class Rectangle extends Shape implements Serializable {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    double getWidth() {
        return width;
    }

    double getHeight() {
        return height;
    }

    @Override
    double calculateArea() {
        return width * height;
    }

    @Override
    double calculatePerimeter() {
        return 2 * (width + height);
    }
}

class Circle extends Shape implements Serializable {
    private static final long serialVersionUID = 1L;

    private final double PI = Math.PI;
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return PI * radius * radius;
    }

    @Override
    double calculatePerimeter() {
        return 2 * PI * radius;
    }
}

class Square extends Rectangle implements Serializable {
    public Square(double side) {
        super(side, side);
    }

    @Override
    double calculatePerimeter() {
        return 4 * getWidth();
    }
}

public class Main {
    public static void main(String[] args) {
        // Create objects
        Triangle triangle = new Triangle(3, 4);
        Rectangle rectangle = new Rectangle(2, 5);
        Circle circle = new Circle(3);
        Square square = new Square(4);

        // Serialize objects
        try {
            FileOutputStream fileOut = new FileOutputStream("shapes.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(triangle);
            out.writeObject(rectangle);
            out.writeObject(circle);
            out.writeObject(square);
            out.close();
            fileOut.close();
            System.out.println("Objects serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize objects
        try {
            FileInputStream fileIn = new FileInputStream("shapes.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Triangle deserializedTriangle = (Triangle) in.readObject();
            Rectangle deserializedRectangle = (Rectangle) in.readObject();
            Circle deserializedCircle = (Circle) in.readObject();
            Square deserializedSquare = (Square) in.readObject();
            in.close();
            fileIn.close();

            // Test deserialized objects
            System.out.println("\nDeserialized Triangle Area: " + deserializedTriangle.calculateArea());
            System.out.println("Deserialized Rectangle Area: " + deserializedRectangle.calculateArea());
            System.out.println("Deserialized Circle Area: " + deserializedCircle.calculateArea());
            System.out.println("Deserialized Square Area: " + deserializedSquare.calculateArea());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
