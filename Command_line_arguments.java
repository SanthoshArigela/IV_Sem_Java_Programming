// Commandline Arguments:
// =====================
// The argument which are passed through command prompt at the time of program execution are called Commandline arguments.

// All the commandline arguments are stored in the String array which are passed in main method.

// Example-1
// ---------
// class commandLineArgument
// {
//     public static void main(String[] args) {
//         String s=args[0];
//         System.out.println("Hello,"+s+"!");
//     }
// }

// Output:
// -------
// D:\javaPrograms\Java class Programs>javac commandLineArgument.java

// D:\javaPrograms\Java class Programs>java commandLineArgument saikala

// Hello,saikala!

// Example-2:
// ----------


// Output:
// -------
// D:\javaPrograms\Java class Programs>javac commandLineArgument.java

// D:\javaPrograms\Java class Programs>java commandLineArgument java programming

// Concatenated String: javaprogramming

// Example-3:
// ----------
// class CommandLineArgument
// {
//     public static void main(String[] args) {
//        int a=Integer.parseInt(args[0]);
//        int b=Integer.parseInt(args[1]);
//        int c=Integer.parseInt(args[2]);
//        System.out.println("sum:"+(a+b+c));
//     }
// }

// output:
// -------

// D:\javaPrograms\Java class Programs>javac commandLineArgument.java

// D:\javaPrograms\Java class Programs>java commandLineArgument 7 8 9

// sum:24

// Example-4:
// ----------
// class commandLineArgument
// {
//     public static void main(String[] args) {
//         for(int i=0;i<args.length;i++)
//         {
//             System.out.println(args[i]);
//         }
//     }
// }

// output:
// ------
// D:\javaPrograms\Java class Programs>javac commandLineArgument.java

// D:\javaPrograms\Java class Programs>java commandLineArgument java c cpp python

// java 
// c 
// cpp 
// python