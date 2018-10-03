package datastructure.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Bi on 9/30/18.
 */
public class DFS {
    public static void main(String[] args) {
        DFS g = new DFS(4);

        g.addVertice(0, 1);
        g.addVertice(0, 2);
        g.addVertice(1, 2);
        g.addVertice(2, 0);
        g.addVertice(2, 3);
        g.addVertice(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.dfs(2);

        System.out.println();


        DFS g1 = new DFS(6);

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

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 0)");

        g1.dfs1(0);
        System.out.println();
        g1.dfsRes(0);
        System.out.println();
        g1.finalDFS(0);
        System.out.println();
        g1.dfs(0);
    }

    int V;
    LinkedList<Integer>[] adj;

    public DFS(int v) {
        this.V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addVertice(int v, int w) {
        adj[v].add(w);
    }

    public void dfs(int s) {
        boolean[] visited = new boolean[V];

        Stack<Integer> stack = new Stack<>();

        stack.push(s);

        while (!stack.isEmpty()) {
            int v = stack.peek();
            if (!visited[v]) {
                System.out.print(v + " ");
                visited[v] = true;
            }

            if (adj[v].size() > 0) {
                int k = adj[v].removeLast();
                if (!visited[k]) {
                    stack.push(k);
                }
            } else {
                stack.pop();
            }
        }
    }

    public void dfs1(int s) {
        boolean[] visited = new boolean[V];

        Stack<Integer> stack = new Stack<>();

        stack.push(s);

        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                System.out.print(v + " ");
                visited[v] = true;
            }

            Iterator<Integer> i = adj[v].iterator();

            while (i.hasNext()) {
                int k = i.next();

                if (!visited[k]) {
                    stack.push(k);
                }
            }
        }
    }

    public void dfsRes(int s) {
        boolean[] visited = new boolean[V];
        dfsRes(s, visited);
    }

    public void dfsRes(int s, boolean[] visited) {
        System.out.print(s + " ");

        visited[s] = true;

        Iterator<Integer> i = adj[s].iterator();

        while (i.hasNext()) {
            int k = i.next();
            if (!visited[k]) {
                dfsRes(k, visited);
            }
        }
    }

    public void finalDFS(int s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        stack.push(s);

        System.out.print(s + " ");
        visited[s] = true;

        while (!stack.isEmpty()) {
            int v = stack.peek();

            Iterator<Integer> iterator = adj[v].iterator();

            while (iterator.hasNext()) {
                int k = iterator.next();

                boolean isNoUnvisitedAdj = true;
                if (!visited[k]) {
                    System.out.print(k + " ");
                    visited[k] = true;
                    stack.push(k);
                    isNoUnvisitedAdj = false;
                }

                if (isNoUnvisitedAdj && !stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
    }
}
