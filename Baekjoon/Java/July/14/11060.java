import java.io.*;
import java.util.*;

class B11060 {
    static int n;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        dp[0] = 0;
        for (int i=0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (int e = 1; e <= arr[i]; e++) {
                if (e+i>= n) break;
                dp[e+i] = Math.min(dp[i+e], dp[i] + 1);
            }
        }

        if (dp[n-1] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n-1]);
        }
    }
}