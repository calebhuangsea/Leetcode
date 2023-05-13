package Biweekly104;
import java.util.*;
public class B {
    public static void main(String[] args) {
        System.out.println();
        B b = new B();
//        int[][] arr = new int[][] {{12,20,0,19,15,10,7,10,2,6,18,7,7,4}, {17,14,2,2,10,16,15,3,9,17,9,3,17,10},
//                {17,6,19,17,18,9,14,2,19,12,10,18,7,9}, {5,6,5,1,19,8,15,2,2,4,4,1,2,17}, {12,16,8,16,7,6,18,13,18,8,14,15,20,11},
//                {2,10,19,3,15,18,20,10,6,7,0,8,3,7}, {11,5,10,13,1,3,4,7,1,18,20,17,19,2}, {0,3,20,6,19,18,3,12,2,11,3,1,19,0},
//                {6,5,3,15,6,1,0,17,13,19,3,8,2,7}, {2,20,9,11,13,5,1,16,14,1,19,3,12,6}};
//        System.out.println(b.matrixSum(arr));
    }

    public int matrixSum(int[][] nums) {
        int sum = 0;
        int m = nums.length;
        int n = nums[0].length;
        for (int[] arr : nums) {
            Arrays.sort(arr);
        }
        for (int j = 0; j < n; j++) {
            int num = 0;
            for (int i = 0; i < m; i++) {
                num = Math.max(num, nums[i][j]);
            }
            sum += num;
        }
        return sum;
    }
}
