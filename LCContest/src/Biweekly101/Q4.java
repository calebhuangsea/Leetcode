package Biweekly101;

import java.util.*;

public class Q4 {
    public int findShortestCycle(int n, int[][] edges) {
        // initialize the undirected adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }
            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<>());
            }
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return shortest_cycle(n, graph);
    }

    static int shortest_cycle(int n, Map<Integer, List<Integer>> graph) {

        // To store length of the shortest cycle
        int ans = Integer.MAX_VALUE;

        // For all vertices
        for (int i = 0; i < n; i++) {
            // Make distance maximum
            int[] dist = new int[n];
            Arrays.fill(dist, (int) 1e9);

            // Take a imaginary parent
            int[] par = new int[n];
            Arrays.fill(par, -1);

            // Distance of source to source is 0
            dist[i] = 0;
            Queue<Integer> q = new LinkedList<>();

            // Push the source element
            q.add(i);

            // Continue until queue is not empty
            while (!q.isEmpty()) {
                // Take the first element
                int x = q.poll();

                // Traverse for all it's childs
                if (graph.containsKey(x)) {
                    for (int child : graph.get(x)) {
                        // If it is not visited yet
                        if (dist[child] == (int) (1e9)) {

                            // Increase distance by 1
                            dist[child] = 1 + dist[x];

                            // Change parent
                            par[child] = x;

                            // Push into the queue
                            q.add(child);
                        } else if (par[x] != child && par[child] != x)
                            ans = Math.min(ans, dist[x] + dist[child] + 1);
                    }
                }
            }
        }

        // If graph contains no cycle
        if (ans == Integer.MAX_VALUE)
            return -1;

            // If graph contains cycle
        else
            return ans;
    }
}
