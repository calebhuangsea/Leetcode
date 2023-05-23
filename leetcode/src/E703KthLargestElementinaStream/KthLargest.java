package E703KthLargestElementinaStream;

import java.util.PriorityQueue;

public class KthLargest {
    /**
     * Time: O(Nlog(N) + Mlog(K))
     * Space: O(N)
     */
    PriorityQueue<Integer> pq2 = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n : nums) {
            pq2.add(n);
        }
    }

    public int add(int val) {
        pq2.add(val);
        while (pq2.size() > k) {
            pq2.poll();
        }
        return pq2.peek();
    }
}
