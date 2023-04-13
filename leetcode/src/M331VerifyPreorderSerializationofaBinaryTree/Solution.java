package M331VerifyPreorderSerializationofaBinaryTree;

public class Solution {
    /**
     * Time Complexity O(N)
     * Space Complexity O(N)
     */
    public boolean isValidSerialization(String preorder) {
        int slot = 1;
        for (String node : preorder.split(",")) {
            slot--;
            if (slot < 0) {
                return false;
            }
            if (!node.equals("#")) {
                slot+=2;
            }
        }
        return slot == 0;
    }

}
