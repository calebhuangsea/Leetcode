package H239SlidingWindowMaximum;

import java.util.ArrayDeque;

public class Solution {
    /**
     * Time Complexity O(N) 32ms 87.99%
     * Space Complexity O(N - k + 1) 57.1MB 89.27%
     */
    ArrayDeque<Integer> dq = new ArrayDeque<>();
    int[] nums;
    public int[] maxSlidingWindow(int[] nums, int k) {
        this.nums = nums;
        if (k == 0) {
            return new int[0];
        } else if (k == 1) {
            return nums;
        }
        for (int i = 0; i < k; i++) {
            // before insert new one, remove all smaller index than this one
            while (!dq.isEmpty() && nums[i] > nums[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        int[] output = new int[nums.length - k + 1];
        output[0] = nums[dq.getFirst()];
        for (int i = k; i < nums.length; i++) {
            // remove the old index
            if (!dq.isEmpty() && dq.getFirst() == i - k) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && nums[i] > nums[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
            output[i - k + 1] = nums[dq.getFirst()];
        }
        return output;
    }
}
