import java.util.*;
class Hello{
    public static void main(String[] args) {
        Map<Integer,String>hashmap=new HashMap<>();
        hashmap.put(1,"A");
        hashmap.put(2,"B");
        hashmap.put(3,"C");
        hashmap.put(4,"D");
        hashmap.put(5,"E");
        display(hashmap);
        Map<Integer,String> treemap=new TreeMap<>(hashmap);
        display(treemap);        
    }
    public static void display(Map<Integer,String>map){
        Set<Map.Entry<Integer,String>> entries=map.entrySet();
        Iterator<Map.Entry<Integer,String>>it=entries.iterator();
        System.out.println("ID \tName");
        while(it.hasNext()){
            Map.Entry<Integer,String>entry=it.next();
            System.out.println(entry.getKey()+" \t "+entry.getValue());
        }
    }
}