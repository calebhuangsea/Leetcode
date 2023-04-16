package Biweekly102;

public class Q1 {
    public int[] findColumnWidth(int[][] grid) {
        int[] res = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j  = 0; j < grid[0].length; j++) {
                res[j] = Math.max(res[j], (grid[i][j] + "").length());
            }
        }
        return res;
    }
}
