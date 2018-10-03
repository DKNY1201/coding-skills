package crackingthecodinginterview.TreeAndGraph;

import java.util.LinkedList;

/**
 * Created by Bi on 10/2/18.
 */
public class Graph {
    public LinkedList<Integer>[] adj;

    public Graph(int v) {
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addVertice(int v, int w) {
        adj[v].add(w);
    }
}
