import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static char[][] arr;
    static int idx = 1;
    static int[][] group;
    static HashMap<Integer, Integer> mp = new HashMap<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new char[n][m];
        group = new int[n][m];

        for (int i=0; i< n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i=0; i< n; i++) {
            for (int j=0; j< m; j++) {
                if (arr[i][j] == '0' && group[i][j] == 0) {
                    mp.put(idx, bfs(i, j));
                    idx++;
                }
            }
        }
        

        StringBuffer sb = new StringBuffer();
        for (int i=0; i< n; i++) {
            for (int j=0; j< m; j++) {
                sb.append(mapCount(i, j));
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    public static int mapCount(int x, int y) {
        if (arr[x][y] == '0') {
            return 0;
        }

        int sum = 1;

        Set<Integer> set = new HashSet<>();
        for (int i=0; i < 4; i++) {
            int nx = x+ dx[i];
            int ny = y + dy[i];
            if (nx>=0 && nx < n && ny >=0 && ny < m && group[nx][ny] != 0) {
                set.add(group[nx][ny]);
            }
        }

        for (int ele: set) {
            sum += mp.get(ele);
        }

        return sum%10;
    }

    public static int bfs(int x, int y) {

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        group[x][y] = idx;


        int cnt = 1;

        while(!q.isEmpty()) {
            Point f = q.poll();
            int a = f.x;
            int b = f.y;
            for (int i=0; i< 4; i++) {
                int nx = a + dx[i];
                int ny = b + dy[i];
                if (nx >=0 && nx < n && ny >=0 && ny < m && group[nx][ny] ==0 && arr[nx][ny] == '0') {
                    q.add(new Point(nx, ny));
                    group[nx][ny] = idx;            
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}