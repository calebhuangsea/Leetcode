package M142LinkedListCycleII;

public class Solution {
    /**
     * Math: Floyd's Tortoise and Hare
     * Time Complexity O(N) 0ms 100%
     * Space Complexity O(1) 42.9MB 56.14%
     */
    private ListNode getIntersect(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;

        // A fast pointer will either loop around a cycle and meet the slow
        // pointer or reach the `null` at the end of a non-cyclic list.
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return tortoise;
            }
        }

        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        // If there is a cycle, the fast/slow pointers will intersect at some
        // node. Otherwise, there is no cycle, so we cannot find an entrance to
        // a cycle.
        ListNode intersect = getIntersect(head);
        if (intersect == null) {
            return null;
        }

        // To find the entrance to the cycle, we have two pointers traverse at
        // the same speed -- one from the front of the list, and the other from
        // the point of intersection.
        ListNode ptr1 = head;
        ListNode ptr2 = intersect;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }
    /**
     * Time Complexity O(N) 4ms 12.82%
     * Space Complexity O(N) 43.1MB 37.1%
     */
//    public ListNode detectCycle(ListNode head) {
//        Set<ListNode> node = new HashSet<>();
//        ListNode curr = head;
//        while (curr != null) {
//            if (node.contains(curr)) {
//                return curr;
//            }
//            node.add(curr);
//            curr = curr.next;
//        }
//        return null;
//    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
