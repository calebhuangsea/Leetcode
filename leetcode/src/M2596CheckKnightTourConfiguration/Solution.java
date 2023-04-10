package M2596CheckKnightTourConfiguration;

public class Solution {
    /**
     * Time Complexity O(MN)
     * Space Complexity O(MN)
     */
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        int n = grid.length;
        int[][] move = new int[(n) * (n)][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                move[grid[i][j]] = new int[] {i, j};
            }
        }
        for (int i = 0; i < move.length - 1; i++) {
            if (!check(move[i][0], move[i][1], move[i + 1][0], move[i + 1][1])) {
                return false;
            }
        }
        return true;
    }

    private boolean check(int i1, int j1, int i2, int j2) {
        int h = i1 - i2;
        int v = j1 - j2;
        if (h > 0) {//up
            if (h == 1) {
                if (v == 2) {
                    return true;
                } else if (v == -2) {
                    return true;
                } else {
                    return false;
                }
            } else if (h == 2) {
                if (v == 1) {
                    return true;
                } else if (v == -1) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {//down
            if (h == -1) {
                if (v == 2) {
                    return true;
                } else if (v == -2) {
                    return true;
                } else {
                    return false;
                }
            } else if (h == -2) {
                if (v == 1) {
                    return true;
                } else if (v == -1) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
