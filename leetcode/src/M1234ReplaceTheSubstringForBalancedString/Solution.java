package M1234ReplaceTheSubstringForBalancedString;

public class Solution {
    /**
     * Make sure that count for every character outside the interval is less than 1/4 * n
     * Time Complexity O(N) 96.82%
     * Space Complexity O(N) 42.5MB 49.55%
     */
    public int balancedString(String s) {
        int n = s.length();
        int target = n / 4;
        char[] arr = s.toCharArray();
        int[] count = new int[26];
        for (char c : arr) {
            count[c - 'A']++;
        }
        if (count['Q'-'A'] == target && count['W'-'A'] == target && count['E'-'A'] == target && count['R'-'A'] == target) {
            return 0;
        }
        int l = 0;
        int r;
        int min = n;
        for (r = 0; r < n; r++) {
            count[arr[r] - 'A']--;
            while (count['Q'-'A'] <= target && count['W'-'A'] <= target && count['E'-'A'] <= target && count['R'-'A'] <= target) {
                min = Math.min(r - l + 1, min);
                count[arr[l++] - 'A']++;
            }
        }
        return min;
    }
}
