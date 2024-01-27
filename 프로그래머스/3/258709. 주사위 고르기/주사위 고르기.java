import java.util.*;

class Solution {
    static int n = 0;
    static int[][] dp1;
    static int[][] dp2;
    static boolean[] visited;
    static List<Integer> arr1 = new ArrayList<>();
    static List<Integer> arr2 = new ArrayList<>();
    static int[][] dice;
    static int[] ans;
    static double max = -1.0;
    
    public int[] solution(int[][] dice) {
        n = dice.length;
        this.dice = dice;
        ans = new int[n/2];
        
        visited = new boolean[n];
        comb(0, 0);
        
        return ans;
    }
    
    private void comb(int start, int depth) {
        if (depth == n / 2) {
            arr1 = new ArrayList<>();
            arr2 = new ArrayList<>();
            for (int i=0; i < n; i++) {
                if (visited[i]) {
                    arr1.add(i); // A의 주사위
                } else {
                    arr2.add(i); // B의 주사위
                }
            }
            
            dp1 = new int[n/2+1][501];
            dp2 = new int[n/2+1][501];
            
            makeDP(dp1, arr1);
            makeDP(dp2, arr2);
            
            double d = calculate();
        
            if (max < d) {
                max = d;
                for (int i=0; i < n/2; i++) {
                    ans[i] = arr1.get(i) + 1;
                }
            }
        }
        
        for (int i=start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(i, depth+1);
                visited[i] = false;
            }
        }
    }
    
    private double calculate() {
        int win = 0;
        int total = 0;
        for (int i=0; i < 500; i++) {
            for (int j=0; j < 500; j++) {
                if (i > j) {
                    win += dp1[n/2][i] * dp2[n/2][j];
                }
                total += dp1[n/2][i] * dp2[n/2][j];
            }
        }
        
        return ((double) win / total);
    }
    
    private void makeDP(int[][] dp, List<Integer> arr) {
        int[] firstDice = dice[arr.get(0)];
        for (int ele: firstDice) {
            dp[1][ele] += 1;
        }
        
        for (int i=2; i <= n/2; i++) {
            for (int j=0; j < 500; j++) {
                int[] nthDice = dice[arr.get(i-1)];
                for (int ele: nthDice) {
                    if (j - ele < 0) {
                        continue;
                    }
                    dp[i][j] += dp[i-1][j-ele];
                }   
            }
        }
    }
}