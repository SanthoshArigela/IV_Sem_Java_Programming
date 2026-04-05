import java.util.*;
class Linked{
    public static void main(String[] args) {
        {
            LinkedList<String> list=new LinkedList();
            list.add("Santhosh");
            list.add(0,"am");
            list.addFirst("I");
            list.addLast("!");
            System.out.println("Linked List:"+list);
            list.remove("!");
            System.out.println("After Deletion:"+list);
            System.out.println(list.getFirst());
            System.out.println(list.getLast());

        }
    }
}