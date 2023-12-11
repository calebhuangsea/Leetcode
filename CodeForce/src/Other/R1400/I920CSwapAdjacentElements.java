package Other.R1400;

import java.io.*;
import java.util.StringTokenizer;

public class I920CSwapAdjacentElements {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        char[] s = sc.nextLine().toCharArray();
        // 01010
        // from first apperance of i to first 0
        Integer min = null;
        Integer max = null;
        int last = -1;
        if (s[0] == '1') {
            min = arr[0];
            max = arr[0];
        } else {
            last = arr[0];
        }
        boolean flag = true;
        for (int i = 1; i < n - 1; i++) {
            if (s[i] == '0') {
                // check
                if (min != null) {
                    min = Math.min(arr[i], min);
                    max = Math.max(arr[i], max);
                    if (min < last) {
                        flag = false;
                        break;
                    }
                    last = max;
                } else {
                    if (arr[i] < last) {
                        flag = false;
                        break;
                    }
                    last = arr[i];
                }
                min = null;
                max = null;
            } else {
                if (min == null) {
                    min = arr[i];
                    max = arr[i];
                }
                min = Math.min(arr[i], min);
                max = Math.max(arr[i], max);
            }
        }
        if (min != null) {
            min = Math.min(arr[n - 1], min);
            if (min < last) {
                flag = false;
            }
        } else if (arr[n - 1] < last)flag = false;
        if (!flag) out.println("NO");
        else out.println("YES");
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

