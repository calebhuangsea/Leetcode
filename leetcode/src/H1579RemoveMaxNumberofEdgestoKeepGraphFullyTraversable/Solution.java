package H1579RemoveMaxNumberofEdgestoKeepGraphFullyTraversable;

public class Solution {
    /**
     * Union Find
     * Time: O(E * a(N))
     * Space: O(N)
     */
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);

        int count = 0;
        for (int[] e : edges) {
            if (e[0] == 3) {
                count += alice.union(e[1], e[2]);
                bob.union(e[1], e[2]);
                // count += (alice.union(e[1], e[2]) | bob.union(e[1], e[2]));
            }
        }

        for (int[] e : edges) {
            if (e[0] == 1) {//for alice
                count += alice.union(e[1], e[2]);
            } else if (e[0] == 2) {// for bob
                count += bob.union(e[1], e[2]);
            }
        }
        if (alice.check() && bob.check()) {
            return edges.length - count;
        }
        return -1;
    }

    class UnionFind {
        int[] parent;
        int[] size;
        int components;

        public UnionFind(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            components = n;
            for (int i = 0; i <=n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findRoot(int curr) {
            if (parent[curr] == curr) {
                return curr;
            }
            return parent[curr] = findRoot(parent[curr]);
        }

        public int union(int x, int y) {
            x = findRoot(x);
            y = findRoot(y);
            if (x == y) {
                return 0;
            }
            if (size[x] > size[y]) {
                size[x] += size[y];
                parent[y] = x;
            } else {
                size[y] += size[x];
                parent[x] = y;
            }
            components--;
            return 1;
        }

        public boolean check() {
            return components == 1;
        }
    }
}
