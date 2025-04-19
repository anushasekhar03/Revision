package LinkedList;

public class AddTwoNums {
    public static void main(String[] args) {
                // First number: 342 (2 -> 4 -> 3)
                ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));

                // Second number: 465 (5 -> 6 -> 4)
                ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

                // Add the two numbers
                ListNode result = addTwoNumbers(l1, l2);

                // Print the result (Should be 807 => 7 -> 0 -> 8)
                printList(result);
            }

            public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                ListNode dummyHead = new ListNode(0);
                ListNode curr = dummyHead;
                int carry = 0;

                while (l1 != null || l2 != null) {
                    int sum = carry;

                    if (l1 != null) {
                        sum += l1.val;
                        l1 = l1.next;
                    }

                    if (l2 != null) {
                        sum += l2.val;
                        l2 = l2.next;
                    }

                    carry = sum / 10;
                    curr.next = new ListNode(sum % 10);
                    curr = curr.next;
                }

                if (carry > 0) {
                    curr.next = new ListNode(carry);
                }

                return dummyHead.next;
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

 class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
