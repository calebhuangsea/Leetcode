package Weekly341;

import java.util.*;

public class Q4 {
    /**
     * Time: O(MN)
     * Space: O(n)
     */
    int[] count;
    List<List<Integer>> adj = new ArrayList<>();
    int end;
    int[] price;
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        count = new int[n];
        this.price = price;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        // calculate count
        for (int[] t : trips) {
            end = t[1];
            path(t[0], -1);
        }
        // then use rob to see whether we reduce curr or not
        int[] arr = dfs(0, -1);
        return Math.min(arr[0], arr[1]);
    }

    private int[] dfs(int node, int parent) {
        int total = count[node] * price[node];
        int half = total / 2;
        for (int neigh : adj.get(node)) {
            if (neigh != parent) {
                int[] arr = dfs(neigh, node);
                total += Math.min(arr[0], arr[1]);
                half += arr[0];
            }
        }
        return new int[] {total, half};
    }

    private boolean path(int node, int parent) {
        if (node == end) {
            count[node]++;
            return true;
        }

        for (int neigh : adj.get(node)) {
            if (neigh != parent && path(neigh, node)) {
                count[node]++;
                return true;
            }
        }
        return false;
    }

}
