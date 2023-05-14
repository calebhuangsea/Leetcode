package Weekly345;
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Q2 q2 = new Q2();
    }
    int start = 0;
    public boolean doesValidArrayExist(int[] derived) {
        // start from 1 and start from 0
        if (dfs(derived, 0, 0)) {
            return true;
        }
        start = 1;
        return dfs(derived, 0, 1);
    }

    private boolean dfs(int[] derived, int index, int curr) {
        if (index == derived.length - 1) {
            // check if this is valid
            return (curr ^ start) == derived[derived.length - 1];
        }
        if (curr == 0) {
            if (derived[index] == 0) {
                return dfs(derived, index + 1, 0);
            } else {
                return dfs(derived, index + 1, 1);
            }
        } else {
            if (derived[index] == 0) {
                return dfs(derived, index + 1, 1);
            } else {
                return dfs(derived, index + 1, 0);
            }
        }
    }
}
