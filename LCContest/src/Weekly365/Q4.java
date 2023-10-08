package Weekly365;
import java.util.*;
public class Q4 {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public int[] countVisitedNodes(List<Integer> edges) {
        int j = 0;
        int n = edges.size();
        int[] res = new int[n];
        for (int i = 0; i < n; j = ++i) {
            Stack<Integer> s = new Stack<>();
            Set<Integer> seen = new HashSet<>();
            while (!seen.contains(j) && res[j] == 0) {
                s.push(j);
                seen.add(j);
                j = edges.get(j);
            }
            if (seen.contains(j)) {
                int k = s.size() - s.indexOf(j);
                for (j = 0; j < k; j++) {
                    res[s.pop()] = k;
                }
            }
            while (!s.isEmpty()) {
                j = s.pop();
                res[j] = res[edges.get(j)] + 1;
            }
        }
        return res;
    }
}
