package M1881MaximumValueafterInsertion;

public class Soluion {
    /**
     * Time: O(N)
     * Space: O(1)
     */
    public String maxValue(String n, int x) {
        int len = n.length();
        if (n.charAt(0) == '-') {
            for (int i = 1; i < len; i++) {
                if ((int)(n.charAt(i) - '0') > x) {
                    return n.substring(0, i) + x + n.substring(i, len);
                }
            }
        } else {
            // if it is positive, we insert it as left as possible
            for (int i = 0; i < len; i++) {
                if ((int)(n.charAt(i) - '0') < x) {
                    return n.substring(0, i) + x + n.substring(i, len);
                }
            }
        }
        return n + x;
    }
}
