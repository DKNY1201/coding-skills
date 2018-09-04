package crackingthecodinginterview.LinkedList;

/**
 * Created by Bi on 9/3/18.
 */
public class NodeUtils {
    public static void print(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node generate(int numOfNodes) {
        Node head = new Node(0);
        for (int i = 1; i < numOfNodes; i++) {
            Node n = new Node(i);
            n.next = head;
            head = n;
        }
        return head;
    }
}
