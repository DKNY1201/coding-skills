package Array;

/**
 * Created by Bi on 7/31/19.
 */
class ReverseSentence {
    public static void main(String[] args) {
        char[] arr = new char[]{'p', 'e', 'r', 'f', 'e', 'c', 't', ' ',
                'm', 'a', 'k', 'e', 's', ' ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};
        char[] reversed = reverseWords(arr);

        for (char c: reversed) {
            System.out.print(c);
        }
    }

    static char[] reverseWords(char[] arr) {
        int n = arr.length;
        int j = n;
        int l = 0;
        char[] res = new char[n];

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == ' ' || i == 0) {
                for (int k = i != 0 ? i + 1 : i; k < j; k++) {
                    res[l++] = arr[k];
                }

                j = i;

                if (i != 0) {
                    res[l++] = ' ';
                }
            }
        }

        return res;
    }
}