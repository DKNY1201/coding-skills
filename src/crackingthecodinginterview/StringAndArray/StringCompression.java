package crackingthecodinginterview.StringAndArray;

/**
 * Created by Bi on 9/2/18.
 */
public class StringCompression {
    public static void main(String[] args) {
        System.out.println(stringCompression("aaaAAABBCCCDDDDddddqqqqzzzzzd"));
        System.out.println(stringCompression("abcd"));
    }

    public static String stringCompression(String s) {
        StringBuilder compressedStr = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            count++;
            if (s.charAt(i) != s.charAt(i + 1)) {
                compressedStr.append(s.charAt(i) + "" + count);
                count = 0;
            }
        }

        compressedStr.append(s.charAt(s.length() - 1) + "" + ++count);

        return compressedStr.length() < s.length() ? compressedStr.toString() : s;
    }
}
