package M823BinaryTreesWithFactors;

import java.util.*;

public class Solution {
    /**
     * Time: O(NlogN)
     * Space: O(N)
     */
    private static final int MOD = 1000000007;
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Integer> dp = new HashMap<>();
        Set<Integer> s = new HashSet<>();
        for (int n : arr) {
            dp.put(n, 1);
            s.add(n);
        }
        for (int i : arr) {
            for (int j : arr) {
                if (j > Math.sqrt(i)) break;
                if (i % j == 0 && s.contains(i / j)) {
                    long temp = (long) dp.get(j) * dp.get(i / j);
                    dp.put(i, (int) ((dp.get(i) + (i / j == j ? temp : temp * 2)) % MOD));
                }
            }
        }
        int result = 0;
        for (int val : dp.values()) {
            result = (result + val) % MOD;
        }
        return result;
    }
}
