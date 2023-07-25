import java.io.*;
import java.util.*;

class B11048 {
    static int n, m;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        dp = new int[n+1][m+1];
        
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                dp[i][j] = sc.nextInt();
            }
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                dp[i][j] = dp[i][j] + Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        System.out.println(dp[n][m]);
    }
}