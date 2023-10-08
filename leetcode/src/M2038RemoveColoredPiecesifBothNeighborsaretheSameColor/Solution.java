package M2038RemoveColoredPiecesifBothNeighborsaretheSameColor;

public class Solution {
    /**
     * Time: O(N)
     * Space: O(1)
     */
    // simulation
    public boolean winnerOfGame(String colors) {
        if (colors.length() < 3) {
            return false;
        }
        int alice = 0;
        int bob = 0;
        char last = colors.charAt(0);
        int count = 1;
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == last) {
                count++;
            } else {
                if (count >= 3) {
                    if (last == 'A') {
                        alice += count - 2;
                    } else {
                        bob += count - 2;
                    }
                }
                last = colors.charAt(i);
                count = 1;
            }
        }
        if (count >= 3) {
            if (last == 'A') {
                alice += count - 2;
            } else {
                bob += count - 2;
            }
            count = 1;
        }
        return alice > bob;
    }
}