package Biweekly117;

import java.util.Arrays;

public class Q4 {
    public long maxSpending(int[][] values) {
        int m = values.length, n = values[0].length;
        int[] indexes = new int[m];
        Arrays.fill(indexes, n - 1);
        long sum = 0;
        long d = 1;
        while (true) {
            int min = -1;
            for (int i = 0; i < m; i++) {
                if (indexes[i] == -1) continue;
                if (min == -1) {
                    min = i;
                } else if (values[i][indexes[i]] < values[min][indexes[min]]) {
                    min = i;
                }
            }
            if (min == -1) break;
            sum += values[min][indexes[min]] * d++;
            indexes[min]--;
        }
        return sum;
    }
}
