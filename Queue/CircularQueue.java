public class CircularQueue {
     static class Queuesy {
       static int arr[];
        static int size;
        static int rear = -1;
        static int front = -1;

        public Queuesy(int n) {
            arr = new int[n];
            size = n;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull(){
            return (rear+1)%size == front;
        }
        // enqueue
        public void add(int num) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if(front == -1){
                front = 0;
            }

            rear = (rear+1)%size;
            arr[rear] = num;
        }

        // remove
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int result = arr[front];
            if(rear == front){
                rear = front = -1;
            }else{
                front = (front+1) % size;
            }
            return result;
        }

        // peek
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queuesy q = new Queuesy(2); 

        q.add(1);
        q.add(2);
        q.add(3);
        

        System.out.println("Peek: " + q.peek());
        System.out.println("Removed: " + q.remove());
        q.add(7);
        q.add(14);
        System.out.println("Peek after remove: " + q.peek());
    }
}
