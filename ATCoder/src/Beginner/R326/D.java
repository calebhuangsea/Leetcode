package Beginner.R326;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

@SuppressWarnings("unchecked")
public class D {
    private static char[][] res = null;
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        char[] r = sc.next().toCharArray();
        char[] c = sc.next().toCharArray();
        char[][] a = new char[n][n];
        for (char[] arr : a) {
            Arrays.fill(arr, '.');
        }
        Set<Character>[] row = new Set[n];
        Set<Character>[] col = new Set[n];
        for (int i = 0; i < n; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
        }
        Boolean[][] cond = new Boolean[2][n];
        for (Boolean[] cc : cond) {
            Arrays.fill(cc, false);
        }
        dfs(a, r, c, 0, 0, cond, row, col);
        if (res == null) {
            out.println("No");
        } else {
            out.println("Yes");
            for (char[] chars : res) {
                for (char cc : chars) {
                    out.print(cc + "");
                }
                out.println();
            }
        }
        out.close();
    }
    // dfs to run every solution and check
    private static void dfs(char[][] a, char[] r, char[] c, int i, int j, Boolean[][] cond, Set<Character>[] row, Set<Character>[] col) {
        if (i == a.length) {
            for (int n = 0; n < a.length; n++) {
                if (row[n].size() != 3 || col[n].size() != 3) return;
            }
            res = new char[a.length][a[0].length];
            for (int x = 0; x < res.length; x++) {
                for (int y = 0; y < res[0].length; y++) {
                    res[x][y] = a[x][y];
                }
            }
            return;
        }
        // write or skip
        if (!row[i].contains('A') && !col[j].contains('A')) {
            // 0 : row i
            // 1 : col i
            if ((cond[0][i] || r[i] == 'A') && (cond[1][j] || c[j] == 'A')) {
                boolean frow = cond[0][i];
                boolean fcol = cond[1][j];
                cond[0][i] = true;
                cond[1][j] = true;
                a[i][j] = 'A';
                row[i].add('A');
                col[j].add('A');
                dfs(a, r, c, j == a[0].length - 1 ? i + 1 : i, j == a[0].length - 1 ? 0 : j + 1, cond, row, col);
                cond[0][i] = frow;
                cond[1][j] = fcol;
                a[i][j] = '.';
                row[i].remove('A');
                col[j].remove('A');
            }
        }
        if (!row[i].contains('B') && !col[j].contains('B')) {
            // 0 : row i
            // 1 : col i
            if ((cond[0][i] || r[i] == 'B') && (cond[1][j] || c[j] == 'B')) {
                boolean frow = cond[0][i];
                boolean fcol = cond[1][j];
                cond[0][i] = true;
                cond[1][j] = true;
                a[i][j] = 'B';
                row[i].add('B');
                col[j].add('B');
                dfs(a, r, c, j == a[0].length - 1 ? i + 1 : i, j == a[0].length - 1 ? 0 : j + 1, cond, row, col);
                cond[0][i] = frow;
                cond[1][j] = fcol;
                a[i][j] = '.';
                row[i].remove('B');
                col[j].remove('B');
            }
        }
        if (!row[i].contains('C') && !col[j].contains('C')) {
            // 0 : row i
            // 1 : col i
            if ((cond[0][i] || r[i] == 'C') && (cond[1][j] || c[j] == 'C')) {
                boolean frow = cond[0][i];
                boolean fcol = cond[1][j];
                cond[0][i] = true;
                cond[1][j] = true;
                a[i][j] = 'C';
                row[i].add('C');
                col[j].add('C');
                dfs(a, r, c, j == a[0].length - 1 ? i + 1 : i, j == a[0].length - 1 ? 0 : j + 1, cond, row, col);
                cond[0][i] = frow;
                cond[1][j] = fcol;
                a[i][j] = '.';
                row[i].remove('C');
                col[j].remove('C');
            }
        }
        // if we add nothing and move on
        dfs(a, r, c, j == a[0].length - 1 ? i + 1 : i, j == a[0].length - 1 ? 0 : j + 1, cond, row, col);
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

