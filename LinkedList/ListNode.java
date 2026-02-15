public class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }
}

class Solution {

    public static ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val) {
            head = head.next;  
        }

        ListNode curr = head;

        while(curr != null && curr.next != null){
            if(curr.next.val == val){
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // create list 5 → 6 → 7 → 4
        ListNode head = new ListNode(5);
        head.next = new ListNode(6);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(4);

        head = removeElements(head, 5);

        printList(head);
    }
}
