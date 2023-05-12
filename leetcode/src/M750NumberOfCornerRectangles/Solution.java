package M750NumberOfCornerRectangles;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * Time: O(MMN)
     * Space: O(M^2)
     */
    public int countCornerRectangles(int[][] grid) {
        int[][] dp=new int[grid[0].length][grid[0].length];
        int total=0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1) {
                    for(int k=0;k<j;k++) {
                        if(grid[i][k]==1) {
                            total+=dp[k][j];
                            dp[k][j]++;
                        }
                    }
                }
            }
        }
        return total;
    }
}
