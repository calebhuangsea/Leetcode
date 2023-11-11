package Weekly370;
import java.util.*;
public class Q1 {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count += grid[i][j];
            }
            if (count == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
