import java.util.*;
public class Arraylist {
    public static void main(String[] args){
        ArrayList<Integer>a=new ArrayList<>();
        a.add(10);
        a.add(20);
        a.add(30);
        a.add(40);
        Iterator<Integer> it=a.iterator();
            while(it.hasNext()){
                Integer v=it.next();
                System.out.println(v);
            }
        }
}

