import java.io.*;
import java.util.*;

class B12886 {
    static boolean[][] visited = new boolean[1501][1501];
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if ((a+b+c) % 3 != 0) {
            System.out.println(0);
            return;
        }

        Queue<Stone> q = new LinkedList<>();
        q.add(new Stone(a, b, c));
        visited[a][b] = true;

        while (!q.isEmpty()) {
            Stone f = q.poll();
            int x = f.x;
            int y = f.y;
            int z = f.z;

            if (x == y && y == z) {
                System.out.println(1);
                return;
            }

            int temp1 = x;
            int temp2 = y;
            int temp3 = z;
            for (int i=0; i< 3; i++) {
                x = temp1;
                y = temp2;
                z = temp3;
                switch(i) {
                    case 0:
                        // x와 y 비교
                        if (x < y) {
                            y = y - x;
                            x = 2*x;
                        } else if (x > y) {
                            x = x - y;
                            y = 2*y;
                        } else {
                            continue;
                        }
                        break;
                    case 1:        
                        // y와 z 비교
                        if (y < z) {
                            z = z - y;
                            y = 2*y;
                        } else if (y > z) {
                            y = y - z;
                            z = 2*z;
                        } else {
                            continue;
                        }
                        break;
                    case 2:
                        // z와 x 비교
                        if (z < x) {
                            x = x - z;
                            z = 2*z;
                        } else if (z > x) {
                            z = z - x;
                            x = 2*x;
                        } else {
                            continue;
                        }
                        break;
                }

                if (x>=0 && x<= 1500 && y>=0 && y<= 1500 && z>=0 && z<= 1500 && !visited[x][y]) {
                    q.add(new Stone(x, y, z));
                    visited[x][y] = true;
                }
            }

        }

        System.out.println(0);
    }

    public static class Stone{
        int x;
        int y;
        int z;
        public Stone(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}