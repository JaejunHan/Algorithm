import java.io.*;
import java.util.*;

class B5014 {
    static int top, s, g, u, d;
    static boolean[] visited = new boolean[1000001];
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        top = sc.nextInt();
        s = sc.nextInt();
        g = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(s, 0));
        visited[s] = true;

        while (!q.isEmpty()) {
            Node f = q.poll();
            int x = f.x;
            int cnt = f.cnt;

            if (x == g) {
                System.out.println(cnt);
                return;
            }

            for (int i=0; i< 2; i++) {
                int tmp = x;
                switch (i) {
                    case 0:
                        tmp += u;
                        if (tmp <= top && !visited[tmp]) {
                            visited[tmp] = true;
                            q.add(new Node(tmp, cnt+1));
                        }
                        break;
                    case 1:
                        tmp -= d;
                        if (tmp > 0 && !visited[tmp]) {
                            visited[tmp] = true;
                            q.add(new Node(tmp, cnt+1));
                        }
                        break;
                }
            }
        }

        System.out.println("use the stairs");
    }

    public static class Node {
        int x;
        int cnt;

        public Node (int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
}