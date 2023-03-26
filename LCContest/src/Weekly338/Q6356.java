package Weekly338;

import java.util.*;

public class Q6356 {
    /**
     * Topological sort
     * @param coins
     * @param edges
     * @return
     */
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        List<Integer>[] nodes = new List[n];
        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            nodes[i] = new ArrayList<>();
        }
        // create a degree to for topological iteration
        int[] deg = new int[n];
        for (int[] edge : edges) {
            deg[edge[0]]++;
            deg[edge[1]]++;
            nodes[edge[0]].add(edge[1]);
            nodes[edge[1]].add(edge[0]);
        }
        // remove non-coin leaf node first
        Queue<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 1 && coins[i] == 0) {
                deque.add(i);
            }
        }
        // total amount of edges in the graph
        int totalEdges = n - 1;
        while (!deque.isEmpty()) {
            // remove the current edge
            int d = deque.poll();
            totalEdges -= 1;
            // update neighbor degree
            for (int neigh : nodes[d]) {
                deg[neigh]--;
                if (deg[neigh] == 1 && coins[neigh] == 0) {
                    deque.add(neigh);
                }
            }
        }
        // we have remove all non-coin leaves, now remove two degree of coins
        for (int i = 0; i < n; i++) {
            if (deg[i] == 1) {
                deque.add(i);
            }
        }
        totalEdges -= deque.size();
        for (int x : deque) {
            for (int neigh : nodes[x]) {
                deg[neigh]--;
                if (deg[neigh] == 1) {
                    totalEdges -= 1;
                }
            }
        }



        // we might have negative case if there is no coin, check edge cases
        return Math.max(totalEdges * 2, 0);
    }
}
