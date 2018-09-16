package crackingthecodinginterview.StackAndQueue;

/**
 * Created by Bi on 9/16/18.
 */
public class ThreeInOne {
    int numOfStacks = 3;
    int capacity;
    int[] values;
    int[] sizes;

    public ThreeInOne(int capacity) {
        this.capacity = capacity;
        values = new int[capacity * this.numOfStacks];
        sizes = new int[numOfStacks];
    }

    public void push(int stackNum, int value) {
        if (isFull(stackNum)) {
            throw new Error("Stack is full");
        }

        values[stackNum * capacity + sizes[stackNum]] = value;
        ++sizes[stackNum];
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new Error("Stack is empty");
        }

        sizes[stackNum]--;
        return values[capacity * stackNum + sizes[stackNum]];
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new Error("Stack is empty");
        }

        return values[capacity * stackNum + sizes[stackNum] - 1];
    }

    public boolean isFull(int stackNum) {
        return sizes[stackNum] == capacity;
    }

    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    public int size(int stackNum) {
        return sizes[stackNum];
    }

    public void print(int stackNum) {
        for (int i = stackNum * capacity; i < stackNum * capacity + sizes[stackNum]; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        ThreeInOne threeInOne = new ThreeInOne(10);
        threeInOne.push(0, 1);
        threeInOne.push(0, 2);
        threeInOne.push(0, 3);
        threeInOne.push(0, 4);
        threeInOne.push(0, 5);
        threeInOne.push(0, 6);
        threeInOne.push(0, 7);

        threeInOne.push(1, 11);
        threeInOne.push(1, 22);
        threeInOne.push(1, 33);
        threeInOne.push(1, 44);
        threeInOne.push(1, 55);
        threeInOne.push(1, 66);
        threeInOne.push(1, 77);

        threeInOne.push(2, 111);
        threeInOne.push(2, 222);
        threeInOne.push(2, 333);

        threeInOne.print(0);
        threeInOne.print(1);
        threeInOne.print(2);

        System.out.println(threeInOne.size(0));
        System.out.println(threeInOne.size(1));
        System.out.println(threeInOne.size(2));

        System.out.println(threeInOne.peek(2));
        System.out.println(threeInOne.pop(2));
        System.out.println(threeInOne.pop(2));
        System.out.println(threeInOne.pop(2));
//        System.out.println(threeInOne.pop(2));


    }


}
