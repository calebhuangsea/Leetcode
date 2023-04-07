package E876MiddleoftheLinkedList;

public class Solution {
    /**
     * Fast and Slow pointers
     * Time Complexity O(N / 2) 0ms 100%
     * Space Complexity O(1) 41.1MB 27.79%
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
