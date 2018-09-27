package crackingthecodinginterview.StackAndQueue;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.add(9);
        s.add(91);
        s.add(4);
        s.add(7);
        s.add(1);
        s.add(9);
        s.add(6);
        s.add(7);
        s.add(2);

        Stack s1 = sort(s);

        while (!s1.isEmpty()) {
            System.out.print(s1.pop() + " ");
        }
    }

    public static Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();

        while (!s.isEmpty()) {
            int temp = s.pop();

            while (!r.isEmpty() && r.peek() < temp) {
                s.push(r.pop());
            }

            r.push(temp);
        }

        return r;
    }
}