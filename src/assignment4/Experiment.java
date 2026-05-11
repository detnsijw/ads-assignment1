package assignment4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Experiment {
    private final List<String> results;

    public Experiment() {
        results = new ArrayList<>();
    }

    public void runTraversals(Graph g) {
        int startVertex = 0;

        long bfsStart = System.nanoTime();
        g.bfsOrder(startVertex);
        long bfsEnd = System.nanoTime();

        long dfsStart = System.nanoTime();
        g.dfsOrder(startVertex);
        long dfsEnd = System.nanoTime();

        long bfsTime = bfsEnd - bfsStart;
        long dfsTime = dfsEnd - dfsStart;

        results.add(String.format("| %d | %d | %d ns | %d ns |",
                g.getVertexCount(), g.getEdgeCount(), bfsTime, dfsTime));
    }

    public void runMultipleTests() {
        int[] sizes = {10, 30, 100};

        for (int size : sizes) {
            Graph graph = createGraph(size);

            if (size == 10) {
                System.out.println("=== Small Graph Structure ===");
                graph.printGraph();
                System.out.println();
                graph.bfs(0);
                graph.dfs(0);
                System.out.println();
            }

            runTraversals(graph);
        }
    }

    public void printResults() {
        System.out.println("=== Performance Results ===");
        System.out.println("| Vertices | Edges | BFS Time | DFS Time |");
        System.out.println("|---|---|---|---|");
        for (String result : results) {
            System.out.println(result);
        }
    }

    private Graph createGraph(int size) {
        Graph graph = new Graph();

        for (int i = 0; i < size; i++) {
            graph.addVertex(new Vertex(i));
        }

        // Chain edges guarantee that every vertex can be reached from vertex 0.
        for (int i = 0; i < size - 1; i++) {
            graph.addEdge(i, i + 1);
        }

        // Additional deterministic edges make the graph more realistic but still reproducible.
        Random random = new Random(42 + size);
        int extraEdges = size * 2;

        for (int i = 0; i < extraEdges; i++) {
            int from = random.nextInt(size);
            int to = random.nextInt(size);

            if (from != to) {
                graph.addEdge(from, to);
            }
        }

        return graph;
    }
}
