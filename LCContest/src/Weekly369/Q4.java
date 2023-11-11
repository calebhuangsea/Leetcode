package Weekly369;

public class Q4 {
    // tree dp problem
    // <i, j> : sum = we have collected the ith coin when divisor is j with this maximum sum
//    Map<Pair<Integer, Integer>, Integer> memo = new HashMap<>();
//    public int maximumPoints(int[][] edges, int[] coins, int k) {
//        List<Integer>[] adj = new List[edges.length + 1];
//        for (int i = 0; i < edges.length + 1; i++) adj[i] = new ArrayList<>();
//        for (int[] e : edges) {
//            adj[Math.min(e[1], e[0])].add(Math.max(e[1], e[0]));
//        }
//        return dfs(adj, coins, 0, k, 1);
//    }
//
//    private int dfs(List<Integer>[] edges, int[] coins, int node, int k, int d) {
//        Pair<Integer, Integer> key = new Pair<>(node, d);
//        if (memo.containsKey(key)) return memo.get(key);
//        int sum1 = 0; // use first case
//        int sum2 = 0; // use second case
//        for (int nei : edges[node]) {
//            sum1 += dfs(edges, coins, nei, k, d);
//            sum2 += dfs(edges, coins, nei, k, Math.min(10001, d * 2));
//        }
//        sum1 += coins[node] / d - k;
//        sum2 += coins[node] / d / 2;
//        memo.put(key, Math.max(sum1, sum2));
//        return memo.get(key);
//    }
}
