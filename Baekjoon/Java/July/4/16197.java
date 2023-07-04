import java.util.*;

class B16197 {
    static int n, m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[][] board;
    static Coin[] coin;
    static boolean[][][][] visited;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        board = new char[n][m];
        coin = new Coin[2];
        int coinIdx = 0;
        for (int i=0; i < n; i++) {
            String str = sc.next();
            for (int j=0; j < m; j++) {
                char c = str.charAt(j);
                if (c == 'o') {
                    coin[coinIdx++] = new Coin(i, j);
                }
                board[i][j] = c;
            }
        }

        visited = new boolean[n][m][n][m];
        System.out.println(bfs());

    }

    public static int bfs() {
        Queue<twoCoins> q = new LinkedList<>();
        q.add(new twoCoins(coin[0].x, coin[0].y, coin[1].x, coin[1].y, 0));
        visited[coin[0].x][coin[0].y][coin[1].x][coin[1].y] = true;

        while (!q.isEmpty()) {
            twoCoins current = q.poll();

            if (current.cnt >= 10) {
                break;
            }

            for (int i=0; i< 4; i++) {
                int nx1 = current.x1 + dx[i];
                int ny1 = current.y1 + dy[i];
                int nx2 = current.x2 + dx[i];
                int ny2 = current.y2 + dy[i];

                if (!canMove(nx1, ny1)) {
                    nx1 = current.x1;
                    ny1 = current.y1;
                }

                if (!canMove(nx2, ny2)) {
                    nx2 = current.x2;
                    ny2 = current.y2;
                }

                int flag = 0; // 떨어지지 않은 동전의 갯수
                if (nx1>=0 && nx1< n && ny1 >=0 && ny1 < m) flag++;
                if (nx2>=0 && nx2< n && ny2 >=0 && ny2 < m) flag++;

                if (flag ==1) return current.cnt + 1;
                else if (flag == 2 && !visited[nx1][ny1][nx2][ny2]) {
                    visited[nx1][ny1][nx2][ny2] = true;
                    q.add(new twoCoins(nx1, ny1, nx2, ny2, current.cnt+1));
                }
            }

        }

        return -1;
    }

    public static boolean canMove(int x, int y){
        if (x>=0 && x<n && y>=0 && y< m && board[x][y] == '#') {
            return false;
        } else {
            return true;
        }
    }

    public static class twoCoins {
        int x1;
        int y1;
        int x2;
        int y2;
        int cnt;

        public twoCoins(int x1, int y1, int x2, int y2, int cnt) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.cnt = cnt;
        }
    }

    public static class Coin {
        int x;
        int y;

        public Coin(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}