package LinkedListAndTree;

/**
 * Created by Bi on 8/23/18.
 */
public class NthFromEnd {
    public static void main(String[] args) {
        Node head = generateNode(10);
        printLinkedList(head);

        System.out.println(getNthFromEnd(head, 5) != null ? getNthFromEnd(head, 5).val : "null");
        System.out.println(getNthFromEnd(head, 11) != null ? getNthFromEnd(head, 11).val : "null");
        System.out.println(getNthFromEnd(head, 0) != null ? getNthFromEnd(head, 0).val : "null");
        System.out.println(getNthFromEnd(head, 8) != null ? getNthFromEnd(head, 8).val : "null");
        System.out.println(getNthFromEnd(null, 5) != null ? getNthFromEnd(null, 5).val : "null");
    }

    public static Node generateNode(int n) {
        Node head = new Node(1);

        for (int i = 2; i <= n; i++) {
            Node newNode = new Node(i);
            newNode.next = head;
            head = newNode;
        }

        return head;
    }

    public static void printLinkedList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println("");
        System.out.println("======================");
    }

    public static Node getNthFromEnd(Node head, int n) {
        Node l = head;
        Node r = head;

        for (int i = 0; i < n; i++) {
            if (r == null) {
                return null;
            }
            r = r.next;
        }

        while (r != null) {
            l = l.next;
            r = r.next;
        }

        return l;
    }
}
