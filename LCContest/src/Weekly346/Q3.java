package Weekly346;
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Q3 q3 = new Q3();
    }

    /**
     We can use dfs to check every combination of the square string
     */
    public int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (dfs(0, i * i + "", i)) {
                sum += i * i;
            }
        }
        return sum;
    }

    private boolean dfs(int sum, String s, int target) {
        if (sum > target) {
            return false;
        }
        if (s.isEmpty() && sum == target) {
            return true;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (dfs(sum + Integer.parseInt(s.substring(0, i)), s.substring(i), target)) {
                return true;
            }
        }
        return false;
    }

}
