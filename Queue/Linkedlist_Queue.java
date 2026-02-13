public class Linkedlist_Queue {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queuey {
        Node front = null;
        Node rear = null;

        public boolean isEmpty() {
            return front == null && rear == null;
        }

        // enqueue
        public void add(int data) {
            Node newNode = new Node(data);

            if (rear == null) {
                front = rear = newNode;
                return;
            }

            rear.next = newNode;
            rear = newNode;
        }

        // dequeue
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int result = front.data;
            front = front.next;

            if (front == null) {
                rear = null;
            }

            return result;
        }

        // peek
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return front.data;
        }
    }

    public static void main(String[] args) {
        Queuey q = new Queuey();

        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println("Peek: " + q.peek());
        System.out.println("Removed: " + q.remove());
        System.out.println("Peek after remove: " + q.peek());
    }
}
