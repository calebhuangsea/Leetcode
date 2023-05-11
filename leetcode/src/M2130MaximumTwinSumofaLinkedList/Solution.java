package M2130MaximumTwinSumofaLinkedList;

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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Get middle of the linked list.
        while (fast != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Reverse second half of the linked list.
        ListNode next, prev = null;
        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        fast = head;
        int maximumSum = 0;
        while (prev != null) {
            maximumSum = Math.max(maximumSum, fast.val + prev.val);
            prev = prev.next;
            fast = fast.next;
        }

        return maximumSum;
    }
}
