package Other.R1500;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class I384BMultitasking {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        List<int[]> list = new ArrayList<>();
        if (k == 0) {
            // ascending
            for (int i = 0; i < n; i++) {
                // we sort every row first
                for (int j = 0; j < m; j++) {
                    int min = arr[i][j];
                    int index = 0;
                    for (int x = j + 1; x < m; x++) {
                        if (arr[i][x] < min) {
                            min = arr[i][x];
                            index = x;
                        }
                        min = Math.min(min, arr[i][x]);
                    }
                    if (min != arr[i][j]) {
                        list.add(new int[] {j + 1, index + 1});
                        for (int x = 0; x < n; x++) {
                            if (arr[x][j] > arr[x][index]) {
                                int t = arr[x][j];
                                arr[x][j] = arr[x][index];
                                arr[x][index] = t;
                            }
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                // we sort every row first
                for (int j = 0; j < m; j++) {
                    int max = arr[i][j];
                    int index = 0;
                    for (int x = j + 1; x < m; x++) {
                        if (arr[i][x] > max) {
                            max = arr[i][x];
                            index = x;
                        }
                        max = Math.max(max, arr[i][x]);
                    }
                    if (max != arr[i][j]) {
                        if (index == 0 && j == 0) {
                            System.out.println(123);
                        }
                        list.add(new int[] {index + 1, j + 1});
                        for (int x = 0; x < n; x++) {
                            if (arr[x][j] < arr[x][index]) {
                                int t = arr[x][j];
                                arr[x][j] = arr[x][index];
                                arr[x][index] = t;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(list.size());
        for (int[] l : list) {
            System.out.println(l[0] + " " + l[1]);
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

