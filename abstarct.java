abstract class Shape{
    void display()
    {
        System.out.println("This is a concrete method");
    }
    //abstract methods
    abstract double area();
    abstract double perimeter();
}
class Circle extends Shape{
    double radius;
    Circle(double radius)
    {
        this.radius=radius;
    }
    double area()
    {
        return Math.PI*radius*radius;
    }
    double perimeter()
    {
        return 2*Math.PI*radius;
    }
    void display()
    {
super. display ();
        System.out.println("Area:"+area());
        System.out.println("Perimeter:"+perimeter());
    }
}

class MainClass{
    public static void main(String[] args) {
        Shape s;
        s=new Circle(3);
        s.display();
    }
}