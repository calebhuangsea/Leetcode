package M1168OptimizeWaterDistributioninaVillage;

import M1654MinimumJumpstoReachHome.Pair;

import java.util.*;


public class Solution {
    /**
     * Time: O((N + M)log(N + M))
     * Space: O(N + M)
     * Kruskal's algorithm
     */
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]> edges = new ArrayList<>(n + 1 + pipes.length);
        for (int i = 0; i < n; i++) {
            edges.add(new int[]{0, i + 1, wells[i]});
        }
        for (int[] pipe : pipes) {
            edges.add(pipe);
        }
        Collections.sort(edges, (a, b) -> a[2] - b[2]);
        UnionFind uf = new UnionFind(n);
        int sum = 0;
        for (int[] edge : edges) {
            if (uf.union(edge[0], edge[1])) {
                sum += edge[2];
            }
        }
        return sum;
    }

    /**
     * Prim's algorithm
     * Time: O((N + M)log(N + M))
     * Space: O(N + M)
     */
//    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
//        // key : cost
//        // val : index
//        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
//        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            adj.add(new ArrayList<>());
//        }
//        for (int i = 0; i < n; i++) {
//            Pair<Integer, Integer> pair = new Pair<>(wells[i], i + 1);
//            pq.add(pair);
//            adj.get(i + 1).add(pair);
//        }
//        for (int[] pipe : pipes) {
//            adj.get(pipe[1]).add(new Pair<>(pipe[2], pipe[0]));
//            adj.get(pipe[0]).add(new Pair<>(pipe[2], pipe[1]));
//        }
//        Set<Integer> visited = new HashSet<>();
//        visited.add(0);
//        int sum = 0;
//        while (visited.size() < n + 1) {
//            Pair<Integer, Integer> pair = pq.poll();
//            // if neighbor is visited, skip
//            if (visited.contains(pair.getValue())) {
//                continue;
//            }
//            visited.add(pair.getValue());
//            sum += pair.getKey();
//            for (Pair<Integer, Integer> p : adj.get(pair.getValue())) {
//                if (!visited.contains(p.getValue())) {
//                    pq.add(p);
//                }
//            }
//        }
//
//        return sum;
//    }
}

class UnionFind {
    int[] rank;
    int[] root;

    public UnionFind (int n) {
        rank = new int[n];
        root = new int[n];
        for (int i=0; i < n; i++) {
            rank[i] = 1;
            root[i] = i;
        }
    }

    public int find(int x) {
        if (x != root[x]) {
            root[x] = find(root[x]);
        }
        return root[x];
    }

    public boolean union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx == ry) {
            return false;
        }
        if (rank[rx] >= rank[ry]) {
            rank[rx] += rank[ry];
            rank[ry] = rank[rx];
            root[ry] = rx;
        } else {
            rank[ry] += rank[rx];
            rank[rx] = rank[ry];
            root[rx] = ry;
        }
        return true;
    }
}

