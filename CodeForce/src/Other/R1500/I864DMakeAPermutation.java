package Other.R1500;

import java.io.*;
import java.util.*;

public class I864DMakeAPermutation {
    /**
     * Time: O(nlogn) we use treeset to sort and find the smallest number
     * Space: O(N)
     * @param args
     */
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader sc = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        int[] count = new int[n + 1];
        Set<Integer> set = new TreeSet<>();
        Set<Integer> output = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            count[arr[i]]++;
            set.remove(arr[i]);
        }
        Iterator<Integer> iterator = set.iterator();
        int last = -1;
        System.out.println(set.size());
        for (int i = 1; i <= n; i++) {
            if (last == -1 && iterator.hasNext()) {
                last = iterator.next();
            }
            if (count[arr[i]] == 1) {
                if (output.contains(arr[i])) {
                    // we have output this before
                    System.out.print(last +  " ");
                    last = -1;
                } else {
                    System.out.print(arr[i] + " ");
                }
            } else if (count[arr[i]] > 1) {
                if (output.contains(arr[i]) || last < arr[i]) {
                    System.out.print(last + " ");
                    last = -1;
                } else {
                    System.out.print(arr[i] + " ");
                    output.add(arr[i]);
                }
                count[arr[i]]--;
            }
        }
        System.out.println();
        out.close();
    }

    public static boolean check(long mid, int[] a, int[] b) {
        long sum = 0l;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > mid) {
                sum += b[i];
            }
        }
        return sum <= mid;
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void close() {
            writer.close();
        }

        public OutputWriter println(long i) {
            writer.println(i);
            return this;
        }
        public OutputWriter println(double i) {
            writer.println(i);
            return this;
        }
        public OutputWriter println(String i) {
            writer.println(i);
            return this;
        }
        public OutputWriter println() {
            writer.println();
            return this;
        }
        public OutputWriter print(String i) {
            writer.print(i);
            return this;
        }
        public OutputWriter print(long i) {
            writer.print(i);
            return this;
        }
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public double[] nextDoubleArray(int size) {
            double[] array = new double[size];
            for (int i = 0; i < size; i++) {
                array[i] = readDouble();
            }
            return array;
        }

        private int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            return Integer.parseInt(this.next(), 10);
        }

        public long nextLong() {
            return Long.parseLong(this.next(), 10);
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        private static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public double readDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, nextInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

