package M1721SwappingNodesinaLinkedList;

public class Solution {
    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    /**
     * Time: O(N)
     * Space: O(1)
     */
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast  = head;
        ListNode slow = head;

        while (k-1>0){
            fast = fast.next;
            k--;
        }
        ListNode node1 = fast;

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode node2 = slow;

        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;

        return head;
    }
}
