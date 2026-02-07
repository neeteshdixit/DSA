public class StackClass{

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = next; 
        }
    }

    static class Stack{
        public static Node head;

        public static boolean isEmpty(){
            return head == null;
        }

        public static void push(int data){
            Node newnode = new Node(data);

            if(isEmpty()){
                head = newnode;
                return;
            }
            newnode.next = head;
            head = newnode;
        }

        public static void pop(int data){
            Node newnode = new Node(data);

            if(isEmpty()){
                return;
            }

            
        }

    }
    public static void main(String[] args) {
        
    }
}