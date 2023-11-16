import java.io.*;
import java.util.*;

class Main {
    static int N;
    static long[] dp;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dp = new long[N+1];

        for (int i=1; i <= N; i++) {
            dp[i] = dp[i-1] + 1;

            if (i > 6) {
                for (int j=3; j<=5; j++) {
                    dp[i] = Math.max(dp[i], dp[i-j] * (j-1));
                }
            }
        }

        System.out.println(dp[N]);
    }
}
