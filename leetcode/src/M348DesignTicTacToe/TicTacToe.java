package M348DesignTicTacToe;

/**
 * Time: O(1)
 * Space: O(N^2)
 */
public class TicTacToe {
    int[] rows;
    int[] cols;
    int dia = 0;
    int anti = 0;
    int n;
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        player = (player == 1) ? 1 : -1;
        rows[row] += player;
        cols[col] += player;

        if (row == col) {
            dia += player;
        }

        if (row + col == n - 1) {
            anti += player;
        }
        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(dia) == n || Math.abs(anti) == n) {
            return player == 1 ? 1 : 2;
        }
        return 0;
    }
}