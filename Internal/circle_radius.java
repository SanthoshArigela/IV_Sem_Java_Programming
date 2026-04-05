import java.util.Scanner;
abstract class Shape {
    abstract void calculateArea();
}
class Rectangle extends Shape {
    double length, breadth;
    Rectangle(double l, double b) {
        length = l;
        breadth = b;
    }
    @Override
    void calculateArea() {
        double area = length * breadth;
        System.out.println("Area of Rectangle: " + area);
    }
}
class Circle extends Shape {
    double radius;

    Circle(double r) {
        radius = r;
    }
    @Override
    void calculateArea() {
        double area = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + String.format("%.2f", area));
    }
}
public class circle_radius {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length and breadth of Rectangle: ");
        double l = sc.nextDouble();
        double b = sc.nextDouble();
        Shape rect = new Rectangle(l, b);
        rect.calculateArea();
        System.out.print("Enter radius of Circle: ");
        double r = sc.nextDouble();
        Shape circ = new Circle(r);
        circ.calculateArea();
        sc.close();
    }
}