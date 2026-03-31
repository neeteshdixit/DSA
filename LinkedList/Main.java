// public class Main {
//     public static void main(String[] args) {
//         Node ten = new Node(10);
//         Node twenty = new Node(20);
//         Node thirty = new Node(30);
//         Node fourty = new Node(40);
//         Node fifty = new Node(50);

//         Node front = new Node(5);// add in front
//         Node last = new Node(55);// add in last

        
//         Node head = front;
//         front.setNext(ten);
//         ten.setNext(twenty);
//         twenty.setNext(thirty);
//         thirty.setNext(fourty);
//         fourty.setNext(fifty);
//         fifty.setNext(last);
//         last.setNext(null);
        
//         head = insertAtFront(head, 0);
//         // printLinkedList(head);
//         // printLinkedList(head,thirty);
//         printLinkedList(head);
//         System.out.println();

//         head = deleteAtTheFirst(head);
//         printLinkedList(head);
//         System.out.println();

//         head = deleteAtTheFirst(head);
//         printLinkedList(head);
//     }
//     // public static void printLinkedList(Node head, Node StopNode){
//     public static Node deleteAtTheFirst(Node head){
//         if(head == null){
//             return null;
//         }
//         return head.getNext();
//     }
//     public static Node insertAtFront(Node head, int data){
//         Node newNode = new Node(data);
//         newNode.setNext(null);
//         if(head == null){
//             head = newNode;
//         }
//         else{
//             newNode.setNext(head);
//             head = newNode;
//         }
//         return head;
//     }
//     public static void printLinkedList(Node head){
//         Node current = head;
//         while(current != null){
//             System.out.print(current.getData()+ " ");
//             // if(current == StopNode){
//             //     break;
//             // }
//             // if(current.getData()== 30){
//             //     break;
//             // }
//             current = current.getNext();
//         }
//     }
// }

import java.util.LinkedList;
import java.util.Iterator;

public class Main{
    public static void main(String[] args) {
        LinkedList<Integer> li = new LinkedList<>();
        li.add(10);
        li.add(5);
        li.add(39);
        li.add(5);
        li.add(20);
        li.add(30);
        li.add(40);
        li.add(2, 25);
        li.remove(4);
        li.removeLastOccurrence(5);
        System.out.println(li.contains(50));
        Iterator<Integer> it = li.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }

        // Iterator<Integer> it = li.descendingIterator();
        // while(it.hasNext()){
        //     System.out.println(it.next()+" ");
        // }
    }
}