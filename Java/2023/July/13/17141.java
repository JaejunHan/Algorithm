import java.io.*;
import java.util.*;

class B17141 {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static boolean[] choose;
    static ArrayList<Node> virus = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int ans = Integer.MAX_VALUE;
    static boolean valid = false;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][n];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                int tmp = sc.nextInt();
                arr[i][j] = tmp;
                if (tmp == 2) {
                    virus.add(new Node(i, j));
                }
            }
        }

        choose = new boolean[virus.size()];

        for (int i=0; i< virus.size(); i++) {
            if (choose[i]) continue;
            choose[i] = true;
            dfs(1, i);
            choose[i] = false;
        }

        if (valid) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }

    public static void dfs(int depth, int idx) {
        if (depth == m) {
            int ret = bfs();
            boolean tmp = checkValid();
            if (tmp) {
                ans = Math.min(ans, ret);
            }
            valid = valid || tmp;
            return;
        }

        for (int i=idx; i < virus.size(); i++) {
            if (choose[i]) continue;
            choose[i] = true;
            dfs(depth+1, i+1);
            choose[i] = false;
        }
    }
    public static boolean checkValid() {
        for (int i=0; i< n; i++) {
            for (int j=0; j<n; j++) {
                if (arr[i][j] != 1 && visited[i][j] == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int bfs() {
        visited = new boolean[n][n];
        Queue<Node> q = new ArrayDeque<>();
        for (int i=0; i< virus.size(); i++) {
            if (choose[i]) {
                Node v = virus.get(i);
                q.add(v);
                visited[v.x][v.y] = true;
            }
        }

        int cnt = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int a=0; a< size; a++) {
                Node f = q.poll();
                int x = f.x;
                int y = f.y;
                for (int i=0; i< 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx <0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] || arr[nx][ny] == 1) continue;

                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
            cnt++;
        }
        return cnt;
    }

    public static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}