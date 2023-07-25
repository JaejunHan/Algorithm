import java.io.*;
import java.util.*;

class B15989 {
    static int[][] dp = new int[10001][4];
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        calDp();

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            int tmp = sc.nextInt();
            sb.append(dp[tmp][1] + dp[tmp][2] + dp[tmp][3] + "\n");
        }
        System.out.println(sb);
    }

    public static void calDp() {
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i=4; i<=10000; i++) {
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }
    }
}