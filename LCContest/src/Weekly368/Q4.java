package Weekly368;
import java.util.*;
public class Q4 {
    /**
     * Time: O(n^3logn)
     * Space: O(N^2)
     * @param s
     * @param k
     * @return
     */
    // O(N)
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] modify = new int[n - 1][n];
        for (int left = 0; left < n - 1; left++) {
            for (int right = left + 1; right < n; right++) {
                modify[left][right] = getModify(s.substring(left, right + 1));
            }
        }
        int[][] memo = new int[k][n];
        for (int i = 0; i < k; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(k - 1, n - 1, memo, modify);
    }

    private static final int MX = 201;
    private static final List<Integer>[] divisors = new ArrayList[MX];
    // log n
    static {
        Arrays.setAll(divisors, k -> new ArrayList<>());
        for (int i = 1; i < MX; i++) {
            for (int j = i * 2; j < MX; j += i) {
                divisors[j].add(i);
            }
        }
    }

    // O(n)
    private int getModify(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int res = n;
        for (int d : divisors[n]) {
            int cnt = 0;
            // all the head of divisor d
            for (int i0 = 0; i0 < d; i0++) {
                for (int i = i0, j = n - d + i0; i < j; i += d, j -= d) {
                    if (s[i] != s[j]) {
                        cnt++;
                    }
                }
            }
            res = Math.min(res, cnt);
        }
        return res;
    }

    private int dfs(int i, int j, int[][] memo, int[][] modify) {
        if (i == 0) {
            return modify[0][j];
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int L = i * 2; L < j; L++) {
            res = Math.min(res, dfs(i - 1, L - 1, memo, modify) + modify[L][j]);
        }
        return memo[i][j] = res;
    }
}
