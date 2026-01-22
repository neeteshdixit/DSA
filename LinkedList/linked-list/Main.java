public class Main {

    Node head = null;
    //insert at beginning
    public void insertAtBeginning(int item){

        Node newnode = new Node(item);

        if(head == null){
            head = newnode;
             return;
        } else{
            newnode.next = head;
            head = newnode;
        }
    }

    // insert at end
    public void insertAtEnd(int item){

        Node newnode = new Node(item);

        if(head==null){
            head = newnode;
            return;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newnode;
    }

    // insert at position
    public void insertAtPosition(int position, int item){

        Node newnode = new Node(item);

        if(position == 0){
            newnode.next = head;
            head = newnode;
            return;
        }

        Node temp = head;
        int index =0;
        while(temp != null && index < position-1){
           temp = temp.next;
            index++;
    }
              newnode.next = temp.next;
              temp.next = newnode;

    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
     public static void main(String[] args) {
        Main list = new Main();
         list.insertAtBeginning(5);
        list.insertAtEnd(10);
        list.insertAtPosition(1, 7);
        list.display();
    }
}
