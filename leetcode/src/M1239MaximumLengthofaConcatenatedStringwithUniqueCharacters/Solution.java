package M1239MaximumLengthofaConcatenatedStringwithUniqueCharacters;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    /**
     * Time: O(2^N)
     * Space: O(2^(min(N, K)))
     */
    // backtracking?
    int max = 0;
    public int maxLength(List<String> arr) {
        dfs(arr, "", 0);
        return max;
    }

    private void dfs(List<String> arr, String curr, int index) {
        max = Math.max(curr.length(), max);

        for (int i = index; i < arr.size(); i++) {
            String nei = arr.get(i);
            boolean flag = true;
            Set<Character> v = new HashSet<>();
            for (int j = 0; j < nei.length() && flag; j++) {
                if (v.contains(nei.charAt(j))) {
                    flag = false;
                }
                v.add(nei.charAt(j));
                if (curr.indexOf(nei.charAt(j)) != -1) {
                    flag = false;
                }
            }
            if (!flag) {
                continue;
            }
            dfs(arr, curr + nei, i + 1);
        }
    }
}
