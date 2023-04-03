package M881BoatsToSavePeople;

import java.util.Arrays;

public class Solution {
    /**
     * Time Complexity O(Nlog(N)) 17ms 98.31%
     * Space Complexity O(1) 50.4MB 79.97%
     */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int lo = 0;
        int hi = people.length - 1;
        int sum = 0;
        while (lo <= hi) {
            if (people[lo] + people[hi] <= limit) {
                lo++;
                hi--;
            } else {
                hi--;
            }
            sum++;
        }
        return sum;
    }
}
