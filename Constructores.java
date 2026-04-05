class Example{
    int id;
    String name;
    int age;
    Example()
    {
        System.out.println("Default constructor");
    }
    Example(int a)
    {
        id=a;
    }
    Example(int a,String s)
    {
        id=a;
        s=s;
    }
    Example(int a,String s,int b)
    {
        id=a;
        s=s;
        b=b;
    }    
    void display()
    {
        System.out.println("Id : "+id+" Name : "+name+" Age: "+age);
    }
};
class Hi{
    public static void main(String[] args)
    {
        Example obj=new Example();
        Example obj1=new Example(15);
        Example obj2=new Example(20,"Santhosh");
        Example obj3=new Example(25,"Erode",25);
        obj.display();
        obj1.display();
        obj2.display();
        obj3.display();
    }
}


