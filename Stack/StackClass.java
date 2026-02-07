public class StackClass {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        private Node head;

        public boolean isEmpty() {
            return head == null;
        }

        public void push(int data) {
            Node newnode = new Node(data);

            if (isEmpty()) {
                head = newnode;
                return;
            }

            newnode.next = head;
            head = newnode;
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }

            int top = head.data;
            head = head.next;
            return top;
        }

        public int peek() {
            if (isEmpty()) {
                return -1;
            }

            return head.data;
        }

        public void printStack(String label) {
            System.out.println(label);
            for (Node curr = head; curr != null; curr = curr.next) {
                System.out.println(curr.data);
            }
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

        s.printStack("Before pop");

        s.pop();
        s.pop();

        s.printStack("After pop");
    }
}
