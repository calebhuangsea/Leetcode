package Other.R1300;

import java.io.*;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class I60AWhereAreMyFlakes {
    static class FastScanner {
        // br.nextLine
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {}
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }

    /**
     * Time: O(N)
     * Space: O(1)
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int lo = 1, hi = n;
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String[] hint = sc.br.readLine().split(" ");
            int index = Integer.parseInt(hint[hint.length - 1]);
            if (hint[2].equals("left")) {
                hi = Math.min(hi, index - 1);
            } else {
                lo = Math.max(lo, index + 1);
            }
            if (lo > hi) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(hi - lo + 1);
    }
}

