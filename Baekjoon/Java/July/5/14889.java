import java.io.*;
import java.util.*;

class B14889 {
    static int n;
    static int[][] arr;
    static Set<Integer> team1 = new HashSet<>();
    static Set<Integer> team2 = new HashSet<>();    
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];

        for (int i=0; i< n; i++) {
            for (int j=0; j< n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        team1.add(0);
        dfs(1, 1);
        System.out.println(MIN);
    }

    public static void dfs(int depth, int num) {
        if (depth == n/2) {
            for (int i=0; i< n; i++) {
                if (!team1.contains(i)) {
                    team2.add(i);
                }
            }
            getDiff();
            team2.clear();
            return;
        }

        for (int i=num; i < n; i++) {
            team1.add(i);
            dfs(depth+1, i+1);
            team1.remove(i);
        }

    }
    
    public static void getDiff() {
        int sum1 = 0, sum2 = 0;
        for (Integer ele1: team1) {
            for (Integer ele2: team1) {
                if (ele1 != ele2) {
                    sum1 += arr[ele1][ele2];
                }
            }
        }

        for (Integer ele1: team2) {
            for (Integer ele2: team2) {
                if (ele1 != ele2) {
                    sum2 += arr[ele1][ele2];
                }
            }
        }

        MIN = Math.min(MIN, Math.abs(sum1 - sum2));
    }
}