package dsa.LinkedList.doubly;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    // Add at front
    public void addFront(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = tail = newnode;
        } else {
            newnode.next = head;
            head.prev = newnode;
            head = newnode;
        }
    }

    // Add at end
    public void addEnd(int data) {
        Node newnode = new Node(data);
        if (tail == null) {
            head = tail = newnode;
        } else {
            newnode.prev = tail;
            tail.next = newnode;
            tail = newnode;
        }
    }

    // Display forward
    public void displayForward() {
        Node temp = head;
        System.out.print("Forward: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Display backward
    public void displayBackward() {
        Node temp = tail;
        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.addFront(10);
        list.addFront(20);
        list.addEnd(30);
        list.addEnd(40);

        list.displayForward();
        list.displayBackward();
    }
}
