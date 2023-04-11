package M82RemoveDuplicatesfromSortedListII;

public class Solution {
    /**
     * Time Complexity O(N)
     * Space Complexity O(1)
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-101, head);
        ListNode prev = dummy;
        int count = 1;
        int old = head.val;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val == old) {
                count++;
            } else {
                if (count > 1) {
                    prev.next = curr;
                } else {
                    prev = prev.next;
                }
                count = 1;
            }
            old = curr.val;
            curr = curr.next;
        }
        if (count != 1) {
            prev.next = curr;
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
