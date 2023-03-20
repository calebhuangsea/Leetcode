package M133CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    class Node {
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
     * Recursively find neighbor and add neighbor, use a map to keep track of repetitive node
     * to avoid infinite loop and duplicate new node.
     * Time Complexity O(N + M) 26ms 49.53%, visit every node
     * Space Complexity O(N) 42MB 99.4, use a map to store visited nodes.
     */

    Map<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node.val, newNode);
        for (Node neigh : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neigh));
        }
        return newNode;
    }

    /**
     * BFS iteratively use map and queue to keep track of existed node and add neighbors
     * Time Complexity O(N + M) 26ms 49.53%, visit every node
     * Space Complexity O(N) 43MB 21.99%, use a map and queue to store visited nodes.
     */

//    public Node cloneGraph(Node node) {
//        if (node == null) {
//            return null;
//        }
//        Map<Node, Node> visited = new HashMap<>();
//        Queue<Node> q = new LinkedList<>();
//        q.add(node);
//        visited.put(node, new Node(node.val, new ArrayList<>()));
//        while(!q.isEmpty()) {
//            Node curr = q.remove();
//            for (Node nei : curr.neighbors) {
//                if (!visited.containsKey(nei)) {
//                    visited.put(nei, new Node(nei.val, new ArrayList<>()));
//                    q.add(nei);
//                }
//                visited.get(curr).neighbors.add(visited.get(nei));
//            }
//        }
//        return visited.get(node);
//    }
}
