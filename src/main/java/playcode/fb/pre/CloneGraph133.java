package playcode.fb.pre;
import java.util.*;
public class CloneGraph133 {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /**
     * can remove visited and use clonesmap as the visited function
     */
    public Node cloneGraph(Node node) {
        if(node ==null) return null;
        return dfs(node, new HashSet<>(), new HashMap<>());
    }

    private Node dfs(Node node, Set<Integer> visited, Map<Integer, Node> clones){
        visited.add(node.val);
        Node clone = clones.computeIfAbsent(node.val, e->new Node(node.val));

        for(Node next : node.neighbors){
            if(visited.add(next.val)){
                dfs(next, visited, clones);
            }
            clone.neighbors.add(clones.computeIfAbsent(next.val, e->new Node(next.val)));
        }
        return clone;
    }
}
