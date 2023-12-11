package DIV2.R914;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class C {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int times = sc.nextInt();
        while (times-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            Arrays.sort(a);

            long min = a[0];

            if (k == 1) {
                long diff = min;
                for (int i = 1; i < n; i++) {
                    diff = Math.min(diff, a[i] - a[i - 1]);
                }
                out.println(diff);
            } else if (k == 2) {
                long diff = min;
                TreeSet<Long> set = new TreeSet<>();
                for (int i = 0; i < n; i++) set.add(a[i]);
                for (int i = 0; i < n - 1; i++) {
                    for (int j = i + 1; j < n; j++) {
                        long temp = Math.abs(a[j] - a[i]);
                        diff = Math.min(diff, temp);
                        Long floor = set.floor(temp);
                        if (floor != null) diff = Math.min(diff, Math.abs(temp - floor));
                        Long ceiling = set.ceiling(temp);
                        if (ceiling != null)diff = Math.min(diff, Math.abs(temp - ceiling));



                        if (diff == 0) break;
                    }
                    if (diff == 0) break;
                }
                out.println(diff);
            } else if (k > 2) {
                out.println(0);
            }
        }
        out.close();
    }

    public static long findClosest(long arr[], long target) {
        int n = arr.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // At this point, left is the index of the closest element
        if (left == 0) {
            return arr[0];
        } else if (left == n) {
            return arr[n - 1];
        } else {
            // Compare the two closest elements
            long closest1 = arr[left];
            long closest2 = arr[left - 1];
            return Math.abs(target - closest1) < Math.abs(target - closest2) ? closest1 : closest2;
        }
    }



    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
}

