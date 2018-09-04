package crackingthecodinginterview.LinkedList;

/**
 * Created by Bi on 8/7/18.
 */
public class MyLinkedList {
    public Node head;

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.head = new Node(1);
        Node sec = new Node(2);
        Node third = new Node(3);

        myLinkedList.head.next = sec;
        sec.next = third;

        myLinkedList.print();
    }

    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void generate(int numOfNodes) {
        head = new Node(0);
        for (int i = 1; i < numOfNodes; i++) {
            Node n = new Node(i);
            n.next = head;
            head = n;
        }
    }

}

