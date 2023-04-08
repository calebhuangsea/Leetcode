package M24SwapNodesInPairs;

public class Solution {
    /**
     * Time Complexity O(N) 0ms 100%
     * Space Complexity O(1) 40.9MB 10.17%
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode curr = head;
        ListNode p0 = dummy;
        while (curr != null && curr.next != null) {
            ListNode prev = null;
            for (int i = 0; i < 2; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            p0.next.next = curr;
            p0.next = prev;
            p0 = p0.next.next;
        }
        return dummy.next;
    }


    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
