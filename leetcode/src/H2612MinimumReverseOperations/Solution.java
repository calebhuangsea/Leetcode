package H2612MinimumReverseOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Solution {
    /**
     * Time Complexity O(nlog(n))
     * Space Complexity O(n)
     */
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        boolean[] ban = new boolean[n];
        ban[p] = true;
        for (int b : banned) {
            ban[b] = true;
        }
        // set for odd and even steps
        TreeSet<Integer>[] sets = new TreeSet[2];
        sets[0] = new TreeSet<>();
        sets[1] = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (!ban[i]) {
                sets[i%2].add(i);
            }
        }
        sets[0].add(n);
        sets[1].add(n);
        List<Integer> q = new ArrayList<Integer>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        q.add(p);
        for (int step = 0; !q.isEmpty();step++) {
            List<Integer> tmp = q;
            q = new ArrayList<>();
            for (int i : tmp) {
                ans[i] = step;
                int mn = Math.max(i - k + 1, k - i - 1);
                int mx = Math.min(i + k - 1, n * 2 - k - i - 1);
                TreeSet<Integer> s = sets[mn % 2];
                for (int j = s.ceiling(mn); j <= mx; j = s.ceiling(mn)) {
                    s.remove(j);
                    q.add(j);
                }
            }
        }
        return ans;
    }
}
