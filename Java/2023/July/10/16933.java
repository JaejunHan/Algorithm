import java.io.*;
import java.util.*;

class B16933 {
    static int n, m, k;
    static char[][] arr;
    static int[] dx = {-1, 0, 1, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0};
    static boolean[][][][] visited;
    static int MIN = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visited = new boolean[n][m][k+1][2];

        for (int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j=0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        bfs();

        System.out.println(MIN);
    }

    public static void bfs() {
        
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(0, 0, 0, 0, 1));
        visited[0][0][0][0] = true; // 낮: 0, 밤 1

        while (!q.isEmpty()) {
            Point f = q.poll();
            int x = f.x;
            int y = f.y;

            if (x == n-1 && y == m-1) {
                MIN = f.cnt;
                return;
            }

            for (int i=0; i< 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(0 > nx || nx >= n || 0 > ny || ny >= m) continue;

                if (arr[nx][ny] == '1') {   // 벽인 경우
                    if (f.breakCnt < k) {
                        if (f.noon == 0) { // 낮이고 벽을 더 부술 수 있을 경우
                            if (!visited[nx][ny][f.breakCnt+1][1]) {
                                visited[nx][ny][f.breakCnt+1][1] = true;
                                q.add(new Point(nx, ny, f.breakCnt+1, 1, f.cnt+1));    
                            }
                        } else { // 밤인 경우
                            if (!visited[x][y][f.breakCnt][0]) {
                                visited[x][y][f.breakCnt][0] = true;
                                q.add(new Point(x, y, f.breakCnt, 0, f.cnt+1));    
                            }
                        }
                    }
                } else { // 벽이 아닌 경우
                    if (f.noon == 0) {
                        if (!visited[nx][ny][f.breakCnt][1]) {
                            visited[nx][ny][f.breakCnt][1] = true;
                            q.add(new Point(nx, ny, f.breakCnt, 1, f.cnt+1));
                        }
                    } else {
                        if (!visited[nx][ny][f.breakCnt][0]) {
                            visited[nx][ny][f.breakCnt][0] = true;
                            q.add(new Point(nx, ny, f.breakCnt, 0, f.cnt+1));
                        }
                    }
                }
                
            }
        }
    }

    public static class Point {
        int x; int y; int breakCnt; int noon;int cnt;
        public Point(int x, int y, int breakCnt, int noon, int cnt) {
            this.x = x; this.y = y; this.breakCnt = breakCnt; this.noon = noon; this.cnt = cnt;
        }
    }
}