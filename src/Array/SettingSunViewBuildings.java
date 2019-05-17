package Array;

/**
 * Created by Bi on 5/11/19.
 *
 * You are given an array representing the heights of neighboring buildings on a city street, from east to west.
 * The city assessor would like you to write an algorithm that returns how many of these buildings have a view
 * of the setting sun, in order to properly value the street.
 *
 * For example, given the array [3, 7, 8, 3, 6, 1], you should return 3, since the top floors of the buildings
 * with heights 8, 6, and 1 all have an unobstructed view to the west.
 */
public class SettingSunViewBuildings {
    public static void main(String[] args) {
        int[] buildings1 = new int[] {3, 7, 8, 3, 6, 1};
        int expectedRes1 = 3;
        System.out.println(settingSunViewBuildings(buildings1) == expectedRes1);

        int[] buildings2 = new int[] {9, 9, 9, 9, 9};
        int expectedRes2 = 1;
        System.out.println(settingSunViewBuildings(buildings2) == expectedRes2);

        int[] buildings3 = new int[] {5, 6, 8, 3, 0, 1};
        int expectedRes3 = 3;
        System.out.println(settingSunViewBuildings(buildings3) == expectedRes3);

        int[] buildings4 = new int[] {};
        int expectedRes4 = 0;
        System.out.println(settingSunViewBuildings(buildings4) == expectedRes4);
    }

    public static int settingSunViewBuildings(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = -1;
        int res = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > max) {
                max = nums[i];
                res++;
            }
        }

        return res;
    }
}
