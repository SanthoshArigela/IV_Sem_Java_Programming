// class Hello{
//     public static void main(String args[])
//     {
//         System.out.println("Hello");
//         System.out.println("Santhosh");
//     }
// }

// class Hello{
//     public static void main(String args[])
//     {
//         String s="Santhosh";
//         String k="Arigela";
//         System.out.println(s+" "+k);
//     }
// }

// class Hello{
//     public static void main(String[] args)
//     {
//         int k=1000;
//         int p=5000;
//         System.out.print(k+p);
//     }
// }
// class Hello{
//     public static void main(String[] args)
//     {
//         String s="Santhosh Arigela";
//         String a="AUS";
//         String b="AIML";
//         String c="24B11AI019";
//         System.out.println(s);
//         System.out.println(a);
//         System.out.println(b);
//         System.out.println(c);

//     }
// }

// class Hello{
//     public static void main(String[] args)
//     {
//         // int a=scan.nextString();
//         final int a=10;
//         byte c=127;
//         float b=75.65f;
//         // a=25;
//         System.out.println(b);
//         System.out.println(a);
//         System.out.println(c);
//     }
// }
// class Hello{
//     public static void main(String[] args)
//     {
//         var a=10;
//         a++;
//         a+=5;
//         a<<=1;

//         System.out.println(a);
//     }
// }
// import java.util.Scanner;
// class Hello{
//     public static void main(String[] args) {
//         String s="Sathosh";
//         String a="Arigela";
//         String b="Arigela";
        
//         System.out.println(s.length());
//         System.out.println(a.toUpperCase());
//         System.out.println(a.toLowerCase());
//         System.out.println(s.indexOf("th"));
//         System.out.println(a.charAt(3));
//         System.out.println(a.equals(b));
//         System.out.println(a.equals(s));
//         String k="       Hi ra           ";
//         System.out.println(k.trim());
//         System.out.println(a.concat(b));
//         System.out.println(Math.max(5,100)); 
//         System.out.println(Math.min(10,5));
//         System.out.println(Math.sqrt(64));
//         System.out.println(Math.abs(-4.5));
//         System.out.println(Math.pow(2,4));
//         System.out.println(Math.round(4.5));
//         System.out.println(Math.round(4.3));
//         System.out.println(Math.ceil(4.3));
//         System.out.println(Math.floor(4.8));
//         System.out.println(Math.random());
//         Scanner sc=new Scanner(System.in);
//         int n=sc.nextInt();
//         System.out.println((n<8)?"Less":"Greater");

//     }
// }

// import java.util.Scanner;
// class Hello{
//     public static void main(String[] args) {
//         Scanner k=new Scanner(System.in);
//         int a=k.nextInt();
//         int p=k.nextInt();
//         if(a==p)
//         {
//             System.out.println("This is a square of area :"+a*p);
//         }
//         else 
//         {
//             System.out.println("This is a rectangle: of area:"+a*p);
//         }
//     }
// }

// import java.util.Scanner;
// import javax.lang.model.util.ElementScanner14;
// class Hello{
//     public static void main(String[] args) {
//         Scanner k= new Scanner(System.in);
//         int a=k.nextInt();
//         int b=k.nextInt();
//         int c=k.nextInt();
//         if(a>b && a>c)
//         {
//             System.out.println(a);
//         }
//         else if (a>b || b>c)
//         {
//             System.out.println(b);
//         }
//         else if(!(a>b))
//         {
//             System.out.println(c);
//         }
//         else
//         {
//             System.out.println(c);
//         }
//     }
// }

// import java.util.Scanner;
// class Hello{
//     public static void main(String[] args)
//     {
//         Scanner k=new Scanner(System.in);
//         int a=k.nextInt();
//         while(a>0)
//         {
//             System.out.println(a);
//             a--;
//         }
//         System.out.println("  hello");
//         do{
//             System.out.println(a);
//             a++;
//         }
//         while(a<5);

