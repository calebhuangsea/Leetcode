package M254FactorCombinations;
import java.util.*;
public class Solution {
    /**
     * Time Complexity O(N^1.5)
     * Space Complexity O(Nlog(N))
     */
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> getFactors(int n) {
        if (n < 2) {
            return res;
        }
        dfs(n, new ArrayList<>(), 2);
        return res;
    }

    private void dfs(int n, List<Integer> ls, int last) {
        if (n <= 1 && ls.size() > 1) {
            if (ls.size() > 1) {
                res.add(new ArrayList<>(ls));
            }
            return;
        }
        for (int i = last; i <= n; i++) {
            if (n % i == 0) {
                ls.add(i);
                dfs(n / i, ls, i);
                ls.remove(ls.size() - 1);
            }
        }
    }
}
