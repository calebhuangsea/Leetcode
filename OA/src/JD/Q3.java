package JD;

import java.util.*;

public class Q3 {
    //小红修道路
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // m条路的无向图
        // k条可选择修，放某一条k进去会缩短距离吗？
        // 放k只可能变短 1 - 3 - 2
        //
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
        List<int[]>[] adj = new List[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = in.nextInt(), v = in.nextInt(), p = in.nextInt();
            adj[u].add(new int[] {v, p});
            adj[v].add(new int[] {u, p});
        }
        long[] dis = new long[n + 1];
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[1] = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        dij(adj, 0, 1, visited, dis);
        int count = 0;
        for (int i = 0; i < k; i++) {
            int dest = in.nextInt(), p = in.nextInt();
            if (dis[dest] > p) {
                count++;
                adj[1].add(new int[] {dest, p});
                dij(adj, 0, 0, visited, dis);
            }
        }
        System.out.println(k - count);
    }

    private static void dij(List<int[]>[] adj, int cost, int curr, Set<Integer> visited, long[] dis) {
        if (cost < dis[curr]) dis[curr] = cost;
        for (int[] nei : adj[curr]) {
            if (!visited.contains(nei[0])) {
                visited.add(nei[0]);
                dij(adj, cost + nei[1], nei[0], visited, dis);
                visited.remove(nei[0]);
            }
        }
    }
}