//     }
// }
// import java.util.Scanner;
// class Hello{
//     public static void main(String[] args)
//     {
//         Scanner k=new Scanner(System.in);
//         int a=k.nextInt();
//         for(int i=0;i<a;i++){
//             System.out.println(i);
//         }

//     }
// }

// import java.util.Scanner;
// class Hello{
//     public static void main(String[] args)
//     {
//         System.out.println("Enter the numeber of rows : ");
//         Scanner k=new Scanner(System.in);
//         int a=k.nextInt();
//         System.out.println("Enter no of columns: ");
//         int b=k.nextInt();
//         int [][] x=new int[a][b];
//         System.out.println("Enter elements into the matrix : ");
//         for(int i=0;i<a;i++)
//         {
//             for(int j=0;j<b;j++)
//             {
//                 x[i][j]=k.nextInt();
//             }
//         }
//         System.out.println("The matrix is represented as : ");
//         for(int i=0;i<a;i++)
//         {
//             for(int j=0;j<b;j++)
//             {
//                 System.out.print(x[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }
// }

// import java.util.Scanner;
// class Hello{
//     public static void main(String[] args)
//     {
//         Scanner k=new Scanner(System.in);
//         int a=k.nextInt();
//         int[] p=new int[a];
//         for(int i=0;i<a;i++)
//         {
//             p[i]=k.nextInt();
//         }
//         for(int i=0;i<a;i++)
//         {
//             System.out.print(p[i] + " ");
//         }

//         String[] s=new String[a];
//         for(int i=0;i<a;i++)
//         {
//             s[i]=k.next();
//         }
//         for(int i=0;i<a;i++)
//         {
//             System.out.println(s[i] +  " ");
//         }
//     }
// }
// import java.util.Scanner;
// class Hello_world{
//     public static void main(String[] args)
//     {
//         Scanner k=new Scanner(System.in);
//         int a=k.nextInt();
//         for(int i=0;i<a;i++){
//             // System.out.println(i);
//             // if(i==5)
//             //     break;
//             if(i==3)
//             {
               
//                 continue;
//             }
//             System.out.println(i);
            
//         }
//     }
// }


// import java.util.Scanner;
// class Hello{
//     static void Santhosh()
//     {
//         System.out.println("Hello Santhosh");
//     }
    
//     public static void main(String[] args)
//     {
//         Scanner k=new Scanner(System.in);
//         int a=k.nextInt();
//         for(int i=0;i<a;i++)
//         {
//             Santhosh();
//             Santhosh();
//         }
//     }
// }

// import java.util.*;
// class Chickuuuuuu{
//     static void Puppy()
//     {
//         System.out.println("Puppy");
//     }
//     static void chickuu(){
//         System.out.println("Chickuu bangaram ");
//     }
//     public static void main(String[] args)
//     {
//         Scanner k=new Scanner(System.in);
//         System.out.print("How many times chick want to be happy : ");
//         int x=k.nextInt();
//         for(int i=0;i<x;i++)
//         {
//             chickuu();
//         }
//         System.out.print("How many times puppy gonna blush : ");
//         int y=k.nextInt();
//         for(int i=0;i<y;i++)
//         {
//             Puppy();
//         }
//         System.out.println("A small gift from panda......");

//     }
// }
// import java.util.*;
// class Hello{
//     public static void main(String[] args)
//     {
//         Scanner k=new Scanner(System.in);
//         System.out.print("Could you plaese enter your name : ");
//         String x=k.nextLine();
//         validation(x);
//         System.out.println("\n"+"\n"+"Uma devi kullipoooku......!!!");
//     }
//     static void validation(String x)
//     {
        
