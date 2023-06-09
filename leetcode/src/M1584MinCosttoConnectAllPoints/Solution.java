package M1584MinCosttoConnectAllPoints;

import java.util.PriorityQueue;

class Solution {
    /**
     * Time: O(N^2log(N))
     * Space: O(N^2)
     */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                pq.offer(new int[] {dist, i, j});
            }
        }
        UnionFind uf = new UnionFind(n);
        int cost = 0;
        int count = 0;
        while (count != n - 1) {
            int[] poll = pq.poll();
            int cost1 = poll[0];
            int p1 = poll[1], p2 = poll[2];
            if (uf.isConnected(p1, p2)) {
                continue;
            }
            uf.union(p1, p2);
            cost += cost1;
            count++;
        }
        return cost;
    }
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

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
