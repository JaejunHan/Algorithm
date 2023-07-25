import java.io.*;
import java.util.*;

class B2234 {
    static int n, m;
    static int[][] arr;
    static HashMap<Integer, Integer> mp = new HashMap<>();
    static int[][] visited;
    static int idx = 1;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] adjVisit;
    static ArrayList<Set<Integer>> adj= new ArrayList<>();
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n][m];
        adjVisit = new boolean[n][m];

        for (int i=0; i< n; i++) {
            for (int j=0; j< m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        visited = new int[n][m];
        for (int i=0; i< n; i++) {
            for (int j=0; j<m; j++) {
                if (visited[i][j] !=0) continue;
                bfs(i, j);
            }
        }

        for (int i=0; i<= mp.size(); i++) {
            adj.add(new HashSet<>());
        }
        for (int i=0; i< n; i++) {
            for (int j=0; j<m; j++) {
                if (adjVisit[i][j]) continue;
                getAdj(i, j);
            }
        }
        int ans3 = getThirdAns();

        System.out.println(mp.size());
        System.out.println(Collections.max(mp.values()));
        System.out.println(ans3);
    }

    public static int getThirdAns() {
        int ret = Integer.MIN_VALUE;
        for (int i=1; i<= mp.size(); i++) {
            for (Integer a: adj.get(i)) {
                ret = Math.max(ret, mp.get(a) + mp.get(i));
            }
        }
        return ret;
    }

    public static void getAdj(int a, int b) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(a, b));
        boolean[][] adjVisit = new boolean[n][m];
        adjVisit[a][b] = true;

        while (!q.isEmpty()) {
            Node f = q.poll();
            int x = f.x;
            int y = f.y;
            int now = visited[x][y];

            for (int i=0; i< 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || adjVisit[nx][ny]) continue;
                
                int nxt = visited[nx][ny];
                if (now != nxt) {
                    adj.get(now).add(nxt);
                    adj.get(nxt).add(now);
                } else {
                    adjVisit[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }
    }

    public static void bfs(int a, int b) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(a, b));
        visited[a][b] = idx;
        int cnt = 1;

        while (!q.isEmpty()) {
            Node f = q.poll();
            int x = f.x;
            int y = f.y;

            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] != 0) continue;
                if (((1<<i) & arr[nx][ny]) == 0) {
                    visited[nx][ny] = idx;
                    q.add(new Node(nx, ny));
                    cnt++;
                }
            }
        }
        
        mp.put(idx++, cnt);
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