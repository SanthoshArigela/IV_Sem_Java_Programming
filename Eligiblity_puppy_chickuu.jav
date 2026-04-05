import java.util.*;
class Hello{
    public static void main(String[] args)
    {
        Scanner k=new Scanner(System.in);
        System.out.print("Could you plaese enter your name : ");
        String x=k.nextLine();
        validation(x);
    }
    static void validation(String x)
    {
        
        if(x.equals("Chickuu"))
        {
            Scanner p=new Scanner(System.in);
            System.out.println("Hello bangaram.......!");
            System.out.println("Em chesthunnav");
            System.out.println("I just used to ask you a question");
            System.out.println("Can I able to ask...? (y/n) :");
            char ch=p.next().charAt(0);
            if(ch=='y')
            {
                System.out.println("Ok let's start...!");
                System.out.println("Enter your love among your brother out of 100...? : ");
                int v=p.nextInt();
                love_annaya(v);
            }
            else
            {
                System.out.println("Baa chessav.......!");
                System.out.println("Actually Baa jarigindhi.......!!");
            }
        }
        else if(x.equals("Puppy"))
        {
            Scanner p=new Scanner(System.in);
            System.out.println("Hello Madam.......!");
            System.out.println("Em chesthunnaruuu.......");
            System.out.println("I just used to ask you a question");
            System.out.println("Can I able to ask...? (y/n) :");
            char ch=p.next().charAt(0);
            if(ch=='y')
            {
                System.out.println("Ok let's start...!");
                System.out.println("Enter your love among your bestie out of 100...? : ");
                int v=p.nextInt();
                bestie(v);
            }
            else{
                System.out.println("Thnxxx for your understanding......!!");
                System.out.println("Priority matterss........!!!!!!!!!!!");
                System.out.println("Nidhrapoo velli.............!!!!!"+"\n"+"GL.........Good Bye....! "+"\n"+"Last smile.....!!!");
            }
        }
        else
        {
            System.out.println("Hey " +x+ "\n"+ "I'm so sorry! You are not eligible for his bond..!!");
        }
    }
    static void love_annaya(int x)
    {
        if(x>=100)
        {
            for(int i=1;i<=x;i++)
            {
                System.out.println( i+ " I too Love you bangaram.........!!!!");
            }
            System.out.println("Ee love motham bayataki cheptheyy disti pettestharuu bangaruuuu");
        }
        else if(x>=90 && x<100)
        {
            for(int i=1;i<=x;i++)
            {
                System.out.println(i+" Love you sumbeli.........!!!!!!!!!!!!");
            }
        }
        else if(x>=50 && x<90)
        {
            for(int i=1;i<=x;i++)
            {
                System.out.println(i+" Baa chessav chickuuuuu......!!!!!!!!!!");
            }
        }
        else if(x>=25 && x<50)
        {
            for(int i=1;i<=x;i++)
            {
                System.out.println(i+" Chi dobbey....!!!!!!!!!!");
            }
        }
        else if(x>=0 &&x<25)
        {
            for(int i=0;i<=x;i++)
            {
                System.out.println(i+" I'm crying litreally...............!!!!!!!!!!!!!");
            }
        }
    }
    static void bestie(int x)
    {
        if(x>=100)
        {
            for(int i=1;i<=x;i++)
            {
                System.out.println( i+ " I too friend you till my soul end apart.........!!!!!!!!");
            }
            System.out.println("Disti thiyalennu nee navvuki navvaku plz....");
        }
        else if(x>=90 && x<100)
        {
            for(int i=1;i<=x;i++)
            {
                System.out.println(i+" Best friend dhagraeyy appesava nannu.........!!!!!!!!!!!!");
            }
        }
        else if(x>=50 && x<90)
        {
            for(int i=1;i<=x;i++)
            {
                System.out.println(i+" Kanisam best friend la kuda treat cheystledhaa......!!!!!!!!!!");
            }
        }
        else if(x>=25 && x<50)
        {
            for(int i=1;i<=x;i++)
            {
                System.out.println(i+" Eppudoo dhuram pedathav annukunna nv ippudeyy pettesvaaa....!!!!!!!!!!");
            }
        }
        else if(x>=0 &&x<25)
        {
            for(int i=0;i<=x;i++)
            {
                System.out.println(i+" Inka neetho undalennu..................!!!!!!!!!!!");
            }
        }

    }
}
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