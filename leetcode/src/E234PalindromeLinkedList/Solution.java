package E234PalindromeLinkedList;

public class Solution {
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

    /**
     * Time Complexity O(N) 4ms 85.15%
     * Space Complexity O(1) 63.3MB 20.38%
     */
    public boolean isPalindrome(ListNode head) {
        // get the left half end
        ListNode slow = head;
        ListNode faster = head;
        while (faster.next != null && faster.next.next != null) {
            slow = slow.next;
            faster = faster.next.next;
        }
        // reverse the right half
        ListNode reversedRight = reverse(slow.next);
        slow.next = null;
        while (reversedRight != null) {
            if (head.val != reversedRight.val) {
                return false;
            }
            head = head.next;
            reversedRight = reversedRight.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
