package crackingthecodinginterview.StackAndQueue;

import java.util.Stack;

/**
 * Created by Bi on 9/16/18.
 */
public class QueueViaStacks {
    Stack<Integer> pushingStack, poppingStack;

    public QueueViaStacks() {
        pushingStack = new Stack<>();
        poppingStack = new Stack<>();
    }

    public int size() {
        return pushingStack.size() + poppingStack.size();
    }

    public boolean isEmpty() {
        return pushingStack.size() + poppingStack.size() == 0;
    }

    public void push(int val) {
        pushingStack.push(val);
    }

    public int pop() {
        if (isEmpty()) {
            throw new Error("Queue is empty");
        }

        moveElesFromPushingToPopping();
        return poppingStack.pop();
    }

    public int peek() {
        if (isEmpty()) {
            throw new Error("Queue is empty");
        }

        moveElesFromPushingToPopping();
        return poppingStack.peek();
    }

    public void moveElesFromPushingToPopping() {
        if (poppingStack.isEmpty()) {
            while (!pushingStack.isEmpty()) {
                poppingStack.push(pushingStack.pop());
            }
        }
    }

    public void print() {
        while (!this.isEmpty()) {
            System.out.print(this.pop() + " ");
        }
    }

    public static void main(String[] args) {
        QueueViaStacks queueViaStacks = new QueueViaStacks();

        queueViaStacks.push(1);
        queueViaStacks.push(2);
        queueViaStacks.push(3);
        queueViaStacks.push(4);
        queueViaStacks.push(5);
        queueViaStacks.push(6);
        queueViaStacks.push(7);

        System.out.println(queueViaStacks.size());
        System.out.println(queueViaStacks.peek());
        System.out.println(queueViaStacks.pop());
        System.out.println(queueViaStacks.pop());
        System.out.println(queueViaStacks.pop());
        System.out.println(queueViaStacks.pop());
        System.out.println(queueViaStacks.pop());
        System.out.println(queueViaStacks.pop());
        System.out.println(queueViaStacks.pop());
//        System.out.println(queueViaStacks.pop());
//        queueViaStacks.print();
    }
}
