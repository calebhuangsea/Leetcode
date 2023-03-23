package M2AddTwoNumbers;

public class Solution {
    /**
     * Iteration and use a boolean to keep track of extra value
     * Time Complexity O(N) 2ms 97.6%
     * Space Complexity O(N) 43.2MB 17.52%
     */
    public class ListNode {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        boolean add = false;
        ListNode curr = node;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if (add) {
                sum += 1;
            }
            if (sum > 9) {
                add = true;
                sum -= 10;
            } else {
                add = false;
            }
            curr.next = new ListNode(sum);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int val = l1.val;
            if (add) {
                val += 1;
            }
            if (val > 9) {
                add = true;
                val -= 10;
            } else {
                add = false;
            }
            curr.next = new ListNode(val);
            curr = curr.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int val = l2.val;
            if (add) {
                val += 1;
            }
            if (val > 9) {
                add = true;
                val -= 10;
            } else {
                add = false;
            }
            curr.next = new ListNode(val);
            curr = curr.next;
            l2 = l2.next;
        }
        if (add) {
            curr.next = new ListNode(1);
        }
        return node.next;
    }
}