//         if(x.equals("Chickuu"))
//         {
//             Scanner p=new Scanner(System.in);
//             System.out.println("Hello bangaram.......!");
//             System.out.println("Em chesthunnav");
//             System.out.println("I just used to ask you a question");
//             System.out.println("Can I able to ask...? (y/n) :");
//             char ch=p.next().charAt(0);
//             if(ch=='y')
//             {
//                 System.out.println("Ok let's start...!");
//                 System.out.println("Enter your love among your brother out of 100...? : ");
//                 int v=p.nextInt();
//                 love_annaya(v);
//             }
//             else
//             {
//                 System.out.println("Baa chessav.......!");
//                 System.out.println("Actually Baa jarigindhi.......!!");
//             }
//         }
//         else if(x.equals("Puppy"))
//         {
//             Scanner p=new Scanner(System.in);
//             System.out.println("Hello Madam.......!");
//             System.out.println("Em chesthunnaruuu.......");
//             System.out.println("I just used to ask you a question");
//             System.out.println("Can I able to ask...? (y/n) :");
//             char ch=p.next().charAt(0);
//             if(ch=='y')
//             {
//                 System.out.println("Ok let's start...!");
//                 System.out.println("Enter your love among your bestie out of 100...? : ");
//                 int v=p.nextInt();
//                 bestie(v);
//             }
//             else{
//                 System.out.println("Thnxxx for your understanding......!!");
//                 System.out.println("Priority matterss........!!!!!!!!!!!");
//                 System.out.println("Nidhrapoo velli.............!!!!!"+"\n"+"GL.........Good Bye....! "+"\n"+"Last smile.....!!!");
//             }
//         }
//         else
//         {
//             System.out.println("Hey " +x+ "\n"+ "I'm so sorry! You are not eligible for his bond..!!");
//         }
//     }
//     static void love_annaya(int x)
//     {
//         if(x>=100)
//         {
//             for(int i=1;i<=x;i++)
//             {
//                 System.out.println( i+ " I too Love you bangaram.........!!!!");
//             }
//             System.out.println("Ee love motham bayataki cheptheyy disti pettestharuu bangaruuuu");
//         }
//         else if(x>=90 && x<100)
//         {
//             for(int i=1;i<=x;i++)
//             {
//                 System.out.println(i+" Love you sumbeli.........!!!!!!!!!!!!");
//             }
//         }
//         else if(x>=50 && x<90)
//         {
//             for(int i=1;i<=x;i++)
//             {
//                 System.out.println(i+" Baa chessav chickuuuuu......!!!!!!!!!!");
//             }
//         }
//         else if(x>=25 && x<50)
//         {
//             for(int i=1;i<=x;i++)
//             {
//                 System.out.println(i+" Chi dobbey....!!!!!!!!!!");
//             }
//         }
//         else if(x>=0 &&x<25)
//         {
//             for(int i=0;i<=x;i++)
//             {
//                 System.out.println(i+" I'm crying litreally...............!!!!!!!!!!!!!");
//             }
//         }
//     }
//     static void bestie(int x)
//     {
//         if(x>=100)
//         {
//             for(int i=1;i<=x;i++)
//             {
//                 System.out.println( i+ " I too friend you till my soul end apart.........!!!!!!!!");
//             }
//             System.out.println("Disti thiyalennu nee navvuki navvaku plz....");
//         }
//         else if(x>=90 && x<100)
//         {
//             for(int i=1;i<=x;i++)
//             {
//                 System.out.println(i+" Best friend dhagraeyy appesava nannu.........!!!!!!!!!!!!");
//             }
//         }
//         else if(x>=50 && x<90)
//         {
//             for(int i=1;i<=x;i++)
//             {
//                 System.out.println(i+" Kanisam best friend la kuda treat cheystledhaa......!!!!!!!!!!");
//             }
//         }
//         else if(x>=25 && x<50)
//         {
//             for(int i=1;i<=x;i++)
//             {
//                 System.out.println(i+" Eppudoo dhuram pedathav annukunna nv ippudeyy pettesvaaa....!!!!!!!!!!");
//             }
//         }
//         else if(x>=0 &&x<25)
//         {
//             for(int i=0;i<=x;i++)
//             {
//                 System.out.println(i+" Inka neetho undalennu..................!!!!!!!!!!!");
//             }
//         }

//     }
// }

// import java.util.*;

