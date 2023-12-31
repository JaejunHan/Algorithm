import java.util.*;
class Solution {
    static int[][] dp;
    static int maxA = 0, maxC = 0;
    
    public int solution(int alp, int cop, int[][] problems) {
        
        for (int[] p: problems) {
            maxA = Math.max(maxA, p[0]);
            maxC = Math.max(maxC, p[1]);
        }
        
        init();
        alp = Math.min(alp, maxA);
        cop = Math.min(cop, maxC);
        
        dp[alp][cop] = 0;
        
        for (int i=alp; i <= maxA; i++) {
            for (int j=cop; j <= maxC; j++) {
                
                if (i + 1 <= maxA)
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 1);
                if (j+1 <= maxC)
                    dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] + 1);
                
                for (int[] p: problems) {
                    if (p[0] <= i && p[1] <= j) {
                        int r1 = p[2];
                        int r2 = p[3];
                        int t = p[4];
                        int nxt1 = Math.min(maxA, i+r1);
                        int nxt2 = Math.min(maxC, j+r2);
                        
                        dp[nxt1][nxt2] = Math.min(dp[nxt1][nxt2], dp[i][j] + t);
                    }
                }
            }
        }
        // debug();
        return dp[maxA][maxC];
    }
    
    private void debug() {
        
        for (int i=10; i<= maxA; i++) {
            for (int j=10; j <= maxC; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    private void init() {
        dp = new int[151][151];
        
        for (int i=0; i<= 150; i++) {
            for (int j=0; j <= 150; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
    }
}