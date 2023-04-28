package H1851MinimumIntervaltoIncludeEachQuery;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        TreeMap<Integer, Integer> pq = new TreeMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] Q = queries.clone();
        Arrays.sort(Q);
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int n = intervals.length;
        int i = 0;
        for (int q : Q) {
            while (i < n && intervals[i][0] <= q) {
                int l = intervals[i][0];
                int r = intervals[i++][1];
                pq.put(r - l + 1, r);
            }
            while (!pq.isEmpty() && pq.firstEntry().getValue() < q) {
                pq.pollFirstEntry();
            }
            map.put(q, pq.isEmpty() ? -1 : pq.firstKey());
        }
        int[] res2 = new int[Q.length];
        i = 0;
        for (int q : queries)
            res2[i++] = map.get(q);
        return res2;
    }
}