// class Hello{
//     public static int Recursion(int a)
//     {
//         if(a>0)
//         {
//             return a+Recursion(a-1);
//         }
//         else 
//         {
//             return 0;
//         }
//     }
//     public static void main(String[] args)
//     {
//         Scanner k=new Scanner(System.in);
//         int a=k.nextInt();
//         int b=Recursion(a);
//         System.out.print(b);
//     }
// }


// import java.util.*;
// class Hello{
//     public static int Fibonacci(int a)
//     {
//     if(a<=1)
//     {
//         return a;
//     }
//     else
//     {
//         return Fibonacci(a-1) + Fibonacci(a-2);
//     }
//     }
//     public static void main(String[] args) {
//         {
//             Scanner k=new Scanner(System.in);
//             int a=k.nextInt();
//             int b=Fibonacci(a);
//             System.out.print(b);
//         }
//     }
// }

// class Hello{
//     public static void main(String[] args)
//     {
//         System.out.println("Hello chitti :"+19);
//     }
// }
// class Hello{
//     public static void main(String[] args) {
//         {
//             int x=15;
//             {
//                 int y=10;
//                 for(int i=0;i<x;i++)
//                 {
//                     System.out.println(i);
//                 }
//             }
//             System.out.println(x);
//         }
//     }
// }
// import java.util.*;
// class Hello{
//     static int hi(int i)
//     {
//         return i;
//     }
//     public static void main(String[] args)
//     {
//         Scanner k= new Scanner(System.in);
//         int x=k.nextInt();
//         for(int i=0;i<x;i++)
//         {
//             System.out.println("The numbers are :" + hi(i));
//         }
//     }
// }
// import java.util.*;


// class Hello{
//     public static long Fact( int x)
// {
//     if(x<=1)
//     {
//         return 1;
//     }
//     else
//     {
//         return x*Fact(x-1);
//     }
// }
//     public static void main(String[] args) {
//         Scanner k=new Scanner(System.in);
//         int x=k.nextInt();
//         System.out.println("The recursion of" + x+ " is : "+ Fact(x));
//     }
// }
// import java.util.*;
// class Hello{
//     public static void Countdown(int y)
//     {
//         if(y>0)
//         {
//            System.out.println("Time remaining is : "+ y );
//            Countdown(y-1);
//         }

//     }
//     public static void main(String[] args)
//     {
//         Scanner k=new Scanner(System.in);
//         int y=k.nextInt();
//         Countdown(y);
//     }
// }

// class Hello{
//     int x=10;
//     public static void main(String[] args)
//     {
//         Hello t=new Hello();
//         Hello y=new Hello();
//         System.err.println("Hello"+y.x);
//         System.out.println(t.x);
//     }
// }

// import java.util.*;
// class Hello{
//     static void teja()
//     {
//         System.out.println("Hello teja");
//     }
//     static void teja(int a)
//     {
//         for(int i=0;i<a;i++)
//         {
//             System.out.println("The numbers are :" + i);
//         }
//     }
//     public void teja(int b,int c)
//     {
//         System.out.println("The object is called --");
//         for(int i=b;i<=c;i++)
//         {
//             System.out.println("The Numbers are : "+i);
//           }
//     }
//     public static void main(String[] args)
//     {
//         Scanner k=new Scanner(System.in);
//         int a=k.nextInt();
//         int n=k.nextInt();
//         Hello b=new Hello();
//         teja();
//         teja(a);
//         b.teja(a,n);
//     }
// }
// import java.util.*;
// class Hello{
//     int x;
//     public Hello(int a)
//     {
//         x=a;
//     }
//     public static void main(String[] args)
//     {
//         Scanner k=new Scanner(System.in);
//         int a=k.nextInt();
//         Hello p=new Hello(a);
//         System.out.println(p.x);
//     }
// }

import java.util.*;
class Hello{
    public static void main(String[] args) {
        Scanner k=new Scanner(System.in);
        int a=k.nextInt();
        Hello p=new Hello();
        
    }
}