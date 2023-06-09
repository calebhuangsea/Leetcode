package Weekly348;

public class Q3 {
    public static void main(String[] args) {
        int[][] m = new int[][] {
                {0,6,30094}, {0,7,99382}, {1,2,18599}, {1,3,49292 }, {1,0,81549}, {1,1,38280}, {0,0,19405}, {0,4,30065}, {1,4,60826},
                {1,5,9241}, {0,5,33729}, {0,1,41456}, {0,2,62692}, {0,3,30807}, {1,7,70613}, {1,6,9506}, {0,5,39344}, {1,0,44658}, {1,1,56485}, {1,2,48112}, {0,6,43384}
        };
        System.out.println(new Q3().matrixSumQueries(8, m));
    }

    public long matrixSumQueries(int n, int[][] queries) {
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[n];

        long sum = 0;
        int r = 0, c = 0;
        for (int i = queries.length - 1; i >= 0; i--) {
            int type = queries[i][0];
            int idx = queries[i][1];
            int val = queries[i][2];

            if (type == 0 && !row[idx]) {
                if (n == c)
                    continue;
                sum += (n - c) * val;
                row[idx] = true;
                r++;
            } else if (type == 1 && !col[idx]) {
                if (n == r)
                    continue;
                sum += (n - r) * val;
                col[idx] = true;
                c++;
            }
        }
        return sum;
    }
}
