
import java.util.*;

public class Collection_Queue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(9);
        q.add(7);
        q.add(6);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            
        }
    }
}
