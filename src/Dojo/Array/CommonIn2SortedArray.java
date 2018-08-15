package Dojo.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bi on 8/14/18.
 */
public class CommonIn2SortedArray {
    public static void main(String[] args) {
        // NOTE: The following input values are used for testing your solution.

        int[] array1A = {1, 3, 4, 6, 7, 9};
        int[] array2A = {1, 2, 4, 5, 9, 10};
        // commonElements(array1A, array2A) should return [1, 4, 9] (an array).
        print(commonElements(array1A, array2A));
        print(commonElements2(array1A, array2A));

        int[] array1B = {1, 2, 9, 10, 11, 12};
        int[] array2B = {0, 1, 2, 3, 4, 5, 8, 9, 10, 12, 14, 15};
        // commonElements(array1B, array2B) should return [1, 2, 9, 10, 12] (an array).
        print(commonElements(array1B, array2B));
        print(commonElements2(array1B, array2B));

        int[] array1C = {0, 1, 2, 3, 4, 5};
        int[] array2C = {6, 7, 8, 9, 10, 11};
        // common_elements(array1C, array2C) should return [] (an empty array).
        print(commonElements(array1C, array2C));
        print(commonElements2(array1C, array2C));
    }

    // Implement your solution below.
    // NOTE: Remember to return an Integer array, not an int array.
    public static Integer[] commonElements(int[] array1, int[] array2) {
        if (array1 == null || array2 == null || array1.length == 0 || array2.length == 0) {
            return null;
        }

        int i = 0, j = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while (i < array1.length && j < array2.length) {
            if (array1[i] == array2[j]) {
                list.add(array1[i]);
                i++; j++;
            } else if (array1[i] > array2[j]) {
                j++;
            } else {
                i++;
            }
        }

        Integer[] resultInArray = new Integer[list.size()];
        return list.toArray(resultInArray);
    }

    public static Integer[] commonElements2(int[] array1, int[] array2) {
        if (array1 == null || array2 == null || array1.length == 0 || array2.length == 0) {
            return null;
        }

        int[] shortArr = array1.length <= array2.length ? array1 : array2;
        int[] longArr = array1.length > array2.length ? array1 : array2;

        List<Integer> list = new ArrayList<>();

        for (int n: shortArr) {
            if (binarySearch(longArr, n)) {
                list.add(n);
            }
        }

        Integer[] resultInArray = new Integer[list.size()];
        return list.toArray(resultInArray);
    }

    public static boolean binarySearch(int[] arr, int n) {
        return binarySearch(arr, n, 0, arr.length);
    }

    public static boolean binarySearch(int[] arr, int n, int l, int r) {
        if (l > r) {
            return false;
        }

        int mid = (l + r) / 2;

        if (arr[mid] == n) return true;
        else if (arr[mid] > n) {
            return binarySearch(arr, n, l, mid - 1);
        } else {
            return binarySearch(arr, n, mid + 1, r);
        }
    }

    public static void print(Integer[] arr) {
        if (arr.length == 0) {
            System.out.print("[]");
        }
        for (int n: arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
