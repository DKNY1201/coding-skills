package crackingthecodinginterview.LinkedList;

import java.util.HashSet;

/**
 * Created by Bi on 8/7/18.
 */
public class DeleteDups {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

//        myLinkedList.generate(10);
//        myLinkedList.print();

        myLinkedList.head = new Node(2);
        Node node1 = new Node(2);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(3);
        Node node5 = new Node(3);
        Node node6 = new Node(2);
        Node node7 = new Node(3);
        Node node8 = new Node(2);
        myLinkedList.head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        myLinkedList.print();
        MyLinkedList myLinkedListNoDups = removeDups(myLinkedList);
        myLinkedListNoDups.print();

        MyLinkedList myLinkedListNoDups2 = removeDups(myLinkedList);
        myLinkedListNoDups2.print();
    }

    public static MyLinkedList removeDups(MyLinkedList myLinkedList) {
        HashSet<Integer> set = new HashSet<>();

        Node temp = myLinkedList.head;
        Node prev = temp;

        while (temp != null) {
            if (set.contains(temp.data)) {
                prev.next = temp.next;
            } else {
                set.add(temp.data);
                prev = temp;
            }

            temp = temp.next;
        }

        return myLinkedList;
    }

    public static MyLinkedList removeDups2(MyLinkedList myLinkedList) {
        Node temp = myLinkedList.head;

        while (temp != null) {
            Node temp1 = temp.next;
            Node prev = temp;

            while (temp1 != null) {
                if (temp1.data == temp.data) {
                    prev.next = temp1.next;
                } else {
                    prev = temp1;
                }
                temp1 = temp1.next;
            }

            temp = temp.next;
        }

        return myLinkedList;
    }
}
