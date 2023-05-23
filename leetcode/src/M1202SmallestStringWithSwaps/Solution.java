package M1202SmallestStringWithSwaps;

import java.util.List;
import java.util.PriorityQueue;

class Solution {
    /**
     * Time: O(N + M * a(N) + N *nlog(n))
     * Space: O(V)
     */
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // we use union find so that indexes in the same group can swap freely and we can reorder them
        int n = s.length();
        // N
        UnionFind uf = new UnionFind(n);
        // M * a(N)
        for (List<Integer> ls : pairs) {
            uf.union(ls.get(0), ls.get(1));
        }
        // N
        int[] map = new int[n];
        PriorityQueue[] rk = new PriorityQueue[n];
        for (int i = 0; i < n; i++) {
            rk[i] = new PriorityQueue<>();
        }
        for (int i = 0; i < n; i++) {
            uf.find(i);
            map[i] = uf.root[i];
            rk[uf.root[i]].add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(rk[map[i]].poll());
        }
        return sb.toString();

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

