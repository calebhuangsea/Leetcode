package M983MinimumCostForTickets;

/**
 * OPT(i) minimum cost of day i
 * Time Complexity O(N) 0ms 100%
 * Space Complexity O(N) 40.4MB 58.39%
 */
public class Solution {
    private int[] days;
    private int[] costs;
    private int[] duration = new int[] {1, 7, 30};
    private Integer[] dp;

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        dp = new Integer[days.length];
        return recur(0);
    }

    private int recur(int day) {
        if (day >= days.length) {
            return 0;
        }
        if (dp[day] != null) {
            return dp[day];
        }
        int j = day;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            while (j < days.length && days[j] < days[day] + duration[i]) {
                j++;
            }
            min = Math.min(min, recur(j) + costs[i]);
        }
        dp[day] = min;
        return min;
    }
}
