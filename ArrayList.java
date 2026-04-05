import java.util.*;
class main{
    public static void main(String[] args){
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(1);
        System.out.println("ArrayList: " + al);
        HashSet<Integer> hs = new HashSet<>(al);
        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(4);
        hs.add(5);
        hs.add(1);
        System.out.println("HashSet: " + hs);

    }
}