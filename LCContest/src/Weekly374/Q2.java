package Weekly374;
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        System.out.println(minimumAddedCoins(new int[] {1,4,10}, 19));
    }
    public static int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        long maxReach = 0; // Use long to avoid integer overflow
        int addedCoins = 0;
        int i = 0;

        while (maxReach < target) {
            if (i < coins.length && coins[i] <= maxReach + 1) {
                // We can extend our reach with the current coin
                maxReach += coins[i];
                i++;
            } else {
                // We need to add a coin to reach the next smallest value
                maxReach += maxReach + 1;
                addedCoins++;
            }
        }

        return addedCoins;
    }

}
