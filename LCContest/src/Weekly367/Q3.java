package Weekly367;
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Q3 q = new Q3();
        int[] nums = {5, 1, 4, 1};
        q.findIndices(nums, 2, 4);
    }

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[][] p1 = new int[nums.length][2];
        int[][] p2 = new int[nums.length][2];
        p1[0][0] = nums[0];
        p1[0][1] = 0;
        p2[0][0] = nums[0];
        p2[0][1] = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < p1[i - 1][0]) {
                p1[i][0] = nums[i];
                p1[i][1] = i;
            } else {
                p1[i][0] = p1[i - 1][0];
                p1[i][1] = p1[i - 1][1];
            }
            if (nums[i] > p2[i - 1][0]) {
                p2[i][0] = nums[i];
                p2[i][1] = i;
            } else {
                p2[i][0] = p2[i - 1][0];
                p2[i][1] = p2[i - 1][1];
            }
        }

        for (int i = indexDifference; i < nums.length; i++) {
            int max = Math.abs(nums[i] - p1[i - indexDifference][0]);
            int min = Math.abs(nums[i] - p2[i - indexDifference][0]);
            if (max >= valueDifference) {
                return new int[] {p1[i - indexDifference][1], i};
            }
            if (min >= valueDifference) {
                return new int[] {p2[i - indexDifference][1], i};
            }
        }

        return new int[] {-1, -1};
    }
}
