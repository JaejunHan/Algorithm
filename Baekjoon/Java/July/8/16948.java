import java.io.*;
import java.util.*;

class B16948 {
    static int n;
    static int r1, r2, c1, c2;
    static int[] dr = {-2, -2, 0, 0, 2, 2};
    static int[] dc = {-1, 1, -2, 2, -1, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        visited = new boolean[n][n];

        r1 = sc.nextInt();
        c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc. nextInt();

        Queue<Position> q = new LinkedList<>();
        q.add(new Position(r1, c1, 0));
        visited[r1][c1] = true;

        while (!q.isEmpty()) {
            Position f = q.poll();
            if (f.r == r2 && f.c == c2) {
                System.out.println(f.cnt);
                return;
            }

            for (int i=0; i<6; i++) {
                int nr = f.r + dr[i];
                int nc = f.c + dc[i];
                if (nr >=0 && nr < n && nc >=0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Position(nr, nc, f.cnt+1));
                }
            }
        }
        System.out.println(-1);
    }
    public static class Position {
        int r;
        int c;
        int cnt;
        public Position(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}
