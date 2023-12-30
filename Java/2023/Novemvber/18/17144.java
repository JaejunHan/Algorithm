import java.io.*;
import java.util.*;

class B17144 {
    static int r, c, t;
    static int[][] arr;
    static int x1, y1, x2, y2;
    static Queue<Node> q = new ArrayDeque<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        input();

        while (t>0) {
            t--;    
            bfs();
            cycle();
            dustQueue();
        }
        System.out.println(cntDust());
    }

    public static void print() {
        for (int i=0; i< r; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static int cntDust() {
        int cnt = 0;
        for (Node n: q) {
            cnt += n.dust;
        }
        return cnt;
    }

    public static void dustQueue() {
        q = new ArrayDeque<>();
        for (int i=0; i< r; i++) {
            for (int j=0; j< c; j++) {
                if (arr[i][j] != 0 && arr[i][j] != -1) {
                    q.add(new Node(i, j, arr[i][j]));
                }
            }
        }
    }

    public static void cycle() {
        // 첫 번째
        for (int i=x1-1; i > 0 ; i--) {
            arr[i][0] = arr[i-1][0];
        }

        for (int j=0; j < c-1; j++) {
            arr[0][j] = arr[0][j+1];
        }

        for (int i=0; i < x1; i++) {
            arr[i][c-1] = arr[i+1][c-1];
        }

        for (int j=c-1; j > 0; j--) {
            arr[x1][j] = arr[x1][j-1];
        }
        arr[x1][1] = 0;

        // 두 번째
        for (int i=x2+1; i < r-1; i++) {
            arr[i][0] = arr[i+1][0];
        }

        for (int j=0; j < c-1; j++) {
            arr[r-1][j] = arr[r-1][j+1];
        }

        for (int i=r-1; i > x2 ; i--) {
            arr[i][c-1] = arr[i-1][c-1];
        }

        for (int j=c-1; j > 1; j--) {
            arr[x2][j] = arr[x2][j-1];
        }
        arr[x2][1] = 0;

    }
    
    public static void bfs() {
        Queue<Node> tmp = new ArrayDeque<>();
        while (!q.isEmpty()) {
            Node f = q.poll();
            int x = f.x; int y = f.y; int dust = f.dust;
            int cnt = 0;

            for (int i=0; i< 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    continue;
                }
                if ((nx == x1 && ny == y1) || (nx == x2 && ny == y2)) {
                    continue;
                }
                tmp.offer(new Node(nx, ny, dust / 5));
                cnt++;
            }

            int diff = dust / 5;
            arr[x][y] -= diff * cnt;
        }

        for (Node n: tmp) {
            arr[n.x][n.y] += n.dust;
        }
    }



    public static void input() {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        t = sc.nextInt();
        arr = new int[r][c];
        boolean isFirst = true;
        for (int i=0; i < r; i++) {
            for (int j=0; j < c; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == -1) {
                    if (isFirst) {
                        x1 = i; y1 = j; isFirst = false;
                    } else {
                        x2 = i; y2= j;
                    }
                } else if (arr[i][j] != 0) {
                    q.offer(new Node(i, j, arr[i][j]));
                }
            }
        }
    }

    public static class Node {
        int x; int y; int dust;
        public Node (int x, int y, int dust) {
            this.x = x; this.y = y; this.dust = dust;
        }
    }
}
