package E160IntersectionOfTwoLinkedLists;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    /**
     * Time Complexity O(m + n) 1ms 98.84%
     * Space Complexity O(1) 45.7MB 21.55%
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = length(headA);
        int b = length(headB);
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (a != b) {
            if (a < b) {
                nodeB = nodeB.next;
            } else {
                nodeA = nodeA.next;
            }
        }
        while (a != 0) {
            if (nodeA == nodeB) {
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }

    private int length(ListNode curr) {
        int i = 0;
        ListNode node = curr;
        while (node != null) {
            i++;
            node = node.next;
        }
        return i;
    }

    /**
     * Time Complexity O(M + N) 7ms 18.79%
     * Space Complexity O(M) 46.1MB 11.16%
     */
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        Set<ListNode> set = new HashSet<>();
//        ListNode curr = headA;
//        while (curr != null) {
//            set.add(curr);
//            curr = curr.next;
//        }
//        curr = headB;
//        while (curr != null) {
//            if (set.contains(curr)) {
//                return curr;
//            }
//            curr = curr.next;
//        }
//        return null;
//    }
}
