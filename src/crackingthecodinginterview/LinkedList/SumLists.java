package crackingthecodinginterview.LinkedList;

/**
 * Created by Bi on 9/5/18.
 */
public class SumLists {
    public static void main(String[] args) {
        Node head1 = new Node(7);
        Node node1 = new Node(1);
        Node node2 = new Node(8);
        Node node21 = new Node(9);
        Node node22 = new Node(1);
        head1.next = node1;
        node1.next = node2;
        node2.next = node21;
        node21.next = node22;

        Node head2 = new Node(5);
        Node node4 = new Node(9);
        Node node5 = new Node(2);
        head2.next = node4;
        node4.next = node5;

        Node head3 = null;
        NodeUtils.print(sumList(head1, head2));
        NodeUtils.print(sumList(head1, head3));
    }

    public static Node sumList(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        Node resHead = null;
        Node resTail = null;

        int memo = 0;

        while (temp1 != null || temp2 != null) {
            int val1 = temp1 != null ? temp1.data : 0;
            int val2 = temp2 != null ? temp2.data : 0;

            int sum = val1 + val2 + memo;
            memo = sum > 9 ? 1 : 0;
            sum = sum > 9 ? sum - 10 : sum;

            Node newNode = new Node(sum);
            if (resHead == null) {
                resHead = newNode;
            }

            if (resTail == null) {
                resTail = newNode;
            } else {
                resTail.next = newNode;
                resTail = newNode;
            }

            temp1 = temp1 != null ? temp1.next : temp1;
            temp2 = temp2 != null ? temp2.next : temp2;
        }

        if (memo == 1) {
            Node newNode = new Node(1);
            resTail.next = newNode;
        }

        return resHead;
    }
}
