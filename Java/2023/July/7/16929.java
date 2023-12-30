import java.io.*;
import java.util.*;

class B16929 {
    static int n, m;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int x, y;
    static char c;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        visited = new boolean[n][m];

        for (int i=0; i < n; i++) {
            String s = br.readLine();
            for (int j=0; j< m; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j < m; j++) {
                x = i; y = j;
                c = arr[i][j];
                visited[i][j] = true;
                if (dfs(i, j, 1)) {
                    System.out.println("Yes");
                    return;
                }
                visited[i][j] = false;
            }
        }

        System.out.println("No");
    }

    public static boolean dfs(int i, int j, int cnt) {

        for (int k=0; k< 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx >=0 && nx < n && ny >=0 && ny < m && arr[nx][ny] == c) {
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (dfs(nx, ny, cnt+1)) {
                        return true;
                    }
                    visited[nx][ny] = false;
                } else {
                    if (nx == x && ny == y && cnt >= 4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
