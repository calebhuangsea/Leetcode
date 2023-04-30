package SnowFlake;

import java.util.Arrays;

/**
 * https://www.1point3acres.com/bbs/thread-990167-1-1.html
 * DP
 * 记得用long然后转为int
 * Maximize Array Value
 * 二分法
 * 记得用long然后转为int
 *
 * https://www.geeksforgeeks.org/number-of-distinct-words-of-size-n-with-at-most-k-contiguous-vowels/
 */
public class StringPattern {
    public static void main(String[] args) {
        System.out.println(kvowelwords(2,2));
    }

    static int power(int x, int y, int p)
    {
        int res = 1;
        x = x % p;

        if (x == 0)
            return 0;

        while (y > 0)
        {
            if ((y & 1) != 0)
                res = (res * x) % p;

            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    // Function for finding number of ways to
// create string with length N and atmost
// K contiguous vowels
    static int kvowelwords(int N, int K)
    {
        int i, j;
        int MOD = 1000000007;

        // Array dp to store number of ways
        int[][] dp = new int[N + 1][K + 1] ;

        int sum = 1;
        for(i = 1; i <= N; i++)
        {

            // dp[i][0] = (dp[i-1][0]+dp[i-1][1]..dp[i-1][k])*21
            dp[i][0] = sum * 21;
            dp[i][0] %= MOD;

            // Now setting sum to be dp[i][0]
            sum = dp[i][0];

            for(j = 1; j <= K; j++)
            {

                // If j>i, no ways are possible to create
                // a string with length i and vowel j
                if (j > i)
                    dp[i][j] = 0;

                else if (j == i)
                {

                    // If j = i all the character should
                    // be vowel
                    dp[i][j] = power(5, i, MOD);
                }
                else
                {

                    // dp[i][j] relation with dp[i-1][j-1]
                    dp[i][j] = dp[i - 1][j - 1] * 5;
                }

                dp[i][j] %= MOD;

                // Adding dp[i][j] in the sum
                sum += dp[i][j];
                sum %= MOD;
            }
        }
        return sum;
    }
}
