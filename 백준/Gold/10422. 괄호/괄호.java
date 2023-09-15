import java.io.*;
import java.util.*;
public class Main {
    static long[] dp = new long[5001];
    public static void main(String[] args) throws Exception{
        dp[0] = 1;
        dp[2] = 1;
        for (int i = 2; i <= 2500; i++) {
            for (int j = 0; j < i; j++) {
                dp[2 * i] += dp[2 * j] * dp[2 * (i - j - 1)];
                dp[i*2] %= 1000000007L;
            }
        }

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
