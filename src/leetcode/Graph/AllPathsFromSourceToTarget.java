package leetcode.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Bi on 10/24/18.
 */
public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        int n = 5;
        List<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        lists[0].add(1);
        lists[0].add(2);
        lists[1].add(3);
        lists[2].add(3);
        lists[3].add(4);
        allPathsFromSourceToTarget(lists);
    }

    public static void allPathsFromSourceToTarget(List<Integer>[] lists) {
        int len = lists.length;
        boolean[] visited = new boolean[len];

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        System.out.print("0 ");

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            List<Integer> adjs = lists[cur];

            for (int i = 0; i < adjs.size(); i++) {
                int edge = adjs.get(i);
                if (!visited[edge]) {
                    visited[edge] = true;
                    queue.add(edge);
                    System.out.print(edge + " ");
                }
            }
        }
    }
}
