package E1275FindWinneronaTicTacToeGame;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public String tictactoe(int[][] moves) {
        int[] col = new int[3];
        int[] row = new int[3];
        int dia = 0;
        int anti = 0;
        int turn = 1;
        for (int[] m : moves) {
            int r = m[0];
            int c = m[1];
            // add to col and row first
            col[c] += turn;
            row[r] += turn;
            if (r == c) {
                dia += turn;
            }
            if (r + c == 2) {
                anti += turn;
            }
            if (Math.abs(col[c]) == 3 || Math.abs(row[r]) == 3 || Math.abs(dia) == 3 || Math.abs(anti) == 3) {
                return turn == 1 ? "A" : "B";
            }
            turn *= -1;
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }
}
