package Weekly343;
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        int[][] a2 = new int[][] {
                {1,3,8,5,2}, {6,5,3,3,1}, {4,3,3,1,4}
        };
        int[] s = new int[] {1, 1};
        int[] t = new int[] {8, 5};
        System.out.println(minimumCost(s, t, a2));
    }

    /**
     * Time: O(n^2 log(n))
     * Space: O(N)
     */
    public static int minimumCost(int[] start, int[] target, int[][] roads) {
        int n = roads.length;
        // cost[i] is the cost from start to the target of road[i]
        int[] costs  = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            costs[i] = cost(start[0], start[1], roads[i][0], roads[i][1]) + roads[i][4];
            if (costs[i] >= cost(start[0], start[1], roads[i][2], roads[i][3])) {
                continue;
            }
            pq.offer(new int[] {costs[i], i});
        }

        int res = cost(start[0], start[1], target[0], target[1]);
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currCost = curr[0];
            int currNode = curr[1];
            if (currCost != costs[currNode]) {
                // because this is not the shortest path already
                continue;
            }
            res = Math.min(res, currCost + cost(roads[currNode][2], roads[currNode][3], target[0], target[1]));
            for (int nei = 0; nei < n; nei++) {
                int neiCost = currCost + cost(roads[currNode][2], roads[currNode][3], roads[nei][0], roads[nei][1]) + roads[nei][4];
                if (neiCost < costs[nei]) {
                    costs[nei] = neiCost;
                    pq.offer(new int[] {neiCost, nei});
                }
            }
        }
        return res;
    }

    private static int cost(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
