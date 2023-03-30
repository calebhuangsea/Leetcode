package M86PartitionList;

public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }
    }

    /**
     * Two pointer
     * Time Complexity O(N) 0ms 100%
     * Space Complexity O(1) 42.1MB 33.21%
     */
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode();
        ListNode right = new ListNode();
        ListNode currL = left;
        ListNode currR = right;
        while (head != null) {
            if (head.val < x) {
                currL.next = head;
                currL = currL.next;
            } else {
                currR.next = head;
                currR = currR.next;
            }
            head = head.next;
        }
        currR.next = null;
        currL.next = right.next;
        return left.next;
    }
}
