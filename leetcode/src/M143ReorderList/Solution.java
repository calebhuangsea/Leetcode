package M143ReorderList;

public class Solution {
    /**
     * Time Complexity O(N)
     * Space Complexity O(1)
     */
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // cut list into two half

        // slow is the start of the right half, reverse it
        ListNode dummy = new ListNode(-1, slow);
        ListNode curr = slow;
        prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode left = head;
        ListNode right = prev;
        // System.out.println(right.val);
        while (right.next != null) {
            ListNode next = left.next;
            left.next = right;
            left = next;

            next = right.next;
            right.next = left;
            right = next;
        }
    }


    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
