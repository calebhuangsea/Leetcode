package E13RomantoInteger;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        int i = 0;
        int count = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (i + 1 < s.length()) {
                char c2= s.charAt(i + 1);
                if (map.containsKey(c + "" + c2)) {
                    count += map.get(c + "" + c2);
                    i++;
                } else {
                    count += map.get(c + "");
                }
            } else {
                count += map.get(c + "");
            }

            i++;
        }
        return count;
    }
}
