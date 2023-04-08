package M92ReverseLinkedListII;

public class Solution {
    /**
     * Time Complexity O(N) 0ms 100%
     * Space Complexity O(1) 40.2MB 54.96%
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode curr = dummy;
        ListNode dPrev = null;
        for (int i = 0; i < left; i++) {
            dPrev = curr;
            curr = curr.next;
        }
        // now curr reach the node that we want to do the reverse
        ListNode end = curr;
        ListNode prev = null;
        for (int i = 0; i <= right - left; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // connect the node before reverse to the new start of reversed node
        dPrev.next = prev;
        // connect the end of the reversed list to original list
        end.next = curr;
        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
