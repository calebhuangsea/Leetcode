package M210CourseScheduleII;

import java.util.*;

public class Solution {
    /**
     * Create graph, keep track of income degree and apply topological iteration with dfs and visited list
     * Time Complexity O(V + E) 7ms 44.53%
     * Space Complexity O(V + E) 43.3MB 75.89%
     */
    public int[] findOrder(int n, int[][] prerequisites) {
        int[] income = new int[n];
        Map<Integer, List<Integer>> neigh = new HashMap<>();
        for (int[] arr : prerequisites) {
            income[arr[0]]++;
            if (!neigh.containsKey(arr[1])) {
                neigh.put(arr[1], new ArrayList<>());
            }
            neigh.get(arr[1]).add(arr[0]);
        }
        List<Integer> list = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (income[i] == 0 && !visited.contains(i)) {
                visited.add(i);
                list.add(i);
                dfs(visited, list, neigh, i, income);
            }
        }
        if (list.size() < n) {
            return new int[0];
        }
        int[] res = new int[n];
        for (int i = 0 ; i < n; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(Set<Integer> visited, List<Integer> list, Map<Integer, List<Integer>> neigh,
                     int i, int[] income) {
        for (int j : neigh.getOrDefault(i, new ArrayList<>())) {
            income[j]--;
            if (income[j] == 0 && !visited.contains(j)) {
                visited.add(j);
                list.add(j);
                dfs(visited, list, neigh, j, income);
            }
        }
    }
}
