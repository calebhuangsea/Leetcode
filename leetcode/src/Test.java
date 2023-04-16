public class Test {
    public static void main(String[] args) {
//        System.out.println(solution(new int[]{9, 8, 7, 6, 5}));
        System.out.println(solution(new int[]{-1000000000, 1000000000}));
    }
    static long solution(int[] arr) {
        long sum = 0;
        int i = 1;
        int status = 0;
        int count = 0;
        while (i < arr.length) {
            int state = arr[i] - arr[i - 1];
            if (status == 0 && state > 0) {
                status = 1;
                count++;
            } else if (status == 0 && state < 0) {
                status = -1;
                count++;
            } else if (status == 1 && state < 0) {
                status = -1;
                count++;
            } else if (status == -1 && state > 0) {
                count++;
                status = 1;
            } else {
                for (int n = 1; n <= count; n++) {
                    sum += n;
                }
                if (status != 0 ){
                    i --;
                }
                status = 0;
                count = 0;
            }
            i++;
        }
        for (int n = 1; n <= count; n++) {
            sum += n;
        }
        return sum;
    }

}
