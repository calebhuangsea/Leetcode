package DIV2.R912;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int times = sc.nextInt();
        while (times-- > 0) {
            int n = sc.nextInt();;
            long[] arr = new long[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
                sum += arr[i];
            }

            Deque<Long> dq = new ArrayDeque<>();
            dq.offer(arr[0]);
            long pre = arr[0];
            for (int i = 1; i <n; i++) {
                long curr = arr[i];
                pre += arr[i];
                while (!dq.isEmpty() && curr < 0 &&
                        ( (dq.peekLast() + curr) * dq.size() ) - (dq.peekLast() * dq.size() + curr * (dq.size() + 1))  > (sum - pre)) {
                    curr = dq.pollLast() + curr;
                }
                dq.offerLast(curr);
            }
            long res = 0;
            int size = dq.size();
            for (int i = 1; i <= size; i++) {
                res += i * dq.pollFirst();
            }
            System.out.println(res);

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

