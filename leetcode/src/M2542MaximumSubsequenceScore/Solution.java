package M2542MaximumSubsequenceScore;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    /**
     * Time: O(Nlog(N))
     * Space: O(N)
     */
    public long maxScore(int[] nums1, int[] nums2, int k) {
        // [score1, score2]
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i] = new int[] {nums1[i], nums2[i]};
        }
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> topKHeap = new PriorityQueue<>(k, (a, b) -> a - b);
        long kSum = 0;
        for (int i = 0; i < k; i++) {
            kSum += pairs[i][0];
            topKHeap.add(pairs[i][0]);
        }
        long res = kSum * pairs[k - 1][1];
        for (int i = k; i < n; i++) {
            kSum += pairs[i][0] - topKHeap.poll();
            topKHeap.add(pairs[i][0]);
            res = Math.max(res, pairs[i][1] * kSum);
        }
        return res;
    }
}
