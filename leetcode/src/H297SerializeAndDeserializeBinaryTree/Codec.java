package H297SerializeAndDeserializeBinaryTree;

/**
 * Use BFS and queue to serialize and deserialize the tree/string
 * Add L R symbol to indicate left and right child value, add ? indicate no child
 * # to indicate that current subtree level is ended
 * Time Complexity: O(N): 20ms 42.37% Traverse the tree and string, but some operation like substring will cause extra runtime
 * Space Complexity: O(N): 43.9MB 78.22% Use a queue to store node, with most n size
 */

import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
            sb.append(root.val + "#");
        }
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node.left != null) {
                q.add(node.left);
                sb.append(node.left.val + "L"); // indicate left child
            }
            if (node.right != null) {
                q.add(node.right);
                sb.append(node.right.val + "R"); // indicate right child
            }
            if (node.left == null && node.right == null) {
                sb.append("?");//no child for this node
            }
            sb.append("#");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        String[] split = data.split("#");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        q.add(root);
        for (int i = 1; i < split.length; i++) {
            TreeNode node = q.remove();
            if (split[i].contains("?")) {
                continue;
            }
            if (split[i].contains("L")) {
                int index = split[i].indexOf('L');
                TreeNode left = new TreeNode(Integer.parseInt(split[i].substring(0, index)));
                node.left = left;
                q.add(left);
                if (split[i].contains("R")) {
                    int index2 = split[i].indexOf('R');
                    TreeNode right = new TreeNode(Integer.parseInt(split[i].substring(index + 1, index2)));
                    node.right = right;
                    q.add(right);
                }
            } else if (split[i].contains("R")) {
                int index = split[i].indexOf('R');
                TreeNode right = new TreeNode(Integer.parseInt(split[i].substring(0, index)));
                node.right = right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
