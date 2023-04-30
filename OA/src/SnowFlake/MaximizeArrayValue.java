package SnowFlake;

/**
 * https://www.1point3acres.com/bbs/thread-972799-1-1.html
 */
public class MaximizeArrayValue {
    public static void main(String[] args) {
        int[] arr = new int[] {1,5,7,6};
        System.out.println(findMinMaxOfArray(arr));
    }
    public static int findMinMaxOfArray(int[] values){
        int curSum = values[0];
        int curMinMaxVal = values[0];
        for (int i = 1; i < values.length; i++) {
            curSum+=values[i];
            curMinMaxVal = Math.max(curMinMaxVal, (int)Math.ceil((double)curSum/(i+1)));
        }
        return curMinMaxVal;
    }
}
