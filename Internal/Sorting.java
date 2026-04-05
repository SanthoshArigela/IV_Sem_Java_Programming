import java.util.*;
public class Sorting {
    public static void main(String[] args){
        Scanner k=new Scanner(System.in);
        int n=k.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=k.nextInt();
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp=a[j+1];
                    a[j+1]=a[j];
                    a[j]=temp;
                }
            }
        }
        for(int i:a){
            System.out.print(i+" ");
        }
    }
}
