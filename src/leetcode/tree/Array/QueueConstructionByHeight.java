package leetcode.tree.Array;

import java.util.Arrays;

/**
 * Created by Bi on 10/11/18.
 */
public class QueueConstructionByHeight {
    public static void main(String[] args) {
//        int[][] people = new int[][] {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
//
//        int [][] result = reconstructQueue(people);
//        for (int i = 0; i < people.length; i++) {
//            System.out.println(result[i][0] + " - " + result[i][1]);
//        }

        int[][] people1 = new int[][] {{2,4},{3,4},{9,0},{0,6},{7,1},{6,0},{7,3},{2,5},{1,1},{8,0}};
        int[][] people2 = new int[][] {{8,2},{4,2},{4,5},{2,0},{7,2},{1,4},{9,1},{3,1},{9,0},{1,0}};
//        [[6,0],[1,1],[8,0],[7,1],[9,0],[2,4],[0,6],[2,5],[3,4],[7,3]]
        int [][] result1 = reconstructQueue(people2);
        for (int i = 0; i < result1.length; i++) {
            System.out.println(result1[i][0] + " - " + result1[i][1]);
        }
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> p1[0] != p2[0] ? p1[0] - p2[0] : p1[1] - p2[1]);
        int len = people.length;
        int[][] result = new int[len][2];

        for (int i = 0; i < len; i++) {
            result[i] = new int[] {-1, -1};
        }

        for (int i = 0; i < len; i++) {
            int[] person = people[i];
            int h = person[0];
            int k = person[1];
            int count = 0;

            for (int j = 0; j <= k; j++) {
                if (result[j][0] != -1 && result[j][0] < h) count++;
            }

            while (count > 0) {
                ++k;
                if (result[k][0] >= h || result[k][0] == -1) {
                    count--;
                }
            }

            result[k] = person;
        }

        return result;
    }
//
//    public static int[][] reconstructQueue1(int[][] people) {
//        Arrays.sort(people, (p1, p2) -> p1[0] != p2[0] ? p1[0] - p2[0] : p1[1] - p2[1]);
//        for (int i = 0; i < people.length; i++) {
//            System.out.println(people[i][0] + " - " + people[i][1]);
//        }
//        int len = people.length;
//        int[][] result = new int[len][2];
//
//        for (int i = 0; i < len; i++) {
//            result[i] = new int[] {-1, -1};
//        }
//
//        for (int i = 0; i < len; i++) {
//            int[] person = people[i];
//            int h = person[0];
//            int k = person[1];
//            int count = 0;
//            int alreadySpace = 0;
//            for (int j = 0; j <= k; j++) {
//                if (result[j][0] != -1 && result[j][0] < h) count++;
//                if (result[j][0] == -1 || result[j][0] >= h) alreadySpace++;
//            }
//
//            int pos = k + count;
//            int temp = k;
//            while (alreadySpace < k) {
//                temp++;
//                if (result[temp][0] == -1 || result[temp][0]) {
//                    alreadySpace++;
//                }
//            }
//
//            result[pos] = person;
//        }
//
//        return result;
//    }

}
