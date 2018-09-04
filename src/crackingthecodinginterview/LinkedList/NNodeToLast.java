package crackingthecodinginterview.LinkedList;

/**
 * Created by Bi on 9/3/18.
 */
public class NNodeToLast {
    public static void main(String[] args) {
        Node head = NodeUtils.generate(10);
        NodeUtils.print(head);
        System.out.println(nNodeToLast(head,5).data);
        System.out.println(nNodeToLast(head,0).data);
        System.out.println(nNodeToLast(head,100));
        System.out.println(nNodeToLast(head,-100));
        System.out.println(nNodeToLast(head,9).data);
    }

    public static Node nNodeToLast(Node head, int n) {
        if (head == null || n < 0) return null;
        Node l = head;
        Node r = head;

        int i = 0;

        while (i < n) {
            r = r.next;
            if (r == null) {
                return null;
            }
            i++;
        }

        while (r.next != null) {
            l = l.next;
            r = r.next;
        }

        return l;
    }
}
