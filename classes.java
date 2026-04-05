import java.util.Scanner;
class Animal{
    int x;
    void makeSound()
    {
        System.out.println("Animal can make a sound");
    }
    void Eats()
    {
        System.out.println("Animal can eat");
    }
    void print()
    {
        System.out.println("The number is: "+x);
    }
}
class Classes{
    public static void main(String[] args)
    {
        Scanner k=new Scanner(System.in);
        Animal a=new Animal();
        a.makeSound();
        a.Eats();
        a.x=k.nextInt();
        a.print();
    }
}