package Meituan;

import java.util.*;

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        UnionFind uf = new UnionFind(n);
//        long cost = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 1 ;i <= m; i++) {
            int u = sc.nextInt() - 1, v = sc.nextInt() - 1, w = sc.nextInt(), p = sc.nextInt();
            if (p == 1) {
//                cost += w;
                uf.connect(u, v);
                res.add(i);
            } else {
                adj[u].add(new int[] {v, w});
                adj[v].add(new int[] {u, w});
            }
        }
        if (uf.max != n) {
            // try to dfs to find the best solution

        }
    }

    private static int dfs(List<int[]>[] adj, int curr) {
        // see if we can 
        return -1;
    }

}

class UnionFind {
    int[] parent;
    int[] cost;
    int[] rank;

    int max = 1;
    public UnionFind(int n) {
        parent = new int[n];
        cost = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        Arrays.fill(cost, 0);
        Arrays.fill(rank, 1);
    }

    public int find(int x) {
        while (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void connect(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return;
        cost[px] += cost[py];
        rank[px] += rank[py];
        parent[py] = px;
        max = Math.max(max, rank[px]);
    }

    private boolean check(int x, int y) {
        return find(x) == find(y);
    }

}

class Edge {
    int from;
    int to;
    int w;

    public Edge(int from, int to, int w) {
        this.from = from;
        this.to = to;
        this.w = w;
    }
}
