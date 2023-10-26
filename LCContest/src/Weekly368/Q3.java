package Weekly368;
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Q3 q3 = new Q3();
        int[] nums = {10,10,10,3,1,1};
        System.out.println(q3.minGroupsForValidAssignment(nums));
    }

    public int minGroupsForValidAssignment(int[] nums) {
        // count: numbers of num
        Arrays.sort(nums);
        Map<Integer, Integer> count = new TreeMap<>();
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                count.put(i - start, count.getOrDefault(i - start, 0) + 1);
                start = i;
            }
        }
        count.put(nums.length - 1 - start + 1, count.getOrDefault(nums.length - 1 - start + 1, 0) + 1);

        // get the first min and second min
        int min = Integer.MAX_VALUE;
        for (int n : count.keySet()) {
            min = Math.min(n, min);
        }
        outer:
        for (int x = min; x >= 1; x--) {
            int sum = 0;
            for (int freq : count.keySet()) {
                if (freq % (x + 1) == 0) {
                    sum += freq / (x + 1) * count.get(freq);
                } else if (freq % (x) == 0) {
                    sum += freq / (x) * count.get(freq);
                } else {
                    if ((freq - x) % (x + 1) != 0 && (freq - x - 1) % x != 0) {
                        continue outer;
                    }
                    if ((freq - x) % (x + 1) != 0 ) {
                        sum += ((freq - x) / (x + 1) + 1) * count.get(freq);
                    } else {
                        sum += ((freq - x - 1) / (x) + 1) * count.get(freq);
                    }
                }
            }
            return sum;
        }
        return 0;
    }
}
