package Weekly346;
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Q2 q2 = new Q2();
        q2.makeSmallestPalindrome("egcfe");
    }

    /**
     Since we can not modify the string length and we need the minimum operation,
     we can just use two pointers to check from the front and the end and take
     change one of them to be the smaller character each time (because we have to
     change one of them when they are different)
     Time: O(N)
     Space: O(N)
     */

    public String makeSmallestPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] ss = s.toCharArray();
        while (l < r) {
            if (ss[l] < ss[r]) {
                ss[r] = ss[l];
            } else if (ss[l] > ss[r]) {
                ss[l] = ss[r];
            }
            l++;
            r--;
        }
        return new String(ss);
    }
}
