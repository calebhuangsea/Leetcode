package Weekly338;

public class Q6354 {
    public static void main(String[] args) {
        System.out.println(kItemsWithMaximumSum(6, 6, 6, 13));
        System.out.println(kItemsWithMaximumSum(3, 2, 0, 4));
    }
    public static int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int sum = 0;
        while (k > 0) {
            if (numOnes > 0) {
                numOnes--;
                sum++;
            } else if (numZeros > 0) {
                numZeros--;
            } else {
                sum--;
            }
            k--;
        }
        return sum;
    }
}
