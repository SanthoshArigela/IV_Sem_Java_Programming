class Student{
    int id;
    String name;
    double marks;
    Student(){
        id=1;
        name="Alice";
        marks=7.56;
        System.out.println("Default Constructor");
    }
    Student(int id,String name){
        this.id=id;
        this.name=name;
        marks=6.85;
        System.out.println("Constructor 1");
    }
    Student(int id,String name,double marks){
        this.id=id;
        this.name=name;
        this.marks=marks;
        System.out.println("Constructor 2");
    }
    void display(){
        System.out.println("ID: "+id+" | Name: "+name+" |"+marks);
    }
}
public class constructor {
    public static void main(String[] args) {
        Student s1=new Student();
        s1.display();
        System.out.println();
        Student s2=new Student(2,"Arigela");
        s2.display();
        Student s3=new Student(3,"Santhosh",8.83);
        s3.display();
    }
}
