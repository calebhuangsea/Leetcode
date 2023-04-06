package E206ReverseLinkedList;

public class Solution {
    /**
     * Recursion
     * Time Complexity O(N) 0ms 100%
     * Space Complexity O(N) 42.6MB 28.98%
     */
//    public ListNode reverseList(ListNode head) {
//        // 1 -> 2
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode p = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return p;
//    }

    /**
     * Iterative
     * Time Complexity O(N) 0ms 100%
     * Space Complexity O(N) 42.7MB 22.63%
     */
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
