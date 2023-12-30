import java.io.*;
import java.util.*;

class B9876 {
    static int n, m;
    static int idx = 0;
    static char[][] arr;
    static int[][] arr1, arr2, arr3;
    static Node[] prisoner = new Node[3];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int a = 0; a< t; a++) {
            idx = 0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new char[n+2][m+2];
            for (int i=0; i< n; i++) {
                String s= br.readLine();
                int w= 1;
                for (int j=0; j< m; j++) {
                    char c = s.charAt(j);
                    arr[i+1][j+1] = c;
                    if (c == '$') {
                        prisoner[idx++] = new Node(i+1, j+1, 0);
                    }
                }
            }
            initArr();
            prisoner[idx] = new Node(0, 0, 0);
            
            arr1 = bfs(0);
            arr2 = bfs(1);
            arr3 = bfs(2);
            
            System.out.println(getAns());
        }   
    }
    public static int getAns() {
        int ans = Integer.MAX_VALUE;
        for (int i=0; i< n+2; i++) {
            for (int j=0; j < m+2; j++) {
                if (arr[i][j] == '*' || arr1[i][j] == -1 || arr2[i][j] == -1 || arr3[i][j] == -1 ) continue;

                int temp = arr1[i][j] + arr2[i][j] + arr3[i][j];
                if (arr[i][j] == '#') {
                    ans = Math.min(ans, temp-2);
                } else {
                    ans = Math.min(ans, temp);
                }
            }
        }
        return ans;
    }

    public static int[][] bfs(int z) {
        int[][] ret = new int[n+2][m+2];
        for (int i=0; i< n+2; i++) {
            Arrays.fill(ret[i], -1);
        }
        boolean[][] visited = new boolean[n+2][m+2];
        Queue<Node> q = new PriorityQueue<>();
        q.add(prisoner[z]);
        visited[prisoner[z].x][prisoner[z].y] = true;
        int w = 1;
        while (!q.isEmpty()) {
            Node f = q.poll();
            int x = f.x;
            int y = f.y;
            int openCnt = f.openCnt;
            ret[x][y] = openCnt;

            for (int i=0; i< 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n+2 || ny < 0 || ny >= m+2 || visited[nx][ny] || arr[nx][ny] == '*') continue;
                
                visited[nx][ny] = true;
                if (arr[nx][ny] == '#') { // 문인 경우
                    q.add(new Node(nx, ny, openCnt+1));
                } else { // 문이 아니고 일반 통로인 경우
                    q.add(new Node(nx, ny, openCnt));
                }
            }
        }
        return ret;
    }

    public static void initArr () {
        for (int i=0; i< n+2; i++) {
            arr[i][0] = '.';
        }
        for (int i=0; i< n+2; i++) {
            arr[i][m+1] = '.';
        }
        for (int i=0; i< m+2; i++) {
            arr[0][i] = '.';
        }
        for (int i=0; i< m+2; i++) {
            arr[n+1][i] = '.';
        }
    }

    public static class Node implements Comparable<Node>{
        int x;
        int y;
        int openCnt;
        public Node(int x, int y, int openCnt) {
            this.x = x;
            this.y = y;
            this.openCnt = openCnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.openCnt - o.openCnt;
        }
    }
}