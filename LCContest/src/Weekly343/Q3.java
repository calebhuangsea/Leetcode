package Weekly343;
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        int[][] a2 = new int[][] {
                {1,3,8,5,2}, {6,5,3,3,1}, {4,3,3,1,4}
        };
        int[] s = new int[] {1, 1};
        int[] t = new int[] {8, 5};
        System.out.println(minimumCost(s, t, a2));
    }

    public static int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int m = target[0];
        int n = target[1];
        int[][] dp = new int[m + 1][n + 1];
        Arrays.sort(specialRoads, new Comparator<int[]>() {
            @Override
            public int compare(int[] road1, int[] road2) {
                int result = Integer.compare(road1[2], road2[2]); // sort by x2i first
                if (result == 0) {
                    result = Integer.compare(road1[3], road2[3]); // if x2i is same, sort by y2i
                }
                return result;
            }
        });
        for (int[] arr : dp) {
            Arrays.fill(arr, 10000000);
        }
        dp[start[0]][start[1]] = 0;
        int index = 0;
        for (int i = 1 + start[0]; i < m + 1; i++) {
            dp[i][start[1]] = dp[i - 1][start[1]] + 1;

        }
        for (int i = 1 + start[1]; i < n + 1; i++) {
            dp[start[0]][i] = dp[start[0]][i - 1] + 1;
        }
        for (int i = start[0] + 1; i < m + 1; i++) {
            for (int j = start[1] + 1; j < n + 1; j++) {
                dp[i][j] = dp[i][j - 1] + 1;
            }
        }
        for (int[] road : specialRoads) {
            int cost = road[4] + dp[road[0]][road[1]];
            if (cost < dp[road[2]][road[3]]) {
                dp[road[2]][road[3]] = cost;
                for (int i = road[2]; i < m + 1; i++) {
                    for (int j = road[3]; j < n + 1; j++) {
                        if (i == road[2] && j == road[3]) {
                            continue;
                        }
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    }
                }
            }
        }
        return dp[m][n];
    }
}
