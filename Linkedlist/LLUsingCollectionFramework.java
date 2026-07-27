import java.util.LinkedList;
import java.util.Iterator;

public class LLUsingCollectionFramework {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();

        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);

        System.out.println(ll);

        for (int value : ll) {
            System.out.print(value + "->");
        }
        System.out.println("null");

        for (int i = 0; i < ll.size(); i++) {
            System.out.print(ll.get(i) + " ");
        }
        System.out.println();

        Iterator<Integer> it = ll.iterator();

        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        
        ll.forEach(value -> System.out.print(value + " "));
        System.out.println();

        ll.forEach(System.out::println);
        System.out.println();
    }

}
