package hackerrank;

/**
 * Created by Bi on 8/14/18.
 */
public class BitwiseAnd {
    public static void main(String[] args) {
        System.out.println(findLargestAnd(5,2));
        System.out.println(findLargestAnd(8,5));
        System.out.println(findLargestAnd(2,2));
    }

    public static int findLargestAnd(int n, int k) {
        int largestAnd = 0;

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <=n; j++) {
                int temp = i & j;
                if (temp > largestAnd && temp < k) {
                    largestAnd = temp;
                }
            }
        }

        return largestAnd;
    }
}
