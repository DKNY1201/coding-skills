package String;

/**
 * Utility class for substring problems
 */
public class Suffix implements Comparable<Suffix> {
    String text;
    int index;
    // For concatenate strings from LongestCommonSubStringOfKStringsInMultipleStrings problem
    int stringOrder;

    public Suffix(String text, int index, int stringOrder) {
        this.text = text;
        this.index = index;
        this.stringOrder = stringOrder;
    }

    public char charAt(int i) {
        return text.charAt(index + i);
    }

    public String toString() {
        return text.substring(index) + ". Index: " + index + ". String order: " + stringOrder;
    }

    public int length() {
        return text.length() - index;
    }

    public int compareTo(Suffix that) {
        if (this == that) return 0;

        // n is length of shorter string
        // Only need to compare till the end of shorter string
        int n = this.length() < that.length() ? this.length() : that.length();

        for (int i = 0; i < n; i++) {
            if (this.charAt(i) < that.charAt(i)) {
                return -1;
            } else if (this.charAt(i) > that.charAt(i)) {
                return 1;
            }
        }

        // If all chars are equal than compare their length
        // aab
        // aabc
        return this.length() - that.length();
    }
}