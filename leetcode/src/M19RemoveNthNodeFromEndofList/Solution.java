package M19RemoveNthNodeFromEndofList;

public class Solution {
    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    /**
     * Time Complexity O(N)
     * Space Complexity O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 1;
        ListNode prev = null;
        ListNode curr = head;
        while (curr.next != null) {
            prev= curr;
            curr = curr.next;
            len++;
        }
        // if head
        if (n == len) {
            return head.next;
        }
        // if tail
        if (n == 1) {
            prev.next = null;
            return head;
        }
        len -= n;
        curr = head;
        for (int i = 0; i < len; i++) {
            curr = curr.next;
        }
        curr.val = curr.next.val;
        curr.next = curr.next.next;
        return head;
    }
}
