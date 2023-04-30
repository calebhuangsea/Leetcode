package Weekly343;
import java.util.*;
public class Q1 {
    public static void main(String[] args) {

    }

    public int isWinner(int[] player1, int[] player2) {
        int diff = 0;
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < player1.length; i++) {
            int v1 = player1[i];
            int v2 = player2[i];
            if (index1 != -1 && i - index1 <= 2) {
                v1 *= 2;
            }
            if (index2 != -1 && i - index2 <= 2) {
                v2 *= 2;
            }
            if (player1[i] == 10) {
                index1 = i;
            }
            if (player2[i] == 10) {
                index2 = i;
            }
            diff += (v1 - v2);
        }
        if (diff > 0) {
            return 1;
        } else if (diff < 0) {
            return 2;
        } else {
            return 0;
        }
    }
}
