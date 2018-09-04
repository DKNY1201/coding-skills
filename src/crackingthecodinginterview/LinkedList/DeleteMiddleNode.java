package crackingthecodinginterview.LinkedList;

/**
 * Created by Bi on 9/3/18.
 */
public class DeleteMiddleNode {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node node1 = new Node(9);
        Node node2 = new Node(8);
        Node node3 = new Node(7);
        Node node4 = new Node(6);
        Node node5 = new Node(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        NodeUtils.print(head);
        deleteMiddleNode(node3);
        NodeUtils.print(head);
        deleteMiddleNode(head);
        NodeUtils.print(head);
    }

    public static boolean deleteMiddleNode(Node m) {
        if (m == null || m.next == null) {
            return false;
        }

        Node next = m.next;
        m.data = next.data;
        m.next = next.next;
        return true;
    }
}
