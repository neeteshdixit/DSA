

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
        int index = 0;
        while(temp != null && index < position-1){
           temp = temp.next;
            index++;
    }
              newnode.next = temp.next;
              temp.next = newnode;

    }

    // display linked list
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // delete from beginning
    public void deleteFromBeginning(){
        if(head==null){ 
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }
    
    // delete from end
    public void deleteFromEnd(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }

        Node temp = head;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        temp.next = null;
    }

    // delete from position
    public void deleteFromPosition(int position){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        
        if(position == 0){
            head = head.next;
            return;
        }

        Node temp = head;
        int index = 0;
        while(temp.next !=null && index < position-1){
            temp = temp.next;
            index++;
        }
        temp.next = temp.next.next;
    }
     
    
    
    public static void main(String[] args) {
        Main list = new Main();
         list.insertAtBeginning(5);
        list.insertAtEnd(10);
        list.insertAtPosition(1, 7);
        list.display();
    }
}
