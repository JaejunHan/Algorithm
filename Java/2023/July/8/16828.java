import java.io.*;
import java.util.*;

class B16828 {
    static int n, m;
    static int[] arr;
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[101];
        
        for (int i=0; i< n+m; i++) {
            arr[sc.nextInt()] = sc.nextInt();
        }

        Queue<Point> q = new LinkedList<>();
        visited[1] = true;
        q.add(new Point(1, 0));

        while (!q.isEmpty()) {
            Point f = q.poll();
            int x = f.x;
            int cnt = f.cnt;

            if (x == 100) {
                System.out.println(cnt);
                return;
            }

            for (int i=1; i<= 6; i++) {
                int nx = x + i;
                if (nx <= 100 && !visited[nx]) {
                    visited[nx] = true;
                    if (arr[nx] != 0) {
                        nx = arr[nx];
                        if (!visited[nx]) {
                            q.add(new Point(nx, cnt+1));
                        }
                    } else {
                        q.add(new Point(nx, cnt+1));
                    }
                }
            }
        }

    }

    public static class Point {
        int x;
        int cnt;
        public Point(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
}
