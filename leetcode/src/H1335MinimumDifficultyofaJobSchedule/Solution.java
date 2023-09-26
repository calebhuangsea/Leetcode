package H1335MinimumDifficultyofaJobSchedule;

class Solution {
    /**
     * Time: O(d * (n - d ^ 2))
     * Space: O((n - d) * d)
     */
    int n, d;
    int[] jobDifficulty, hardestJobRemaining;
    int[][] memo;

    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }
        this.d = d;
        this.jobDifficulty = jobDifficulty;
        this.n = jobDifficulty.length;
        this.hardestJobRemaining = new int[n];
        this.memo = new int[n][d];
        int hard = 0;
        for (int i = n - 1; i >= 0; i--) {
            hard = Math.max(hard, jobDifficulty[i]);
            hardestJobRemaining[i] = hard;
        }

        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return dp(0, 1);
    }

    private int dp(int i, int day) {
        if (day == d) {
            return hardestJobRemaining[i];
        }
        if (memo[i][day] == -1) {
            // list out all possible options
            int min = Integer.MAX_VALUE;
            int hard = 0;
            for (int j = i; j < (n - d + day); j++) {
                hard = Math.max(hard, jobDifficulty[j]);
                min = Math.min(min, hard + dp(j + 1, day + 1));
            }
            memo[i][day] = min;
        }

        return memo[i][day];
    }
}
