import java.io.*;
import java.util.*;

class B13460 {
    static int n, m;
    static char[][] arr;
    static int x1, x2, y1, y2, gx, gy;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][][][] visited;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new char[n][m];
        visited = new boolean[n][m][n][m];

        for (int i=0; i < n; i++) {
            String s = sc.next();
            for (int j=0; j < m; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'O') {
                    gx = i; gy = j;
                } else if (arr[i][j] == 'B') {
                    x1 = i; y1 = j;
                } else if (arr[i][j] == 'R') {
                    x2 = i; y2 = j;
                }
            }
        }

        Queue<Ball> q = new LinkedList<>();
        q.add(new Ball(x1, y1, x2, y2, 0));
        visited[x1][y1][x2][y2] = true;

        while (!q.isEmpty()) {
            Ball b = q.poll();

            if (b.cnt >= 10) {
                System.out.println(-1);
                return;
            }

            boolean isBreak = false;
            for (int i=0; i< 4; i++) {
                int nx1 = b.x1;
                int ny1 = b.y1;
                int nx2 = b.x2;
                int ny2 = b.y2;
                arr[b.x1][b.y1] = 'B';
                arr[b.x2][b.y2] = 'R';

                while (true) {
                    if (arr[nx1][ny1] == '#') {        
                        nx1 -= dx[i]; ny1 -= dy[i];
                        nx2 -= dx[i]; ny2 -= dy[i];
                        while (arr[nx2][ny2] != '#' && !(nx1 == nx2 && ny1 == ny2)) {
                            nx2 += dx[i]; ny2 += dy[i];
                            if ((nx2 == gx) && (ny2 == gy)) {
                                System.out.println(b.cnt+1);
                                return;
                            }
                        }
                        nx2 -= dx[i]; ny2 -= dy[i];
                        break;
                    }

                    if (arr[nx2][ny2] == '#') {
                        nx1 -= dx[i]; ny1 -= dy[i];
                        nx2 -= dx[i]; ny2 -= dy[i];
                        while (arr[nx1][ny1] != '#' && !(nx1 == nx2 && ny1 == ny2)) {
                            nx1 += dx[i]; ny1 += dy[i];
                            if ((nx1 == gx) && (ny1 == gy)) {
                                isBreak = true;
                                break;
                            }
                        }
                        if (isBreak) {
                            break;
                        }
                        nx1 -= dx[i]; ny1 -= dy[i];
                        break;
                    }

                    nx1 += dx[i]; ny1 += dy[i];
                    nx2 += dx[i]; ny2 += dy[i];
                    if ((nx1 == gx) && (ny1 == gy)) {
                        isBreak = true;
                        break;
                    }

                    if ((nx2 == gx) && (ny2 == gy)) {
                        while (arr[nx1][ny1] != '#') {
                            nx1 += dx[i]; ny1 += dy[i];
                            if ((nx1 == gx) && (ny1 == gy)) {
                                isBreak = true;
                                break;
                            }
                        }
                        if (isBreak) {
                            break;
                        }
                        nx1 -= dx[i]; ny1 -= dy[i];
                        System.out.println(b.cnt+1);
                        return;
                    }
                }

                if (isBreak) {
                    isBreak = false;
                    continue;
                }

                if (!visited[nx1][ny1][nx2][ny2]) {
                    visited[nx1][ny1][nx2][ny2] = true;
                    q.add(new Ball(nx1, ny1, nx2, ny2, b.cnt+1));
                }

            }
        }

        System.out.println(-1);
    }

    public static class Ball {
        int x1;
        int y1;
        int x2;
        int y2;
        int cnt;

        public Ball(int x1, int y1, int x2, int y2, int cnt) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.cnt = cnt;
        }
    }


}
