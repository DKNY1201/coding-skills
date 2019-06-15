package String;

/**
 * Created by Bi on 6/14/19.
 */
public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverse("kevin"));
        System.out.println(reverse(""));
        System.out.println(reverse("abc"));
    }

    public static String reverse(String s) {
        if (s.length() == 0 || s.length() == 1) return s;
        return helper(s, s.length() - 1);
    }

    public static String helper(String s, int i) {
        if (i == 0) {
            return s;
        }

        return s.charAt(i) + helper(s.substring(0, i), i - 1);
    }
}
