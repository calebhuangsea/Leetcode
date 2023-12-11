package DIV2.R912;

import java.io.*;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int times = sc.nextInt();
        while (times-- > 0) {
            int n = sc.nextInt();
            int[] res = new int[n];
            boolean flag = true;
            int[] temp = new int[n];
            for (int i = 0; i < n; i++) {
                int pre = -1;
                for (int j = 0; j < n; j++) {
                    temp[j] = sc.nextInt();
                    if (i != j) {
                        if (pre == -1) pre = temp[j];
                        else pre &= temp[j];
                    }

                }
                res[i] = pre;
                for (int j = 0; j < i; j++) {
                    if ((res[i] | res[j]) != temp[j]) {
                        flag = false;
                    }
                }
            }
            if (n == 1) {
                System.out.println("YES");
                System.out.println(temp[0]);
            } else if (flag) {
                System.out.println("YES");
                for (int num : res) {
                    System.out.print(num + " ");
                }
                System.out.println();
            } else {
                System.out.println("NO");
            }

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

