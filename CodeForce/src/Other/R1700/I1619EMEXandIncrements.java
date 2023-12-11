package Other.R1700;

import java.io.*;
import java.util.*;

public class I1619EMEXandIncrements {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int times = sc.nextInt();
        while (times-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] count = new int[n + 1];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                count[arr[i]]++;
            }
            Arrays.sort(arr);
            long pre = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i <= n; i++) {

                if (count[i] > 0) {
                    for (int j = 0; j < count[i] - 1; j++) stack.add(i);
                    out.print(pre + count[i] + " ");
                }
                if (count[i] == 0) {
                    // we are missing this, see if we can make it
                    out.print(pre + " ");
                    if (stack.isEmpty()) {
                        for (int j = i + 1; j <= n; j++) out.print(-1 + " ");
                        break;
                    }
                    pre += i - stack.pop();
                }
            }
            out.println();
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

