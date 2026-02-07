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

        public static int pop(int data){
            if(isEmpty()){
                return -1;
            }
             int top = head.data;
             head = head.next;
             return top;
        }

        public static int peek(){
            if(isEmpty()){
                return -1;
            }

            return head.data;
        }

    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);

        while(s.isEmpty()){
            System.out.println("Before pop"+s.peek());
        }

        s.pop(4);
        s.pop(5);

        while(s.isEmpty()){
            System.out.println("After pop"+s.peek());
        }
    }
}