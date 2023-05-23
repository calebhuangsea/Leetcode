package M323NumberofConnectedComponentsinanUndirectedGraph;

class Solution {
    /**
     * Time: O(E * a(n))
     * Space: O(V)
     */
    public int countComponents(int n, int[][] edges) {

        UnionFind uf = new UnionFind(n);

        for (int[] e : edges) {
            if (uf.union(e[0], e[1])) {
                n--;
            }
        }
        return n;
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
}
