package M237DeleteNodeInaLinkedList;

public class Solution {
    /**
     * Time Complexity O(1)
     * Space Complexity O(1)
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
