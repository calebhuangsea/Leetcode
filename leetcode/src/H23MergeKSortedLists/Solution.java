package H23MergeKSortedLists;


import java.util.Iterator;

public class Solution {
    /**
     * Use Merge sort to divide and conquer and do merge two sorted linked list
     * Time Complexity O(Nlog(k)) 0ms 100%
     * Space Complexity O(1) 45.3MB 5.62%
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

    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }

    private ListNode partition(ListNode[] lists, int lo, int hi) {
        if (lo == hi) {
            return lists[lo];
        } else if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            ListNode left = partition(lists, lo, mid);
            ListNode right = partition(lists, mid + 1, hi);
            return merge(left, right);
        } else {
            return null;
        }
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode curr = node;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }

        return node.next;
    }
}
