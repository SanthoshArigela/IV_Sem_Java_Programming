import java.util.*;
class Hello1{
    public static void main(String[] args){
        Scanner k=new Scanner(System.in);
        int n=k.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=k.nextInt();
        }
        Arrays.sort(a);
        int j=0;
        for(int i=0;i<n-1;i++){
            if(a[i]!=a[i+1]){
                a[j++]=a[i];
            }
        }
        a[j++]=a[n-1];
        for(int i=0;i<j;i++){
            System.out.print(a[i]+" ");
        }
    }
}