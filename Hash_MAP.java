import java.util.*;
import java.util.Map.Entry;
class Santhosh{
    public static void main(String[] args) {
        {
            HashMap<Integer,String> map=new HashMap<>();
            map.put(null,"Python");
            map.put(7,"Ruby");
            map.put(1,"C");
            map.put(2,"C#");
            map.put(null,"Cpp");
            map.put(5,"Java");
            map.put(6,"R");
            map.put(2,"HTML");
            System.out.println(map);
            for(Map.Entry<Integer,String> entry:map.entrySet())
            {
                System.out.println(entry.getKey()+"------>"+entry.getValue());
            }
            System.out.println("Size"+map.size());
            System.out.println("Keys: "+map.keySet());
            System.out.println("Values :"+map.values());
            System.out.println("Get the value with Key :"+map.get(5));
            System.out.println("Check a value :"+map.containsValue("R"));
            map.remove(1);
            map.forEach((key,value)->{
                System.out.println(key+ "---->"+value);
            });
            map.replace(5,"Java","CSS");
            System.out.println("HashMap After replacement: "+map);


        }
    }
}