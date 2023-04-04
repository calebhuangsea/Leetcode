package M528RandomPickWithWeight;

public class Solution {
    /**
     * Time Complexity O(N) constructor O(log(N)) pick 31ms 57.2%
     * Space Complexity O(N)  46.8MB 85.77%
     */
    private int[] prefix;
    private int total;

    public Solution(int[] w) {
        prefix = w;
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        total = prefix[w.length - 1];
    }

    public int pickIndex() {
        return binarySearch(total * Math.random());
    }

    // left most index to insert target
    private int binarySearch(double target) {
        int l = 0;
        int h = prefix.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (prefix[m] < target) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return l;
    }
}
