import java.io.*;
import java.util.*;

class Main {
    static String str1;
    static String str2;
    static int[][] dp;

    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        str2 = br.readLine();

        int len1 = str1.length(), len2 = str2.length();
        dp = new int[len1+1][len2+1];

        int max = 0;
        for (int i=1; i<= len1; i++) {
            for (int j=1; j <= len2; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        System.out.println(max);
    }
}
