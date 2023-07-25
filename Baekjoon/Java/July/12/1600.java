import java.io.*;
import java.util.*;

class B1600 {
    static int k;
    static int n, m;
    static int[][] arr;
    static boolean[][][] visited;
    static int[][] move1 = {{-1, -2}, {-2, -1}, {-1, 2}, {-2, 1}, {1, 2}, {2, 1}, {1, -2}, {2, -1}};
    static int[][] move2 = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        m = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n][m];
        visited = new boolean[n][m][k+1];

        for (int i=0; i< n; i++) {
            for (int j=0;j <m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int ans = bfs();
        System.out.println(ans);
    }

    public static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node (0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node f = q.poll();
            int x = f.x;
            int y = f.y;
            int horse = f.horse;
            int cnt = f.cnt;

            if (x == n-1 && y == m-1) {
                return cnt;
            }

            if (horse < k) {
                for (int i=0; i < 8; i++) {
                    int nx = x + move1[i][0];
                    int ny = y + move1[i][1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny][horse+1] || arr[nx][ny] == 1) continue;
                    visited[nx][ny][horse+1] = true;
                    q.add(new Node(nx, ny, horse+1, cnt+1));
                }
            }

            for (int i=0; i< 4; i++) {
                int nx = x + move2[i][0];
                int ny = y + move2[i][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny][horse] || arr[nx][ny] == 1) continue;
                visited[nx][ny][horse] = true;
                q.add(new Node(nx, ny, horse, cnt+1));
            }

        }

        return -1;
    }

    public static class Node {
        int x;
        int y;
        int horse;
        int cnt;
        public Node (int x, int y, int horse, int cnt){
            this.x = x;
            this.y = y;
            this.horse = horse;
            this.cnt = cnt;
        }
    }
}