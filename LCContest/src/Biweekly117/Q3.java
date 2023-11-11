package Biweekly117;

public class Q3 {
    public static void main(String[] args) {
        System.out.println(new Q3().stringCount(4));
    }
    int mod = 1_000_000_007;
    public int stringCount(int n) {
        if (n < 4) return 0;
        // dp[i][j] means the number of strings of length i such that at least [0]: l, [1]: e, [2]: t
        Integer[][][][] dp = new Integer[n + 1][2][3][2];
        return dfs(dp, n, 1, 2, 1);
    }

    private int dfs(Integer[][][][] dp, int n, int l, int e, int t) {
        if (n == 0) {
            if (l > 0 || e > 0 || t > 0) return 0;
            else return 1;
        }
        if (dp[n][l][e][t] != null) return dp[n][l][e][t];
        int res = 0;
        res += dfs(dp, n - 1, Math.max(l - 1, 0), e, t) % mod;
        res += dfs(dp, n - 1, l, Math.max(e - 1, 0), t) % mod;
        res %= mod;
        res += dfs(dp, n - 1, l, e, Math.max(t - 1, 0)) % mod;
        res %= mod;
        long v = 23l * dfs(dp, n - 1, l, e, t) % mod;
        v += res;
        v %= mod;
        res = (int)v;
        dp[n][l][e][t] = res;
        return dp[n][l][e][t];
    }
}

