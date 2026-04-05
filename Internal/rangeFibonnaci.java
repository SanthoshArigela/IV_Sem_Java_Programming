import java.util.*;
public class rangeFibonnaci {
    public static void main(String[] args) {
        Scanner k=new Scanner(System.in);
        int n=k.nextInt();
        int a=0,b=1;
        int s=0;
        int next=a+b;
        while(next<=n){
            if(next%2==0){
                s+=next;
            }
            a=b;
            b=next;
            next=a+b;
        }
        System.out.println(s);
    }
}
