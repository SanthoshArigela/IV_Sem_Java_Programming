import java.util.*;
public class Remove_d {
    public static void main(String[] args){
        Scanner k=new Scanner(System.in);
        int n=k.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=k.nextInt();
        }
        Arrays.sort(a);
        Set<Integer> set=new LinkedHashSet<>();
        for(int i:a){
            set.add(i);
        }
        System.out.println(set);
    }
}
