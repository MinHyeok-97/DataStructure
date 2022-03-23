package graph.list;

import java.util.LinkedList;
import java.util.List;

public class AdjacencyListGraph {
    final LinkedList<Edge>[] graph;

    @SuppressWarnings("unchecked")
    public AdjacencyListGraph(int size) {
        graph = new LinkedList[size];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
    }

    public void clear() {
        for (int i = 0; i< graph.length; i++) {
            graph[i].clear();
        }
    }

    private void addEdge(int u, int v, int w) {
        Edge edge = new Edge();
        edge.u = u;
        edge.v = v;
        edge.w = w;

        graph[u].add(edge);

        graph[u].sort((o1, o2) -> o1.v - o2.v);
    }

    public void addUndirectedEdge(int u, int v) {
        addUndirectedEdge(u, v, 1);
    }

    public void addUndirectedEdge(int u, int v, int w) {
        addEdge(u, v, w);
        addEdge(v, u, w);
    }

    public void addDirectEdge(int u, int v) {
        addDirectedEdge(u, v, 1);
    }

    public void addDirectedEdge(int u, int v, int w) {
        addEdge(u, v, w);
    }

    public void printEdge() {
        System.out.println("---List Edge---");
        for (List<Edge> edges : graph) {
            for (Edge edge : edges) {
                System.out.printf("(%d, %d, %d) ", edge.u, edge.v, edge.w);
            }
        }
        System.out.println("\n---------------");
    }
}
