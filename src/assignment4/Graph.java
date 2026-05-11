package assignment4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;

public class Graph {
    private final Map<Integer, Vertex> vertices;
    private final Map<Integer, List<Integer>> adjacencyList;
    private final List<Edge> edges;

    public Graph() {
        vertices = new LinkedHashMap<>();
        adjacencyList = new LinkedHashMap<>();
        edges = new ArrayList<>();
    }

    public void addVertex(Vertex v) {
        vertices.putIfAbsent(v.getId(), v);
        adjacencyList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        if (!vertices.containsKey(from) || !vertices.containsKey(to)) {
            throw new IllegalArgumentException("Both vertices must exist before adding an edge.");
        }

        adjacencyList.get(from).add(to);
        edges.add(new Edge(vertices.get(from), vertices.get(to)));
    }

    public void printGraph() {
        System.out.println("Adjacency List:");
        for (int vertexId : adjacencyList.keySet()) {
            System.out.print("V" + vertexId + " -> ");
            List<Integer> neighbors = adjacencyList.get(vertexId);
            for (int neighbor : neighbors) {
                System.out.print("V" + neighbor + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int start) {
        System.out.println("BFS traversal from V" + start + ": " + bfsOrder(start));
    }

    public void dfs(int start) {
        System.out.println("DFS traversal from V" + start + ": " + dfsOrder(start));
    }

    public List<Integer> bfsOrder(int start) {
        validateStartVertex(start);

        List<Integer> traversalOrder = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        // BFS uses a queue. It visits all close neighbors first, then moves level by level.
        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            traversalOrder.add(current);

            for (int neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return traversalOrder;
    }

    public List<Integer> dfsOrder(int start) {
        validateStartVertex(start);

        List<Integer> traversalOrder = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        // DFS goes as deep as possible before returning back to other branches.
        dfsRecursive(start, visited, traversalOrder);
        return traversalOrder;
    }

    private void dfsRecursive(int current, Set<Integer> visited, List<Integer> traversalOrder) {
        visited.add(current);
        traversalOrder.add(current);

        for (int neighbor : adjacencyList.get(current)) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited, traversalOrder);
            }
        }
    }

    private void validateStartVertex(int start) {
        if (!vertices.containsKey(start)) {
            throw new IllegalArgumentException("Start vertex does not exist: " + start);
        }
    }

    public int getVertexCount() {
        return vertices.size();
    }

    public int getEdgeCount() {
        return edges.size();
    }
}
