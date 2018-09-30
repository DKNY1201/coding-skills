package datastructure.Graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Bi on 9/28/18.
 */
public class BFS {
    public static void main(String[] args) {
        BFS g = new BFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);
    }

    private int V;
    private LinkedList<Integer>[] adj;

    public BFS(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void BFS(int s) {
        boolean[] visited = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            int vertice = queue.poll();
            visited[vertice] = true;

            System.out.print(vertice + " ");

            LinkedList<Integer> adjacent = adj[vertice];

            Iterator<Integer> iterator = adjacent.iterator();

            while (iterator.hasNext()) {
                int cur = iterator.next();

                if (!visited[cur]) {
                    queue.add(cur);
                }
            }
        }
    }
}
