package Weekly370;
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Q3 q3 = new Q3();
        int[][] e = new int[][] {
                {0,1}
        };
        int[] v = new int[] {1, 2}; // 7
        System.out.println(q3.maximumScoreAfterOperations(e, v));
    }
    long[][] dp;
    List<Integer>[] adj;
    int[] v;
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = values.length;
        v = values;
        dp = new long[n][2];
        adj = new List[n];
        // dp[i][0/1]: 0 means we pick all sub-nodes from i, 1 means we ignore 1 or them
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        dfs(0, -1);
        return dp[0][1];
    }

    private void dfs(int curr, int last) {
        // h is how many elements are in this path
        // count is how many elements we have chosen
        if (adj[curr].size() == 1 && adj[curr].get(0) == last) { // when you reach a leaf node
            // pick or not pick
            dp[curr][0] = v[curr];
            dp[curr][1] = 0;
        } else {
            long sum = v[curr];
            dp[curr][0] = v[curr];
            // if I don't take myself, or I don't take from the subtree
            dp[curr][1] = 0;
            for (int nei : adj[curr]) {
                if (nei == last) continue;
                dfs(nei, curr);
                dp[curr][0] += dp[nei][0];
                dp[curr][1] += dp[nei][0];
                sum += dp[nei][1];
            }
            dp[curr][1] = Math.max(sum, dp[curr][1]);
        }
    }
}
