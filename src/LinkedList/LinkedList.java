package LinkedList;

public class LinkedList {
    public static void main(String[] args) {
        int arr[]={3,4,5,7,8,10};
        Node head=arrayToLL(arr);
        System.out.println(head.data);
        printLinkedList(head);
//        int length=lengthofLL(head);
//        System.out.println(length);
//        int ispresent=checkLL(head,90);
//        System.out.println(ispresent);
//        Node deleteHead=deleteHead(head);
//        System.out.println(deleteHead.data);
//        head=deleteTail(head);
//        System.out.println("after removing tail");
        //head=deleteK(head,6);
//        head=deleteele(head,8);
//        printLinkedList(head);
//        LinkedList.Node y=new LinkedList.Node(arr[0]);
//       System.out.println(y.data);
        //head=addEleHead(head,2);
       // head=addEleLast(head,20);
        head=addElementK(head,67,4);
        printLinkedList(head);

    }
    public static Node arrayToLL(int arr[]){
        Node head=new Node(arr[0]);
        Node mover=head;
        for(int i=1;i<arr.length;i++){
            Node temp=new Node(arr[i]);
            mover.next=temp;
            mover=temp;
        }
        return head;
    }
    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static int lengthofLL(Node head) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + " -> ");
            temp = temp.next;
            count++;
        }
        return count;
    }
    public static int checkLL(Node head,int val) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == val)
            return 1;
            temp = temp.next;
        }
        return 0;
    }
    public static Node deleteHead(Node head){
        if(head==null){
            return null;
        }
        Node temp=head;
        head=head.next;
        return head;
    }
    public static Node deleteTail(Node head){
        Node temp=head;
        if(head==null || head.next==null){
            return null;
        }
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
        return head;
    }
    public static Node deleteK(Node head,int k){
        if(head==null) return null;
        if(k==1){
            Node temp=head;
            head=head.next;
            return head;
        }
        int cnt=0;
        Node temp=head;
        Node prev=null;
        while(temp!=null){
            cnt++;
            if(cnt==k){
                prev.next=prev.next.next;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        return head;
    }
    public static Node deleteele(Node head,int ele){
        if(head==null) return null;
        if(head.data==ele){
            Node temp=head;
            head=head.next;
            return head;
        }
        Node temp=head;
        Node prev=null;
        while(temp!=null){
            if(temp.data==ele){
                prev.next=prev.next.next;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        return head;
    }
    public static Node addEleHead(Node head,int ele) {
        Node temp = new Node(ele,head);
        temp.next = head;
        return temp;
    }
    public static Node addEleLast(Node head,int ele){
        if(head==null){
            return new Node(ele);
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node newNode=new Node(ele);
        temp.next=newNode;
       return head;
    }
    public static Node addElementK(Node head,int ele,int K){
        if(head==null) return null;
        if(K==1){
            return new Node(ele,head);
        }
        int cnt=0;
        Node temp=head;
        while(temp!=null){
            cnt++;
            if(cnt==K-1){
                Node x=new Node(ele,head);
                x.next=temp.next;
                temp.next=x;
            }
            temp=temp.next;
        }
        return head;
    }
}
class Node{
    int data;
    Node next;
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    Node(int data){
        this.data=data;
        this.next=null;
    }
}

/*
### **Steps You Performed in Simple Terms**

1️⃣ **Created a `LinkedList.Node` class**
   - Each node stores a number (`data`) and a link (`next`) to the next node.
   - Two constructors:
     - One takes `data` and `next`.
     - One takes only `data` and sets `next` to `null`.

2️⃣ **Defined `arrayToLL(int arr[])` method**
   - Converts an array into a linked list.
   - Created the **head node** using the first element.
   - Used a `mover` pointer to **add more nodes** from the array.
   - Linked all nodes together and returned `head`.

3️⃣ **Defined `printLinkedList(LinkedList.Node head)` method**
   - Loops through the linked list.
   - Prints each node’s `data` followed by `" -> "`.
   - Stops when reaching `null`.

4️⃣ **In the `main` method:**
   - Created an **array** `{3,4,5,7,8,10}`.
   - Converted it to a linked list using `arrayToLL()`.
   - Printed the **first node’s data** (`res.data`).
   - Printed the **entire linked list** using `printLinkedList()`.

✅ **Output Example:**
```
3
3 -> 4 -> 5 -> 7 -> 8 -> 10 -> null
```

Steps to Delete the K-th Node
1️⃣ Check if the list is empty (head == null)

If yes, return null because there’s nothing to delete.
2️⃣ If k == 1, delete the head node

Store the current head in a temp variable.
Move head to head.next (next node becomes the new head).
Return the updated head.
3️⃣ Initialize pointers and traverse to the (k-1)th node (just before the node to delete)

Start traversal with temp = head and prev = null.
Maintain a count variable (cnt = 0).
While looping, update cnt++ and move temp to the next node.
Keep track of the previous node (prev = temp).
4️⃣ If cnt == k, remove the k-th node

Make prev.next = prev.next.next to skip the k-th node.
5️⃣ Return the updated head

If k is out of bounds (greater than list size), nothing changes.
Otherwise, the k-th node is removed successfully

That's it! You successfully converted an array into a linked list and printed it. 🚀
 */