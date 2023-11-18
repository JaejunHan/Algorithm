import java.io.*;
import java.util.*;

class Main {
    static char[] str1;
    static char[] str2;

    static int[][] dp;

    static StringBuilder sb = new StringBuilder();
    
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();

        dp = new int[str1.length+1][str2.length+1];

        
        for (int j=1; j <= str2.length; j++) {
            for (int i=1; i<= str1.length; i++) {
                if (str1[i-1] == str2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[str1.length][str2.length]);
        if (dp[str1.length][str2.length] != 0) {
            getLCSString();        
            System.out.println(sb.toString());
        }
    }

    public static void getLCSString() {
        int i = str1.length;
        int j = str2.length;
        Stack<Character> st = new Stack<>();
        while (i > 0 && j > 0) {
            if (i == 0 || j == 0 ) {
                break;
            }

            if (dp[i][j] == dp[i-1][j]) {
                i--;
            } else if (dp[i][j] == dp[i][j-1]) {
                j--;
            } else {
                st.push(str1[i-1]);
                i--;
                j--;
            }
        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
    } 
    
}
