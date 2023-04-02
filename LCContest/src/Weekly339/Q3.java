package Weekly339;

public class Q3 {
    public static void main(String[] args) {
        System.out.println(miceAndCheese(new int[]{1, 1, 3, 4}, new int[]{4, 4, 1, 1}, 2));
        System.out.println(miceAndCheese(new int[]{2, 1}, new int[]{1, 2}, 1));
        System.out.println(miceAndCheese(new int[]{1}, new int[]{4}, 1));
        System.out.println(miceAndCheese(new int[]{2,1,1,5}, new int[]{5,6,6,5}, 3));
    }
    public static int miceAndCheese(int[] reward1, int[] reward2, int k) {

        int n = reward1.length;
        int[][] dp = new int[2][n];
        int old;
        int next;
        dp[0][0] = reward2[0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = reward2[i] + dp[0][i - 1];
        }

        for (int i = 1; i <= k; i++) {
            if (i % 2 == 0) {
                old = 1;
                next = 0;
            } else {
                old = 0;
                next = 1;
            }
            dp[next][0] = reward1[0];
            for (int j = 1; j < i; j++) {
                dp[next][j] = reward1[j] + dp[next][j - 1];
            }
            for (int j = i; j < n; j++) {
                dp[next][j] = Math.max(reward1[j] + dp[old][j - 1], reward2[j] + dp[next][j - 1]);
            }
        }
        if (k % 2 == 1) {
            return dp[1][n - 1];
        }
        return dp[0][n - 1];
//        return helper(reward1, reward2, 0, k, 0);
    }

    private static int helper(int[] reward1, int[] reward2, int index, int k, int sum) {
        if (k == 0) {
            if (index != reward1.length) {
                return helper(reward1, reward2, index + 1, k, sum + reward2[index]);
            } else {
                return sum;
            }
        }
        if (index == reward1.length) {
            return -1;
        }
        // if we eat
        int eat = helper(reward1, reward2, index + 1, k - 1, sum + reward1[index]);
        // if we don't eat
        int not = helper(reward1, reward2, index + 1, k, sum + reward2[index]);
        return Math.max(eat, not);
    }

}
