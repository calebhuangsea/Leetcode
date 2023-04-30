package Biweekly103;

import java.util.HashSet;
import java.util.Set;

public class Q2 {
    public static void main(String[] args) {
        int[] arr1 = new int[] {1,3,2,4};
        int[] a2 = new int[] {3,1,2,4};
        System.out.println(findThePrefixCommonArray(arr1, a2));
    }
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {

        int n = A.length;
        int[] count1 = new int[51];
        int[] count2 = new int[51];
        int[] res =  new int[n];
        res[0] = A[0] == B[0] ? 1 : 0;
        count1[A[0]]++;
        count2[B[0]]++;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1];
            count1[A[i]]++;
            if (count1[A[i]] == count2[A[i]]) {
                res[i]++;
            }
            count2[B[i]]++;
            if (count1[B[i]] == count2[B[i]]) {
                res[i]++;
            }
        }
        return res;
    }
}
