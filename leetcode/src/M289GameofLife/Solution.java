package M289GameofLife;

public class Solution {
    /**
     * Time: O(MN)
     * Space: O(MN)
     */
    int m;
    int n;
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        int[][] change = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] arr = count(board, i, j);
                if (board[i][j] == 0) {
                    arr[1]--;
                    if (arr[0] == 3) {
                        change[i][j] = 1;
                    } else {
                        change[i][j] = 0;
                    }
                } else {
                    arr[0]--;
                    if (arr[0] == 2 || arr[0] == 3) {
                        change[i][j] = 1;
                    } else {
                        change[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = change[i][j];
            }
        }
    }

    private int[] count(int[][] arr, int x, int y) {
        int live = 0;
        int die = 0;
        for (int i = x - 1; i <= Math.min(m - 1, x + 1); i++) {
            if (i < 0) {
                continue;
            }

            for (int j = y - 1; j <= Math.min(n - 1, y + 1); j++) {
                if (j < 0) {
                    continue;
                }
                if (arr[i][j] == 1) {
                    live++;
                } else {
                    die++;
                }
            }
        }
        return new int[]{live, die};
    }
}
