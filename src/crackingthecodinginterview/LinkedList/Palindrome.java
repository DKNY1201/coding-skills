package crackingthecodinginterview.LinkedList;

/**
 * Created by Bi on 9/12/18.
 */
public class Palindrome {
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

        Node head1 = new Node(10);
        Node node11 = new Node(9);
        Node node21 = new Node(8);
        Node node31 = new Node(8);
        Node node41 = new Node(9);
        Node node51 = new Node(10);

        head1.next = node11;
        node11.next = node21;
        node21.next = node31;
        node31.next = node41;
        node41.next = node51;

        System.out.println(palindromeReverseThenCompare(head));
        System.out.println(palindromeReverseThenCompare(head1));
    }

    public static boolean palindromeReverseThenCompare(Node head) {
        Node reverseNode = null;
        Node temp = head;
        int totalNode = 0;

        while (temp != null) {
            Node newNode = new Node(temp.data);
            newNode.next = reverseNode;
            reverseNode = newNode;
            totalNode++;
            temp = temp.next;
        }

        int count = 0;

        while (count < totalNode / 2) {
            if (head.data != reverseNode.data) {
                return false;
            }

            count++;
        }

        return true;
    }
}
