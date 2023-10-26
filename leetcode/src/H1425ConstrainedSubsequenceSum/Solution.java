package H1425ConstrainedSubsequenceSum;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] dp = new int[nums.length];
        int ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (!dq.isEmpty() && i - dq.peek() > k) {
                dq.poll();
            }
            dp[i] = (!dq.isEmpty() ? dp[dq.peek()] : 0) + nums[i];
            ans = Math.max(dp[i], ans);
            while (!dq.isEmpty() && dp[dq.peekLast()] < dp[i]) {
                dq.pollLast();
            }
            if (dp[i] > 0) {
                dq.add(i);
            }
        }
        return ans;
    }


    /**
     * Time: O(n log n)
     * Space: O(N)
     */
//    public int constrainedSubsetSum(int[] nums, int k) {
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
//            return b[0] - a[0];
//        });
//        int max = nums[0];
//        pq.add(new int[] {nums[0], 0});
//        for (int i = 1; i < nums.length; i++) {
//            // keep retrieving the max number from the pq until it is in boundary (we only care about the largest one)
//            while (!pq.isEmpty() && i - pq.peek()[1] > k) {
//                pq.remove();
//            }
//            int sum = Math.max(0, pq.peek()[0]) + nums[i];
//            max = Math.max(sum, max);
//            pq.add(new int[] {sum, i});
//        }
//        return max;
//    }
}
