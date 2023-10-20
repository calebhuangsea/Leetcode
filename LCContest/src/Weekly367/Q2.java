package Weekly367;
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Q2 q = new Q2();
        System.out.println("1".compareTo("10"));
        System.out.println("11001".compareTo("100011"));
        q.shortestBeautifulSubstring("11000111", 1);
    }

    public String shortestBeautifulSubstring(String s, int k) {
        String res = "";
        int count = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '1') {
                count++;
            }
            while (count > k || (start < s.length() && s.charAt(start) != '1')) {
                if (s.charAt(start) == '1') {
                    count--;
                }
                start++;
            }
            if (count == k) {
                String substring = s.substring(start, i + 1);
                if (res.equals("")) {
                    res = substring;
                } else if (res.length() > substring.length()) {
                    res = substring;
                } else if (res.length() == substring.length() && res.compareTo(substring) > 0) {
                    res = substring;
                }

            }
        }
        return res;
    }
}
