package Greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bi on 5/29/19.
 */
public class Dijkstra {
    public static void main(String[] args) {
        HashMap<String, Node[]> graph = new HashMap<>();
        graph.put("A", new Node[]{new Node("B", 6), new Node("D", 1)});
        graph.put("B", new Node[]{new Node("A", 6), new Node("D", 2), new Node("E", 2)});
        graph.put("C", new Node[]{new Node("B", 5), new Node("E", 5)});
        graph.put("D", new Node[]{new Node("A", 1), new Node("B", 2), new Node("E", 1)});
        graph.put("E", new Node[]{new Node("D", 1), new Node("B", 2), new Node("C", 5)});

        HashMap<String, Integer> distance = dijkstra(graph, "A");
        System.out.println(distance);

        HashMap<String, Node[]> graph1 = new HashMap<>();
        graph1.put("A", new Node[]{new Node("B", 7), new Node("C", 9), new Node("F", 14)});
        graph1.put("B", new Node[]{new Node("A", 7), new Node("C", 10), new Node("D", 15)});
        graph1.put("C", new Node[]{new Node("A", 9), new Node("B", 10), new Node("D", 11), new Node("F", 2)});
        graph1.put("D", new Node[]{new Node("B", 15), new Node("C", 11), new Node("E", 6)});
        graph1.put("E", new Node[]{new Node("D", 6), new Node("F", 9)});
        graph1.put("F", new Node[]{new Node("A", 14), new Node("C", 2), new Node("E", 9)});

        HashMap<String, Integer> distance1 = dijkstra(graph1, "A");
        System.out.println(distance1);
    }

    public static HashMap<String, Integer> dijkstra(HashMap<String, Node[]> graph, String startNode) {
        // Initialize
        // Shortest distance from startNode to all nodes
        HashMap<String, Integer> distance = new HashMap<>();
        // Map of previous node (in shortest part) of all nodes
        HashMap<String, String> previousNode = new HashMap<>();
        // Contains all unvisited nodes
        Set<String> unvisited = new HashSet<>();
        // Contains all visited nodes
        Set<String> visited = new HashSet<>();

        // Initialize values
        for (String key: graph.keySet()) {
            unvisited.add(key);
            distance.put(key, Integer.MAX_VALUE);
            previousNode.put(key, null);
        }

        // Distance from startNode to itself is 0
        distance.put(startNode, 0);
        String currentNode = startNode;

        while (!unvisited.isEmpty()) {
            Node[] neighbors = graph.get(currentNode);

            for (Node neighbor: neighbors) {
                if (!visited.contains(neighbor)) {
                    String neighborName = neighbor.name;
                    int neighborDist = neighbor.distance;
                    int dist = distance.get(currentNode) + neighborDist;

                    // Update distance / previousNode if find new path that shorter than examined nodes
                    if (dist < distance.get(neighborName)) {
                        distance.put(neighborName, dist);
                        previousNode.put(neighborName, currentNode);
                    }
                }
            }

            unvisited.remove(currentNode);
            visited.add(currentNode);

            int min = Integer.MAX_VALUE;
            // Continue with shortest node from startNode
            for (String key: distance.keySet()) {
                if (!visited.contains(key) && key != startNode && distance.get(key) < min) {
                    min = distance.get(key);
                    currentNode = key;
                }
            }
        }

        return distance;
    }
}

class Node {
    String name;
    int distance;

    public Node(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }
}
