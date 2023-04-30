package SnowFlake;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.1point3acres.com/bbs/thread-985400-1-1.html
 * 二分答案
 * 对于每个mid，
 * 1. 至少有一个row出现两次>=mid的数字
 * 2. 每个col都出现一次>= mid的数字
 * 即可。
 */
public class ServerSelection {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] a = new int[n + 1][m + 1];
        int []row=new int[n+1];
        int maxVal = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = sc.nextInt();
                maxVal = Math.max(maxVal, a[i][j]);
            }
        }

        int low = 1;
        int high = maxVal;

        int ans = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            boolean flag = false;
            boolean flag1 = false;
            Arrays.fill(row,0);
            for (int j = 1; j <= m; j++) {
                boolean found = false;
                for (int i = 1; i <= n; i++) {
                    if (a[i][j] >= mid) {
                        found = true;

                        row[i]++;
                        if(row[i]>1)
                        {
                            flag1=true;
                            break;
                        }
                    }
                }
                if (!found) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                high = mid - 1;
            } else if(flag1){

                low = mid + 1;
                ans = mid;
            }
            else {
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
