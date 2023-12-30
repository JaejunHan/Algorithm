import java.io.*;
import java.util.*;

class B16234 {
    static int n, l, r;
    static int[][] arr;
    static boolean flag = true;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();

        arr = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }


        int ans = 0;
        while (flag) {
            move();
            if (flag) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static void move() {
        visited = new boolean[n][n];
        flag = false;

        for (int x=0; x < n; x++) {
            for (int y=0; y<n; y++) {
                if (!visited[x][y]) {                
                    bfs(x, y);
                }
            }
        }
    }

    public static void bfs(int a, int b) {
        Queue<Node> q = new ArrayDeque<>();
        ArrayList<Node> list = new ArrayList<>();
        list.add(new Node(a, b));
        int totalSum = arr[a][b];
        
        visited[a][b] = true;
        q.add(new Node(a, b));
        while (!q.isEmpty()) {
            Node f = q.poll();
            int x = f.x;
            int y = f.y;

            for (int i=0; i< 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) {
                    continue;
                }

                int diff = Math.abs(arr[x][y] - arr[nx][ny]);
                if (diff >= l && diff <= r) {
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    totalSum += arr[nx][ny];
                    list.add(new Node(nx, ny));
                }
            }
        }

        if (list.size() != 1) {
            flag = true;
            int avg = totalSum / list.size();
            for (Node n: list) {
                arr[n.x][n.y] = avg;
            }
        }
    }


    
    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}