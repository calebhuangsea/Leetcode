package Weekly348;

import Biweekly104.C;

import java.util.HashSet;
import java.util.Set;

public class Q1 {
    public int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }
}
