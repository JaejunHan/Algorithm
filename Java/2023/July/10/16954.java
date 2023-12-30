import java.io.*;
import java.util.*;

class B16954 {
    static char[][] arr = new char[8][8];
    static int ans = 0;
    static int[] dx = {-1, 0, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, -1, 0, 1, 0, -1, -1, 1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i <8; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        bfs();

        System.out.println(ans);
    }

    public static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(7, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i< size; i++) {
                Node f = q.poll();
                int x = f.x;
                int y = f.y;

                if (arr[x][y] == '#') {
                    continue;
                }

                if (x == 0 && y == 7) {
                    ans = 1;
                    return;
                }

                for (int j=0; j< 9; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) continue;

                    if (arr[nx][ny] != '#') {
                        q.add(new Node(nx, ny));
                    }
                }
            }

            down();
        }
    }

    public static void down() {
        for (int i=7; i > 0; i--) {
            for (int j=0; j < 8; j++) {
                arr[i][j] = arr[i-1][j];
            }
        }

        for (int i=0; i< 7; i++) {
            arr[0][i] = '.';
        }
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