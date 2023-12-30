import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class B14500 {

    static int N;
    static int M;
    static int[][] mp;
    static boolean[][] visited;
    static int MAX = Integer.MIN_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mp = new int[N][M];
        visited = new boolean[N][M];
        for (int i=0; i< N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j< M; j++) {
                mp[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = false;
            }
        }
        
        for (int i=0; i< N; i++) {
            for (int j=0; j < M; j++) {
                visited[i][j] = true;
                getMax(1, mp[i][j], i, j);
                getStrange(i, j);
                visited[i][j] = false;
            }
        }

        System.out.println(MAX);

    }

    public static void getMax(int depth, int sum, int row, int col) {
        if (depth == 4) {
            MAX = Math.max(MAX, sum);
            return;
        }
        for (int i=0; i < 4; i++) {
            int x = row + dx[i];
            int y = col + dy[i];
            if (x >=0 && x < N && y >=0 && y < M && !visited[x][y]) {
                visited[x][y] = true;
                getMax(depth+1, sum+ mp[x][y], x, y);
                visited[x][y] = false;
            }
        }
    }

    public static void getStrange(int x, int y) {
        // ㅏ
        int sum = 0;
        if (x+2 < N && y+1 < M) {
            sum += mp[x][y]+ mp[x+1][y] + mp[x+2][y] + mp[x+1][y+1];
            MAX = Math.max(sum, MAX);
        }
        // ㅓ
        sum = 0;
        if (x+2 < N && y-1 >= 0) {
            sum += mp[x][y] + mp[x+1][y] + mp[x+2][y]+ mp[x+1][y-1];
            MAX = Math.max(sum, MAX);
        }

        // ㅗ
        sum = 0;
        if (x+1 < N && y-1 >=0 && y+1 < M) {
            sum += mp[x][y] + mp[x+1][y] + mp[x+1][y-1] + mp[x+1][y+1];
            MAX = Math.max(sum, MAX);
        }

        //ㅜ
        sum = 0;
        if (x+1 < N && y+2 < M) {
            sum += mp[x][y] + mp[x][y+1] + mp[x][y+2] + mp[x+1][y+1];
            MAX = Math.max(sum, MAX);
        }
    }
}