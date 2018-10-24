package leetcode.String;

import java.util.HashMap;

/**
 * Created by Bi on 10/13/18.
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(10));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
        System.out.println(intToRoman(3999));
        System.out.println(intToRoman(3888));
        System.out.println(intToRoman2(3072));
    }

    public static String intToRoman(int num) {
        HashMap<Integer, String> hash = new HashMap<>();
        hash.put(1, "I");
        hash.put(2, "II");
        hash.put(3, "III");
        hash.put(4, "IV");
        hash.put(5, "V");
        hash.put(6, "VI");
        hash.put(7, "VII");
        hash.put(8, "VIII");
        hash.put(9, "IX");
        hash.put(10, "X");
        hash.put(20, "XX");
        hash.put(30, "XXX");
        hash.put(40, "XL");
        hash.put(50, "L");
        hash.put(60, "LX");
        hash.put(70, "LXX");
        hash.put(80, "LXXX");
        hash.put(90, "XC");
        hash.put(100, "C");
        hash.put(200, "CC");
        hash.put(300, "CCC");
        hash.put(400, "CD");
        hash.put(500, "D");
        hash.put(600, "DC");
        hash.put(700, "DCC");
        hash.put(800, "DCCC");
        hash.put(900, "CM");
        hash.put(1000, "M");
        hash.put(2000, "MM");
        hash.put(3000, "MMM");

        if (hash.containsKey(num)) {
            return hash.get(num);
        }

        // Get number of num
        int temp = num;
        int dec = 0;
        while (temp > 0) {
            temp /= 10;
            dec++;
        }

        // Add each number of num to an array
        int[] arr = new int[dec];
        int j = 0;
        while (num > 0) {
            int i = num % 10;
            num /= 10;
            arr[j++] = i;
        }

        // Get String value of each number of num
        int c = dec - 1;
        StringBuilder sb = new StringBuilder();

        for (int i = dec - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                int b = (int) (arr[i] * Math.pow(10, c));
                sb.append(hash.get(b));
            }
            c--;
        }

        return sb.toString();
    }

    public static String intToRoman2(int num) {
        StringBuilder res = new StringBuilder();
        int tmp;
        tmp = num / 1000;
        for (int i = 0; i < tmp; i++) {
            res.append('M');
        }
        num = num - tmp * 1000;
        if (num >= 900) {
            res.append("CM");
            num = num - 900;
        }
        if (num >= 500) {
            res.append("D");
            num = num - 500;
        }
        if (num >= 400) {
            res.append("CD");
            num = num - 400;
        }
//Hundred
        tmp = num / 100;
        for (int i = 0; i < tmp; i++) {
            res.append("C");
        }
        num = num - tmp * 100;
        if (num >= 90) {
            res.append("XC");
            num = num - 90;
        }
        if (num >= 50) {
            res.append("L");
            num = num - 50;
        }
        if (num >= 40) {
            res.append("XL");
            num = num - 40;
        }
//ten
        tmp = num / 10;
        for (int i = 0; i < tmp; i++) {
            res.append("X");
        }
        num = num - tmp * 10;
        if (num >= 9) {
            res.append("IX");
            num = num - 9;
        }
        if (num >= 5) {
            res.append("V");
            num = num - 5;
        }
        if (num >= 4) {
            res.append("IV");
            num = num - 4;
        }
        for (int i = 0; i < num; i++) {
            res.append("I");
        }
        return res.toString();
    }
}
