import java.util.*;
public class hashtable_ {
    public static void main(String[] args) {
        Hashtable<Integer,String>hashtable=new Hashtable<>();
        hashtable.put(1,"A");
        hashtable.put(2,"B");
        hashtable.put(3,"C");
        hashtable.put(4,"D");
        hashtable.put(5,"E");

        Set<Map.Entry<Integer,String>> entries= hashtable.entrySet();
        Iterator<Map.Entry<Integer,String>> it=entries.iterator();
        while(it.hasNext()){
           Map.Entry<Integer,String> entry=it.next();
           System.out.println(entry.getKey() +" \t "+entry.getValue());

        }


    }
}
