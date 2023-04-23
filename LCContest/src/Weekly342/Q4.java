package Weekly342;
import java.util.*;
public class Q4 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{2,10,6,14}));
        System.out.println(minOperations(new int[]{10,5,10,30,70,4,2,6,8,4}));
    }

    public static int minOperations(int[] nums) {
        // find step to a one
        int count = Integer.MAX_VALUE;
        List<Integer> ls = new ArrayList<>();
        if (nums[0] != 1) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 1) {
                    count = 0;
                    break;
                }
                int curr = gcd(nums[i - 1], nums[i]);
                if (curr == 1) {
                    count = Math.min(1, count);
                } else {
                    for (int j = i - 2; j >= 0; j--) {
                        if (gcd(ls.get(j), curr) == 1) {
                            count = Math.min(count, i - j);
                            break;
                        }
                    }
                }
                ls.add(curr);
            }
        } else {
            count = 0;
        }
        if (count == Integer.MAX_VALUE) {
            return  -1;
        }
        count = Math.max(0, count - 1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                count++;
            }
        }
        return count;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
