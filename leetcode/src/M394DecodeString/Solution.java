package M394DecodeString;

import java.util.Stack;

public class Solution {
    /**
     * Time Complexity O(N)
     * Space Complexity O(N)
     */
    int index;
    StringBuilder sb = new StringBuilder();
    String s;
    public String decodeString(String s) {
        index = s.length() - 1;
        this.s = s;
        return helper();
    }

    private String helper() {
        StringBuilder sb = new StringBuilder();
        while (index >= 0) {
            char c = s.charAt(index--);
            if (c == ']') {
                sb.insert(0, helper());
            } else if (c == '[') {
                // get digits
                int end = index;
                while (index >= 0) {
                    char d = s.charAt(index);
                    if (d - '0' >= 0  && d - '0' <= 9) {
                        index--;
                    } else {
                        break;
                    }
                }
                String digit = s.substring(index + 1, end + 1);
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < Integer.parseInt(digit); i++) {
                    sb2.append(sb);
                }
                return sb2.toString();
            } else {
                sb.insert(0, c);
            }
        }
        return sb.toString();
    }
}
