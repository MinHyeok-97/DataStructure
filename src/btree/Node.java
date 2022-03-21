package btree;

import java.util.ArrayList;
import java.util.List;

public class Node {
    List<Integer> keys;
    List<Node> nodes;

    public Node(int t) {
        this.keys = new ArrayList<>(2 * t);
        this.nodes = new ArrayList<>(2 * t);
    }
}
