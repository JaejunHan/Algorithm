import java.io.*;
import java.util.*;

class Main {
    static int n, k;
    static int[] arr;
    static int[] dp;
    static int max = Integer.MAX_VALUE-1;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        arr = new int[n+1];
        dp = new int[k+1];

        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i=0; i< n; i++) {
            arr[i] = sc.nextInt();

            for (int j = arr[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j-arr[i]] + 1, dp[j]);
            }
        }
        if (dp[k] == max) {
            System.out.println(-1);
        } else {        
            System.out.println(dp[k]);   
        }
    }
    
}
