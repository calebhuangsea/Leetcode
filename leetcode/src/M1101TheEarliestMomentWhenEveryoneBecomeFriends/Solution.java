package M1101TheEarliestMomentWhenEveryoneBecomeFriends;

import java.util.Arrays;

class Solution {
    /**
     * Time: O(N + Mlog(M) + Ma(N))
     * Space: O(N)
     */
    public int earliestAcq(int[][] logs, int n) {

        Arrays.sort(logs, (a, b) -> a[0] - b[0]);

        UnionFind uf = new UnionFind(n);
        for (int[] log : logs) {
            if (uf.union(log[1], log[2])) {
                return log[0];
            }
            // System.out.println(Arrays.toString(uf.rank));
            // System.out.println(Arrays.toString(uf.root));
        }
        return -1;
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
            if (rank[rx] == rank.length) {
                return true;
            }
            rank[ry] = rank[rx];
            root[ry] = rx;
        } else {
            rank[ry] += rank[rx];
            if (rank[ry] == rank.length) {
                return true;
            }
            rank[rx] = rank[ry];
            root[rx] = ry;
        }
        return false;
    }
}

