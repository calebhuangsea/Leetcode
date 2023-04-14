package H51N_Queens;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Time Complexity O(N!)
     * Space Complexity O(N^2)
     */
    List<List<String>> list = new ArrayList<>();
    int n;
    char[][] board;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(0);
        return list;
    }

    private void dfs(int col) {
        if (col == n) {
            list.add(create());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(i, col)) {
                board[i][col] = 'Q';
                dfs(col + 1);
                board[i][col] = '.';
            }
        }
    }

    private boolean check(int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'Q' && (x + y == i + j || x + j == y + i || x == i || y == j))
                    return false;
            }
        }

        return true;
    }

    private List<String> create() {
        List<String> ls = new ArrayList<>();
        for (char[] b : board) {
            ls.add(new String(b));
        }
        return ls;
    }
}
