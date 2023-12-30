import java.io.*;

class B12946 {

    public static class Graph{
        char [][]map;
        int[] di = {-1,0,1,1,0,-1};
        int[] dj = {0,-1,-1,0,1,1};
        int[][] col;
        int ans;
        public Graph(int n) {
            map = new char[n][n];
            col = new int[n][n];
            for(int i =0;i<n;i++)
                for(int j=0;j<n;j++)
                    col[i][j] = -1;
            ans=0;
        }

        public void printUseColorCount() {
            System.out.println(ans);
        }
        public void addHexa(int index, String hexagon) {
            for(int i=0;i<hexagon.length();i++) {
                map[index][i] = hexagon.charAt(i);
            }
        }
        public void DFS(int i, int j, int c) {
            //col에 0 1 반복적으로 삽입
            col[i][j] = c;
            ans = ans>1 ? ans : 1;

            //주변 노드들 다 가져옴
            for(int x=0;x<6;x++) {
                int ni = i+di[x];
                int nj = j+dj[x];
                //범위 밖이면 패스
                if(!(ni>=0 && nj>=0 && ni<map.length && nj<map.length))
                    continue;
                //범위 안인데 X아니면 패스
                if(map[ni][nj] != 'X')
                    continue;
                //아직 칠하지 않은 칸이면 dfs실행
                if(col[ni][nj]==-1)
                    DFS(ni,nj,1-c);
                ans = ans<2 ? 2 : ans;
                //주변 색칠한 칸중에 내 c랑 값이 같으면 색 3개 이상 칠해야한다는 뜻
                if(col[ni][nj]==c)
                    ans  = ans<3 ? 3: ans;

            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Graph g = new Graph(n);
        for(int i=0;i<n;i++) {
            String hexagon = br.readLine();
            g.addHexa(i, hexagon);
        }
        //깊이탐색
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                if (g.map[i][j] == 'X' && g.col[i][j] == -1)
                    g.DFS(i, j, 0);

        //사용한 색갯수 출력
        g.printUseColorCount();

        //g.showmap();


        br.close();
        bw.flush();
        bw.close();
    }
}