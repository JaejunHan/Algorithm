import java.io.*;
import java.util.*;

class B2206 {
    static int n, m;
    static char[][] arr;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        visited = new boolean[n][m][2];

        for (int i=0; i< n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j=0; j< s.length(); j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        bfs();

    }

    public static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1, false));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Point f = q.poll();
            int x = f.x;
            int y = f.y;
            int cnt = f.cnt;
            boolean isBreak = f.isBreak;

            if (x == n-1 && y == m-1) {
                System.out.println(cnt);
                return;
            }

            for (int i=0; i< 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx>= 0 & nx < n && ny >=0 && ny < m) {  // 범위에 맞으면
                    if (isBreak) { // 벽 부수기를 사용한 경우
                        if (arr[nx][ny] != '1' && !visited[nx][ny][1]) {
                            visited[nx][ny][1] = true;
                            q.add(new Point(nx, ny, cnt+1, isBreak));
                        }
                    } else { // 벽 부수기를 사용하지 않은 경우
                        if (arr[nx][ny] == '1' && !visited[nx][ny][1]) { // 벽인 경우
                            visited[nx][ny][1] = true;
                            q.add(new Point(nx, ny, cnt+1, true));
                        } else if (arr[nx][ny] != '1' && !visited[nx][ny][0]) { // 벽이 아닌 경우
                            visited[nx][ny][0] = true;
                            q.add(new Point(nx, ny, cnt+1, isBreak));
                        }
                    }

                }
            }
        }
        System.out.println(-1);
    }

    public static class Point {
        int x;
        int y;
        int cnt;
        boolean isBreak;
        public Point(int x, int y, int cnt, boolean isBreak) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.isBreak = isBreak;
        }
    }
}