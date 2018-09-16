package crackingthecodinginterview.LinkedList;

/**
 * Created by Bi on 9/15/18.
 */
public class Intersection {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(7);
        Node node3 = new Node(9);
        Node node4 = new Node(10);
        Node node5 = new Node(12);
        Node node6 = new Node(14);

        Node head2 = new Node(4);
        Node node22 = new Node(6);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        head2.next = node22;
        node22.next = node4;

        NodeUtils.print(head);
        NodeUtils.print(head2);

        System.out.println(findIntersection(head, head2).data);
    }

    public static Node findIntersection(Node head1, Node head2) {
        Result2 res1 = findLenthAndTail(head1);
        Result2 res2 = findLenthAndTail(head2);

        if (res1.tail != res2.tail) {
            return null;
        }

        int difLen = Math.abs(res1.len - res2.len);

        Node longNode = res1.len > res2.len ? head1 : head2;
        Node shortNode = res1.len > res2.len ? head2 : head1;

        int temp = 0;

        while (temp < difLen) {
            longNode = longNode.next;
            temp++;
        }

        while (longNode != shortNode) {
            longNode = longNode.next;
            shortNode = shortNode.next;
        }

        return longNode;
    }

    public static Result2 findLenthAndTail(Node head) {
        if (head == null) {
            return null;
        }

        int len = 0;

        while (head != null) {
            head = head.next;
            len++;
        }

        return new Result2(head, len);
    }
}

class Result2 {
    public Node tail;
    public int len;

    public Result2(Node tail, int len) {
        this.tail = tail;
        this.len = len;
    }
}