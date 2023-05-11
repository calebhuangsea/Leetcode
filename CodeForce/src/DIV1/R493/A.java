package DIV1.R493;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long x = sc.nextLong();
        long y = sc.nextLong();
        String s = sc.next();
        // calculate how many groups
        char a[]=s.toCharArray();

        long zero_groups=0;
        char last=a[0];
        for(int i=1;i<n;i++)
        {
            if(last=='0' && a[i]=='0')
            {
                if(i==n-1)
                    zero_groups++;
            }
            else if(last=='0' && a[i]=='1')
            {
                zero_groups++;
            }
            else if(last=='1' && a[i]=='1')
            {

            }
            else if(last=='1' && a[i]=='0')
            {
                if(i==n-1)
                    zero_groups++;
            }

            last=a[i];
        }

        long ans=(zero_groups-1)*Math.min(x,y)+y;
        if(zero_groups==0) ans=0;
        if(n==1 && a[0]=='0') ans=y;
        System.out.println(ans);
    }
}
