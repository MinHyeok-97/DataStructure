package graph.matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AdjacencyMatrixGraph {
    final int[][] graph;
    final int[] visit;

    public AdjacencyMatrixGraph(int size) {
        graph = new int[size][size];
        visit = new int[size];
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

    public void dfsTraversal(int start) {
        Arrays.fill(visit, 0);
        System.out.println("--- Matrix dfs ---");
        dfs(start);
        System.out.println("------------------");
    }

    public void bfsTraversal(int start) {
        Arrays.fill(visit, 0);
        System.out.println("--- Matrix bfs ---");
        bfs(start);
        System.out.println("------------------");
    }

    void bfs(int start) {
        Queue<Integer> queue = new LinkedList();
        queue.add(start);
        visit(start);
        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < graph.length; v++) {
                if (visit[v] == 0 && graph[u][v] != 0) {
                    queue.add(v);
                    visit(v);
                }
            }

        }

    }

    void dfs(int u) {
        if (visit[u] == 1) {
            return;
        }

        visit(u);

        for (int v = 0; v < graph.length; v++) {
            if (visit[v] == 0 && graph[u][v] != 0) {
                dfs(v);
            }
        }

    }

    void visit(int vertex) {
        System.out.printf("vertex: %d\n", vertex);
        visit[vertex] = 1;
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
