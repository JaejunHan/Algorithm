import java.io.*;
import java.util.*;

class B1963 {
    static int n, a, b;
    static boolean[] prime = new boolean[10000];
    static boolean[] visited = new boolean[10000];
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        getPrime();

        for (int i=0; i< n; i++) {
            Arrays.fill(visited, false);
            a = sc.nextInt();
            b = sc.nextInt();
            if (a == b) {
                System.out.println(0);
                continue;
            }
            bfs();
        }

    }

    public static void getPrime() {
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i=2; i<10000; i++) {
            if (prime[i]) {
                for (int j = i+i; j < 10000; j+=i) {
                    prime[j] = false;
                }
            }
        }
    }

    public static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node (a, 0));
        visited[a] = true;

        while (!q.isEmpty()) {
            Node f = q.poll();
            int x = f.x;
            int cnt = f.cnt;

            if (x == b) {
                System.out.println(cnt);
                return;
            }

            for (int i=0; i < 4; i++) {
                int div = (int) Math.pow(10, i);
                int rem = (x / div) % 10;
                int nxt = x - rem * div;
                int temp;
                for (int j=0; j< 10; j++) {
                    temp = nxt + div * j;
                    if (i==3 && j == 0) {
                        continue;
                    }

                    if (!visited[temp] && prime[temp]) {
                        q.add(new Node(temp, cnt+1));
                        visited[temp] = true;
                    } 
                }
            }
        }

        System.out.println("Impossible");
    }

    public static class Node {
        int x;
        int cnt;
        public Node(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
}