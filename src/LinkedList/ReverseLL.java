package LinkedList;
public class ReverseLL {
    public static void main(String[] args) {
        ListNode head = new ListNode(2, new ListNode(4, new ListNode(3, new ListNode(9))));
        ListNode res = reverseList(head);
        printList(res);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }
}

class ListNode1 {
    public int val;
    public ListNode next;

    public ListNode1() {}

    public ListNode1(int val) {
        this.val = val;
    }

    public ListNode1(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
