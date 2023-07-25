import java.io.*;
import java.util.*;

class B14442 {
    static int n, m, k;
    static char[][] arr;
    static boolean[][][] visited;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        visited = new boolean[n][m][k+1];

        for (int i=0; i< n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        bfs();

        if (min != Integer.MAX_VALUE) {
            System.out.println(min);
        } else {
            System.out.println(-1);
        }
    }

    public static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0, 1));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Point f = q.poll();
            int x = f.x;
            int y = f.y;
            int breakCnt = f.breakCnt;
            int cnt = f.cnt;

            if (x == n-1 && y == m-1) {
                min = Math.min(min, cnt);
                return;
            }

            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >=0 && nx < n && ny >=0 && ny < m) {
                    if (arr[nx][ny] == '1') { // 벽인 경우
                        if (breakCnt < k && !visited[nx][ny][breakCnt+1]) { // 벽을 깰 수 있는 경우가 남아있으면
                            visited[nx][ny][breakCnt+1] = true;
                            q.add(new Point(nx, ny, breakCnt+1, cnt+1));
                        }
                    } else {    // 벽이 아닌 경우
                        if (!visited[nx][ny][breakCnt]) {
                            visited[nx][ny][breakCnt] = true;
                            q.add(new Point(nx, ny, breakCnt, cnt+1));
                        }
                    }
                }
            }

        }
    }

    public static class Point {
        int x;
        int y;
        int breakCnt;
        int cnt;
        public Point(int x, int y, int breakCnt, int cnt) {
            this.x = x;
            this.y = y;
            this.breakCnt = breakCnt;
            this.cnt = cnt;
        }
    }

}