package Weekly349;
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Q2 q2 = new Q2();
        System.out.println(q2.smallestString("aab"));
    }
    public String smallestString(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        if (c[c.length - 1] == 'a') {
            return s.substring(0, s.length() - 1) + "z";
        }
        StringBuilder sb = new StringBuilder();
        int idx = s.indexOf('a');
        if (idx == 0) {
            sb.append('a');
            int i;
            for (i = 1; i < s.length(); i++) {
                if (s.charAt(i) != 'a') {
                    break;
                } else {
                    sb.append('a');
                }
            }
            for (int j = i; j < s.length(); j++, i++) {
                if (s.charAt(j) == 'a') {
                    break;
                } else {
                    sb.append((char)(s.charAt(j) - 1));
                }
            }
            for (int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
            }
        } else if (idx == -1) {
            for (int i = 0; i < s.length(); i++) {
                sb.append((char)(s.charAt(i) - 1));
            }
        } else {
            for (int i = 0; i < idx; i++) {
                sb.append((char)(s.charAt(i) - 1));
            }
            for (int i = idx; i < s.length(); i++) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
