package E733FloodFill;

public class Solution {
    /**
     * DFS
     * Time Complexity O(MN) 0ms 100%
     * Space Complexity O(1) 43.5MB 41.26%
     */
    int m;
    int n;
    int[][] image;
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int c) {
        m = image.length;
        n = image[0].length;
        this.image = image;
        color = image[sr][sc];
        if (image[sr][sc] != c) {
            dfs(sr, sc, c);
        }
        return image;
    }

    private void dfs(int i, int j, int newColor) {
        if (i < 0 || j < 0 || i == m || j == n || image[i][j] != color) {
            return;
        }
        image[i][j] = newColor;
        dfs(i - 1, j, newColor);
        dfs(i + 1, j, newColor);
        dfs(i, j - 1, newColor);
        dfs(i, j + 1, newColor);
    }
}
