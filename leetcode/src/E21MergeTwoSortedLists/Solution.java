package E21MergeTwoSortedLists;


class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Iteratively check node
     * Time Complexity: O(N + M) 0ms 100%
     * Space Complexity: O(1) 42.3MB 29.93% ? Because we only add a new node
     */
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode ptr = new ListNode();
//        ListNode res = ptr;
//        while (list1 != null && list2 != null) {
//            if (list1.val < list2.val) {
//                res.next = list1;
//                list1 = list1.next;
//            } else {
//                res.next = list2;
//                list2 = list2.next;
//            }
//            res = res.next;
//        }
//        if (list1 != null) {
//            res.next = list1;
//        }
//        if (list2 != null) {
//            res.next = list2;
//        }
//        return ptr.next;
//    }

    /**
     * Recursively merge it, keep the head of smaller one and send the rest
     * of the two lists to the recursive steps
     * Time Complexity: O(M + N) 0ms 100%
     * Space Complexity: O(1) 41.8MB 74.69%
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}