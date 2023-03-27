package E1207UniqueNumberOfOccurrences;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Sort and iterate through it
 * Time Complexity: O(Nlog(N)) 99.57%
 * Space Complexity: O(1) 40.8MB 39.18%
 */
public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> freq = new HashSet<>();
        Arrays.sort(arr);
        int curr = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != curr) {
                if (freq.contains(count)) {
                    return false;
                }
                freq.add(count);
                curr = arr[i];
                count = 1;
            } else {
                count++;
            }
        }
        return !freq.contains(count);
    }
}
