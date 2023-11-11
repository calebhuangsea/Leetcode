package Biweekly117;

public class Q1 {
    public int distributeCandies(int n, int limit) {
        int count = 0;
        for (int i = 1; i <= limit; i++) {
            for (int j = 1; j <= limit; j++) {
                for (int k = 1; k <= limit; k++) {
                    if (i + j + k <= n) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
