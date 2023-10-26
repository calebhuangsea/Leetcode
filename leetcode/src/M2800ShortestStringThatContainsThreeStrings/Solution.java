package M2800ShortestStringThatContainsThreeStrings;
import java.util.*;
public class Solution {
    /**
     Time: O(max(x,y,z) * (x+y+z))
     Space: O(x+y+z)
     */
    public String minimumString(String a, String b, String c) {
        List<String> res = new ArrayList<>();

        res.add(combine(combine(a,b),c));
        res.add(combine(combine(a,c),b));
        res.add(combine(combine(b,a),c));
        res.add(combine(combine(b,c),a));
        res.add(combine(combine(c,b),a));
        res.add(combine(combine(c,a),b));

        Collections.sort(res, (x,y)->x.length()==y.length() ? x.compareTo(y) : x.length()-y.length());

        return res.get(0);
    }

    private String combine(String a, String b) {
        if(a.contains(b)) {
            return a;
        }
        String second = b;
        int len=second.length();
        while(len>=0 && !a.endsWith(second)) {
            len--;
            second = second.substring(0, len);
        }

        return a + b.substring(len);
    }
}
