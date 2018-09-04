package crackingthecodinginterview.LinkedList;

/**
 * Created by Bi on 9/3/18.
 */
public class Partition {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node node1 = new Node(20);
        Node node2 = new Node(30);
        Node node3 = new Node(8);
        Node node4 = new Node(1);
        Node node5 = new Node(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        NodeUtils.print(head);
        NodeUtils.print(partition(head, 9));
        NodeUtils.print(partition(head, 0));
        NodeUtils.print(partition(head, 100));
        NodeUtils.print(partition(head, 30));
    }

    public static Node partition(Node head, int pivot) {
        Node lower = null;
        Node greater = null;

        while (head != null) {
            Node newNode = new Node(head.data);
            if (head.data < pivot) {
                if (lower == null) {
                    lower = newNode;
                } else {
                    newNode.next = lower;
                    lower = newNode;
                }
            } else {
                if (greater == null) {
                    greater = newNode;
                } else {
                    newNode.next = greater;
                    greater = newNode;
                }
            }
            head = head.next;
        }

        if (greater == null) {
            return lower;
        }

        if (lower == null) {
            return greater;
        }

        Node temp = lower;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = greater;

        return lower;
    }
}
