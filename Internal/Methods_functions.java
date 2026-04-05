import java.util.*;
class Student{
    String name;
    int age;
    String branch;
    double percentage;
    void display(){
        System.out.println("Your name is :"+name);
        System.out.println("Your age is: "+age);
    }
    void playdis(){
        System.out.println("Your Branch is: "+branch);
        System.out.println("Your Percentage: "+percentage);
    }
}
public class Methods_functions {
    public static void main(String[] args) {
        Scanner k=new Scanner(System.in);
        Student s=new Student();
        System.out.print("Enter Your name: ");
        s.name=k.next();
        System.out.print("Enter Your age: ");
        s.age=k.nextInt();
        s.display();
        System.out.println("Enter Your Branch: ");
        s.branch=k.next();
        System.out.println("Enter Your Percentage: ");
        s.percentage=k.nextDouble();
        s.playdis();
        
    }
}
