package graph.matrix;

import java.util.Arrays;

public class AdjacencyMatrixGraph {
    final int[][] graph;

    public AdjacencyMatrixGraph(int size) {
        graph = new int[size][size];
    }

    public void addUndirectedEdge(int u, int v) {
        addUndirectedEdge(u, v, 1);
    }

    public void addUndirectedEdge(int u, int v, int w){
        graph[u][v] = w;
        graph[v][u] = w;
    }

    public void addDirectEdge(int u, int v) {
        addDirectedEdge(u, v, 1);
    }

    public void addDirectedEdge(int u, int v, int w) {
        graph[u][v] = w;
    }

    public void clear() {
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], 0);
        }
    }

    public void printEdge() {
        System.out.println("---Matrix Edge---");
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (0 != graph[i][j]) {
                    System.out.printf("(%d, %d, %d) ", i, j, graph[i][j]);
                }
            }
        }
        System.out.println("\n-----------------");
    }
}
