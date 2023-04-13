package M449SerializeandDeserializeBST;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    /**
     * BFS and Queue, can also construct it using postorder or preorder traversal result
     * Time Complexity O(N)
     * Space Complexity O(N)
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        // 1,2,3,
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node == null) {
                sb.append("null,");
                continue;
            }
            sb.append(node.val + ",");
            q.add(node.left);
            q.add(node.right);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] nodes = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.add(root);
        int i = 1;
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            String left = nodes[i++];
            String right = nodes[i++];
            if (!left.equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(left));
                node.left = leftNode;
                q.add(leftNode);
            }
            if (!right.equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(right));
                node.right = rightNode;
                q.add(rightNode);
            }
        }
        return root;
    }


    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
