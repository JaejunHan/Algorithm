import java.io.*;
import java.util.*;

class B5557 {
    static int N;
    static int[] arr;
    static long[][] dp;

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        dp = new long[N][21];
        
        for (int i=0; i< N; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0][arr[0]] = 1;

        int plus;
        int minus;
        for (int i=1; i < N-1; i++) {
            for (int j=0; j<= 20; j++) {
                if (dp[i-1][j] != 0) {
                    plus = j + arr[i];
                    minus = j - arr[i];
                    
                    if (plus >=0 && plus <= 20) {
                        dp[i][plus] += dp[i-1][j];
                    }
                    if (minus >=0 && minus <= 20) {
                        dp[i][minus] += dp[i-1][j];
                    }
                }
            }
        }
        

        System.out.println(dp[N-2][arr[N-1]]);
    }
}
