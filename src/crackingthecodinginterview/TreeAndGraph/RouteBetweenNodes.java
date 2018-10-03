package crackingthecodinginterview.TreeAndGraph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Bi on 10/2/18.
 */
public class RouteBetweenNodes {
    public static void main(String[] args) {
        Graph g1 = new Graph(6);

        g1.addVertice(0, 1);
        g1.addVertice(0, 2);
        g1.addVertice(1, 0);
        g1.addVertice(1, 3);
        g1.addVertice(1, 4);
        g1.addVertice(2, 0);
        g1.addVertice(2, 4);
        g1.addVertice(3, 1);
        g1.addVertice(3, 4);
        g1.addVertice(3, 5);
        g1.addVertice(4, 2);
        g1.addVertice(4, 1);
        g1.addVertice(4, 3);
        g1.addVertice(4, 5);
        g1.addVertice(5, 3);
        g1.addVertice(5, 4);

        System.out.println(isRouteBetweenNodes(g1, 0,5));
        System.out.println(isRouteBetweenNodes(g1, 0,6));
    }

    public static boolean isRouteBetweenNodes(Graph g, int a, int b) {
        if (a == b) return true;

        boolean[] visited = new boolean[g.adj.length];

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(a);

        while (!queue.isEmpty()) {
            int v = queue.poll();

            visited[v] = true;

            LinkedList<Integer> adjs = g.adj[v];

            Iterator<Integer> i = adjs.iterator();

            while (i.hasNext()) {
                int w = i.next();

                if (w == b) {
                    return true;
                }

                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                }
            }
        }

        return false;
    }
}
