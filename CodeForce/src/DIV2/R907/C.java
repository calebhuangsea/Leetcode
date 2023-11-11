package DIV2.R907;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int times = sc.nextInt();
        while (times-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i=0; i<n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            int l = 0;
            int r = n - 1;
            long count = 0;
            long sum = 0;
            while (l <= r) {
                if (l == r) {
                    if (sum != 0) {
                        long mid = (sum + a[r]) / 2;
                        count += (sum == 0 ? 0 : 1) + mid + (a[r] + sum) % 2;
                    } else {
                        if (a[r] <= 3) {
                            count += a[r];
                            break;
                        }
                        long mid = a[r] / 2;
                        count += 1 + mid + (a[r] + sum) % 2;
                    }
                    r--;
                } else if (sum == a[r]) {
                  r--;
                  count+= sum + 1;
                  sum = 0;
                } else if (sum + a[l] > a[r]) {
                    a[l] -= a[r] - sum;
                    sum = a[r];
                } else {
                    sum += a[l];
                    l++;
                }
            }

            out.println(count);
        }
        out.close();
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

