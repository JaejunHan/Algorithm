import java.io.*;
import java.util.*;

class B2293 {
    static int n, k;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n+1];
        dp = new int[k+1];
        dp[0] = 1;
        for (int i=0; i< n; i++) {
            arr[i] = sc.nextInt();
            for (int j=arr[i]; j <= k; j++) {
                dp[j] += dp[j-arr[i]];
            }
        }

        System.out.println(dp[k]);
    }
}