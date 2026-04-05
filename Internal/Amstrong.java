import java.util.*;
public class Amstrong {
    public static void main(String[] args){
        Scanner k=new Scanner(System.in);
        int n=k.nextInt();
        int t=n;
        int s=0,r;
        while(t!=0){
            r=t%10;
            s= s+ (r*r*r);
            t=t/10;
        }
        if(s==n){
            System.out.println("Amstrong");
        }
        else{
            System.out.println("Not Armstrong");
        }
    }
}
