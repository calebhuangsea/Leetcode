package Other.R1900;

import java.util.Arrays;
import java.util.Scanner;

public class I883IIPhotoProcessing {
    private static int N, K;
    private static final int MAX_N = 300000 + 16;
    private static int[] V = new int[MAX_N];
    private static int[] dp = new int[MAX_N];

    private static boolean C(int mid)
    {
        int last = 0;
        for (int i = K; i <= N; i++)
        {
            int j = dp[i-K];
            if (V[i] - V[j+1] <= mid)     last = i;
            dp[i] = last;
        }
        return dp[N] == N;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        N = in.nextInt(); K = in.nextInt();

        for (int i = 1; i <= N; i++)
        {
            V[i] = in.nextInt();
        }

        Arrays.sort(V, 1, N+1);

        int lb = 0, ub = 1000000000;
        while (lb <= ub)
        {
            int mid = (lb + ub) >> 1;
            if (C(mid))     ub = mid - 1;
            else            lb = mid + 1;
        }

        System.out.println(lb);
    }
}
