package M649Dota2Senate;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public String predictPartyVictory(String senate) {
        // O(N)
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        int n = senate.length();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                r.add(i);
            } else {
                d.add(i);
            }
        }
        while (!r.isEmpty() && !d.isEmpty()) {
            int r1 = r.poll();
            int d1 = d.poll();
            if (r1 < d1) {
                r.add(r1 + n);
            } else {
                d.add(d1 + n);
            }
        }

        return !r.isEmpty() ? "Radiant" : "Dire";
    }
}
