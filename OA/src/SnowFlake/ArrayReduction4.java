package SnowFlake;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.1point3acres.com/bbs/thread-976905-1-1.html
 * https://codeforces.com/contest/1628/problem/A
 */
public class ArrayReduction4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] f = new int[n + 1];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                f[a[i]]++;
            }
            int mex = 0;
            for (int i = 0; i <= n + 1; i++) {
                if (f[i] == 0) {
                    mex = i;
                    break;
                }
            }
            int j = mex;
            Set<Integer> map = new HashSet<>();

            StringBuilder sb = new StringBuilder("");
            int c = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] < mex) {
                    f[a[i]]--;
                    map.add(a[i]);
                    if (f[a[i]] == 0) {
                        if (j > a[i]) {
                            j = a[i];
                        }
                    }
                }
                if (map.size() == mex) {
                    c++;
                    sb.append(mex + " ");
                    map.clear();
                    mex = j;
                }
            }
            System.out.println(c);
            System.out.println(sb);
        }
    }
}
