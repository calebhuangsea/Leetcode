package Other.R1500;

import java.io.*;
import java.util.*;

public class I229AShifts {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine().toCharArray();
        }
        int[][] dis = new int[n][m];
        for (int[] a : dis) {
            Arrays.fill(a, Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < n; i++) {
            // iterate every row
            Queue<Integer> q = new LinkedList<>();
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == '1') q.add(j);
            }
            while (!q.isEmpty()) {
                int x = q.poll();
                dis[i][x] = 0;
                for (int k = 1; k < m; k++) {
                    if (arr[i][(k + x) % m] == '1') {
                        break;
                    }
                    dis[i][(k + x) % m] = Math.min(dis[i][(k + x) % m], dis[i][(k + x + m - 1) % m] + 1);
                }
                for (int k = 1; k < m; k++) {
                    if (arr[i][(x + m - k) % m] == '1') {
                        break;
                    }
                    dis[i][(m - k + x) % m] = Math.min(dis[i][(m - k + x) % m], dis[i][(m - k + x + 1) % m] + 1);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n && sum < res; j++) {
                if (dis[j][i] == Integer.MAX_VALUE / 2) {
                    out.println(-1);
                    out.close();
                    return;
                }
                sum += dis[j][i];
            }
            res = Math.min(res, sum);
        }
        out.println(res);
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

