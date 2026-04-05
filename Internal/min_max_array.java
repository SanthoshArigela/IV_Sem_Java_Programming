import java.util.*;
public class min_max_array {
    public static void main(String[] args){
        Scanner k=new Scanner(System.in);
        int n=k.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=k.nextInt();
        }
        System.out.println(Arrays.stream(a).max().getAsInt());
        System.out.println(Arrays.stream(a).min().getAsInt());
    }
}