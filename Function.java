import java.util.*;
class Function {
    public static int Factorial(int n) {
        if(n==0 || n==1) return 1;
        return n*Factorial(n-1);
    }
    public static void main(String[] args) {
        Scanner k=new Scanner(System.in);
        int n=k.nextInt();
        System.out.println("Factorial of "+n+" is: "+Factorial(n));
        k.close();
    }
}
