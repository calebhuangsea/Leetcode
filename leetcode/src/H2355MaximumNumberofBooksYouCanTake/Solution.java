package H2355MaximumNumberofBooksYouCanTake;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     * @param books
     * @return
     */
    public long maximumBooks(int[] books) {
        int n = books.length;
        Stack<Integer> s = new Stack<>();
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && books[s.peek()] - s.peek() >= books[i] - i) {
                s.pop();
            }
            if (s.isEmpty()) {
                dp[i] = calc(books, 0, i);
            } else {
                int j = s.peek();
                dp[i] = dp[j] + calc(books, j + 1, i);
            }
            s.push(i);
        }
        return Arrays.stream(dp).max().getAsLong();
    }

    private long calc(int[] books, int l, int r) {
        long cnt;
        if (books[r] < r - l + 1) {
            cnt = books[r];
        } else {
            cnt = r- l + 1;
        }
        return (2 * books[r] - (cnt - 1)) * cnt / 2;
    }
}
