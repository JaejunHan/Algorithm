import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static char[][] arr;
    static Node[] pri;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        for (int i=0; i< k; i++) {
            pri = new Node[2];
            int idx = 0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new char[n+2][m+2];

            for (int j=0; j< n; j++) {
                Arrays.fill(arr[j], '.');
            }

            for (int a=0; a< n; a++) {
                String s = br.readLine();
                for (int b=0; b< m; b++) {
                    char c = s.charAt(b);
                    arr[a+1][b+1] = c;
                    if (c == '$') {
                        pri[idx++] = new Node(a, b, 0);
                    }
                }
            }
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
        public int compareTo(Node o){
            return this.openCnt - o.openCnt;
        }
    }

}