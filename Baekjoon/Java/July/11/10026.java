import java.io.*;
import java.util.*;

class B10026 {
    static int n;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];

        for (int i=0; i< n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int ans1 = 0, ans2 = 0;
        ans1 = getCnt();
        changeToRed();
        ans2 = getCnt();
        System.out.println(ans1 + " " + ans2);
    }

    public static int getCnt() {
        visited = new boolean[n][n];

        int ans = 0;
        for (int i=0; i < n; i++) {
            for (int j=0; j < n; j++) {
                if (!visited[i][j]) {                
                    bfs(i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void bfs(int a, int b) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(a, b));
        visited[a][b] = true;

        while (!q.isEmpty()) {
            Node f = q.poll();
            int x = f.x;
            int y = f.y;
            int azz = 1;

            for (int i=0; i< 4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx <0 || nx >= n || ny <0  || ny >=n) continue;

                if (arr[x][y] == arr[nx][ny] && !visited[nx][ny]) {
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        int az = 1;
    }

    public static void changeToRed() {
        for (int i=0; i< n; i++) {
            for (int j=0; j<n; j++) {
                if (arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }
    }

    public static class Node {
        int x;
        int y;
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}