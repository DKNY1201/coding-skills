package crackingthecodinginterview.LinkedList;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Stack;

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

        Node head11 = new Node(10);
        Node node111 = new Node(9);
        Node node211 = new Node(8);
        Node node2111 = new Node(7);
        Node node311 = new Node(8);
        Node node411 = new Node(9);
        Node node511 = new Node(10);

        head11.next = node111;
        node111.next = node211;
        node211.next = node2111;
        node2111.next = node311;
        node311.next = node411;
        node411.next = node511;

        System.out.println(palindromeReverseThenCompare(head));
        System.out.println(palindromeReverseThenCompare(head1));
        System.out.println(palindromeRecursion(head));
        System.out.println(palindromeRecursion(head1));
        System.out.println(palindromeRecursion(head11));
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

    public static boolean isPalindrome(Node head) {
        Stack<Integer> firstHalf = new Stack<>();
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            firstHalf.add(slow.data);
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (!firstHalf.isEmpty()) {
            if (firstHalf.pop() != slow.data) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }

    public static boolean palindromeRecursion(Node head) {
        int len = getLengthLinkedList(head);
        Result res = palindromeRecursion(head, len);
        return res.truthy;
    }

    public static Result palindromeRecursion(Node head, int len) {
        if (len == 0) {
            return new Result(true, head);
        }

        if (len == 1) {
            return new Result(true, head.next);
        }

        Result result = palindromeRecursion(head.next, len - 2);

        if (!result.truthy || result.node == null) {
            return result;
        }

        result.truthy = head.data == result.node.data;
        result.node = result.node.next;

        return result;
    }

    public static int getLengthLinkedList(Node head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}

class Result {
    public boolean truthy;
    public Node node;

    public Result(boolean truthy, Node node) {
        this.truthy = truthy;
        this.node = node;
    }
}