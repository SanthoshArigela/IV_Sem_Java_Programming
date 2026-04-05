import java.util.*;
public class Set_comparision {
    public static void main(String[] args) {
        Set<String> hashset=new HashSet<>();
        Set<String> treeset=new TreeSet<>();
        String[] fruits={"Mango","Apple","Banana","Water melon","Papaya"};
        for(String i:fruits){
            hashset.add(i);
            treeset.add(i);
        }
        Iterator<String> hashit=hashset.iterator();
        while(hashit.hasNext()){
            System.out.println(hashit.next());
        }
        System.out.println();
        Iterator<String> treeit=treeset.iterator();
        while(treeit.hasNext()){
            System.out.println(treeit.next());
        }

    }
}
