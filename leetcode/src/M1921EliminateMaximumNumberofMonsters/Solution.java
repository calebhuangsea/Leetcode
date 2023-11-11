package M1921EliminateMaximumNumberofMonsters;

public class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int eliminateMaximum(int[] d, int[] s) {
        int n = d.length;
        int[] r = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int diff;
            if (d[i] < s[i]) diff = 1;
            else diff = d[i] / s[i] + (d[i] % s[i] == 0 ? 0 : 1);
            r[Math.min(diff, n)] ++;
        }
        int count = 0;
        int acc = 0;
        for (int i = 1; i <= n; i++) {
            acc++;
            if (r[i] > acc) return count + acc;
            else {
                count += r[i];
                acc -= r[i];
            }
        }
        return n;
    }
}
