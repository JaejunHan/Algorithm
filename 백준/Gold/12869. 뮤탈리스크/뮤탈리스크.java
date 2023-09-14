import java.io.*;
import java.util.*;

public class Main {

    static int[][] delta = {{-9, -3, -1}, {-9, -1, -3}, {-3, -9, -1}, {-3, -1, -9}, {-1, -9, -3}, {-1, -3, -9}};
    static int[][][] visited = new int[61][61][61];
    static int min;
    static int[] scv = new int[3];
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            scv[i] = sc.nextInt();
        }

        min = Integer.MAX_VALUE;
        dfs(0);

        System.out.println(min);

    }

    public static void dfs(int cnt) {
        int s1 = scv[0];
        int s2 = scv[1];
        int s3 = scv[2];

        if (cnt >= min) return;

        if (visited[s1][s2][s3] != 0 && visited[s1][s2][s3] <=cnt) return;
        visited[s1][s2][s3] = cnt;

        if (s1 == 0 && s2 == 0 && s3 == 0) {
            min = Math.min(min, cnt);
            return;
        }

        for (int i = 0; i < 6; i++) {
            scv = new int[] {Math.max(0, s1 + delta[i][0]), Math.max(0, s2 + delta[i][1]), Math.max(0, s3 + delta[i][2])};
            dfs(cnt+1);
            scv = new int[]{s1, s2, s3};
        }
    }
}
