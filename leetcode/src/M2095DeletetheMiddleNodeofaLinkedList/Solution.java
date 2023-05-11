package M2095DeletetheMiddleNodeofaLinkedList;
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
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode prev = null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if (fast.next == null) {
            if (prev == null) {
                return null;
            }
            // odd
            prev.next = slow.next;
        } else {
            // even
            slow.next = slow.next.next;
        }
        return head;
    }
}