import java.io.*;
import java.util.*;

class B14502 {
    static int n, m;
    static int[][] mp;
    static int MAX = Integer.MIN_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n =  sc.nextInt();
        m = sc.nextInt();
        mp = new int[n][m];
        visited = new boolean[n][m];
        for (int i=0; i< n; i++) {
            for (int j=0; j< m; j++) {
                mp[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i<n; i++) {
            for (int j =0; j< m; j++) {
                if (mp[i][j] == 0) {
                    mp[i][j] = 1;
                    dfs(1);
                    mp[i][j] = 0;
                }
            }
        }

        System.out.println(MAX);

    }

    public static void dfs(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }

        for (int i=0; i<n; i++) {
            for (int j =0; j< m; j++) {
                if (mp[i][j] == 0) {
                    mp[i][j] = 1;
                    dfs(depth+1);
                    mp[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        // visited 초기화
        for (int i=0; i< n; i++) {        
            Arrays.fill(visited[i], false);
        }

        int[][] cp = new int[n][m];
        for (int i = 0; i < n; i++) {
            cp[i] = mp[i].clone();
        }
        

        Queue<Point> q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            for (int j =0; j< m; j++) {
                if (cp[i][j] == 2) {
                    q.add(new Point(i, j));
                }
            }
        }
        

        while (!q.isEmpty()) {
            Point f = q.poll();
            int x = f.x;
            int y = f.y;
            for (int i=0; i< 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >=0 && nx < n && ny >=0 && ny < m && !visited[nx][ny] && cp[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    cp[nx][ny] = 2;
                    q.add(new Point(nx, ny));
                }
            }
        }

        int cnt = 0;
        for (int i=0; i< n; i++) {
            for (int j=0; j< m; j++) {
                if (cp[i][j] == 0) {
                    cnt++;
                }
            }
        }

        MAX = Math.max(MAX, cnt);
    }

    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}