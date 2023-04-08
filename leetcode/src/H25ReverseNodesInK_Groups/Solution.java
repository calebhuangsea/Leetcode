package H25ReverseNodesInK_Groups;

public class Solution {
    /**
     * Time Complexity O(N) 0ms 100%
     * Space Complexity O(1) 42.4MB 67.4%
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode dPrev = dummy;
        ListNode prev = null;
        ListNode end = head;
        curr = head;
        while (len >= k) {
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            dPrev.next = prev;
            end.next = curr;
            dPrev = end;
            end = curr;
            prev = null;
            len -= k;
        }
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
