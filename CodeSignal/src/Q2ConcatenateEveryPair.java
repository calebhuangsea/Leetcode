public class Q2ConcatenateEveryPair {
    long solution(int[] a) {
        // as the right part
        long lowsum = 0;
        for (int n : a) {
            lowsum += n;
        }
        // as the left part
        long sum  = lowsum * a.length;
        for (int n : a) {
            int len = (n + "").length();
            sum += lowsum * Math.pow(10, len);
        }
        return sum;
    }
}
