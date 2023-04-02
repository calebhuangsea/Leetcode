package Weekly339;

public class Q1 {
    public int findTheLongestBalancedSubstring(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int max = 0;
        // hold a size = 2 sliding windows to check
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0' && s.charAt(i + 1) == '1') {
                // expand it and take this as middle
                max = Math.max(max, expand(s, i, i + 1));
            }
        }
        return max;
    }

    private int expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == '0' && s.charAt(r) == '1') {
            l--;
            r++;
        }
        // 01
        return r - l - 1;
    }
}
