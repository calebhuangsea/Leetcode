package Weekly343;
import java.util.*;
public class Q4 {
    public static void main(String[] args) {
    }

    /**
     * Time: O(N)
     * Space: O(N)
     */
    public String smallestBeautifulString(String S, int k) {
        k += 'a';
        char[] s = S.toCharArray();
        int n = s.length;
        int i = n - 1; // start from the last one
        s[i]++; // increase the last
        while (i < n) {
            if (s[i] == k) {
                // need to round and go ahead
                if (i == 0) {
                    // cannot round
                    return "";
                }
                s[i] = 'a';
                s[--i]++;
            } else if (i > 0 && s[i] == s[i - 1] || i > 1 && s[i] == s[i - 2]) {
                ++s[i];
            } else {
                i++;
            }
        }
        return new String(s);
    }
}
