import java.util.*;
public class permutation {
    public static void main(String[] args) {
        Scanner k=new Scanner(System.in);
        String s=k.next();
        System.out.println("Permutations are: ");
        permutation(s,"");
    }
    public static void permutation(String s,String a){
        if(s.length()==0)
        {
            System.out.println(a);
            return;
        }
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            String r=s.substring(0,i)+s.substring(i+1);
            permutation(r,c+ a);
        }
    }
}
