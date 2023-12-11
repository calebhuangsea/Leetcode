package HJ;

import java.util.Scanner;

public class HJ16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int money = in.nextInt()/10;//钱数是10的倍数，除以10，降低时间和空间复杂度
            int num = in.nextInt();
            //读取输入，区分主件，附件
            int[][] price = new int[num + 1][3];//记录主件和附件的价格
            int[][] pPlusImportant = new int[num + 1][3];//记录主件和附件的价格 * 重要度
            for(int i=1;i<=num;i++){
                int v = in.nextInt()/10;
                int p = in.nextInt();
                int q = in.nextInt();
                int im = v * p;
                if(q==0){
                    price[i][0] = v;//第一列是主件价格，第二列是附件1的价格，第三列附件2的价格
                    pPlusImportant[i][0] = im;
                }else{
                    if(price[q][1]==0){
                        price[q][1] = v;//主件q的附件1的价格
                        pPlusImportant[q][1] = im;
                    }else{
                        price[q][2] = v;//主件q的附件2的价格
                        pPlusImportant[q][2] = im;
                    }
                }
            }
            int[] dp = new int[money + 1];//背包问题，带附加条件
            for(int i=1;i<=num;i++){
                if(price[i][0] == 0){
                    continue;//主件为空，则跳过
                }
                for(int j=money;j>=price[i][0];j--){
                    int a = price[i][0];//主件
                    int a1 = pPlusImportant[i][0];
                    int b = price[i][1];//附件1
                    int b1 = pPlusImportant[i][1];
                    int c = price[i][2];//附件2
                    int c1 = pPlusImportant[i][2];
                    if(j>=a){
                        dp[j] = Math.max(dp[j],dp[j-a] + a1);
                    }
                    if(j>=a+b){
                        dp[j] = Math.max(dp[j],dp[j-a-b] + a1 + b1);
                    }
                    if(j>=a+c){
                        dp[j] = Math.max(dp[j],dp[j-a-c] + a1 + c1);
                    }
                    if(j>=a+b+c){
                        dp[j] = Math.max(dp[j],dp[j-a-b-c] + a1 + b1 + c1);
                    }
                }
            }
            System.out.println(dp[money] * 10);//开始的时候总钱数除10，输出的时候*10
        }
    }
}
