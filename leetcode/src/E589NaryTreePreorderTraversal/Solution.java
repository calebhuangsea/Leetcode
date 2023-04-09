package E589NaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * Time Complexity O(E + V)
     * Space Complexity O(V)
     */
    public List<Integer> preorder(Node root) {
        List<Integer> ls = new ArrayList<>();
        dfs(ls, root);
        return ls;
    }

    private void dfs(List<Integer> ls, Node node) {
        if (node == null) {
            return;
        }
        ls.add(node.val);
        for (Node child : node.children) {
            dfs(ls, child);
        }
    }
}
