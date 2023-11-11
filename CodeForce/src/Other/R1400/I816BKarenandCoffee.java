
package Other.R1400;

import java.io.*;
import java.util.StringTokenizer;

public class I816BKarenandCoffee {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        int k = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[200002];
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            arr[l]++;
            arr[r + 1]--;
        }
        for (int i = 1; i < 200002; i++) {
            arr[i] += arr[i - 1];
        }
        for (int i = 1; i < 200002; i++) {
            arr[i] = arr[i] >= k ? 1 : 0;
            arr[i] += arr[i - 1];
        }
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            out.println(arr[r] - arr[l - 1]);
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

