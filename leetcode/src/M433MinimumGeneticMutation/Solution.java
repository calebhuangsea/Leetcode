package M433MinimumGeneticMutation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    /**
     * Time: O(B)
     * Space: O(B)
     */
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> valid = new HashSet<>();
        for (String s : bank) {
            valid.add(s);
        }
        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        char[] dir = new char[] {'A', 'C', 'G', 'T'};

        Queue<String> q = new LinkedList<>();
        q.add(startGene);
        int step = 0;
        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String string = q.poll();
                if (string.equals(endGene)) {
                    return step;
                }
                for (char c : dir) {
                    for (int j = 0; j < 8; j++) {
                        String nei = string.substring(0, j) + c + string.substring(j + 1);
                        if (!visited.contains(nei) && valid.contains(nei)) {
                            visited.add(nei);
                            q.add(nei);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
