package M1376TimeNeededtoInformAllEmployees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(1)
     */
    int min = 0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(manager[i])) {
                map.put(manager[i], new ArrayList<>());
            }
            map.get(manager[i]).add(i);
        }
        dfs(0, headID, map, informTime);
        return min;
    }

    private void dfs(int count, int curr, Map<Integer, List<Integer>> map, int[] informTime) {
        if (!map.containsKey(curr)) {
            min = Math.max(min, count);
            return;
        }
        for (int sub : map.get(curr)) {
            dfs(count + informTime[curr], sub, map, informTime);
        }
    }
}
