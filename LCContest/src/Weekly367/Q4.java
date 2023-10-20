package Weekly367;
import java.util.*;
public class Q4 {
    public static void main(String[] args) {
        Q4 q = new Q4();
//        int[][] grid = {{4,3,9},{3,9,10},{9,7,8},{8,4,7},{6,1,3}};
//        int[][] grid = {{1,2},{3,4}};
        int[][] grid = {{414750857}, {449145368}, {767292749}};
        q.constructProductMatrix(grid);
    }

    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] res = new int[n][m];

        // Calculate prefix product
        int prefix = 1;
        res[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!(i == 0 && j == 0)) {
                    res[i][j] = prefix;
                }
                prefix = (int) (((long) prefix * grid[i][j]) % 12345);
            }
        }

        // Calculate suffix product
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (!(i == n - 1 && j == m - 1)) {
                    res[i][j] = (int) (((long) res[i][j] * suffix) % 12345);
                }
                suffix = (int) (((long) suffix * grid[i][j]) % 12345);
            }
        }

        return res;
    }
}

//[[615,7095,7776],[6480,9720,615],[6480,615,1845]]
//[[3255,225,75],[225,75,11178],[75,1860,7800],[7800,3255,1860],[6285,675,225]]