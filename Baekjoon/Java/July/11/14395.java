import java.io.*;
import java.util.*;

class B14395 {
    static long start, target;
    static Set<Long> set = new HashSet<>();
    static char[] ch_list = {'*', '+', '-', '/'};
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        start = sc.nextInt();
        target = sc.nextInt();
        if (start == target) {
            System.out.println(0);
            return;
        }
        bfs();
    }

    public static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(start, ""));
        set.add(start);

        while (!q.isEmpty()) {
            Node f = q.poll();
            long x = f.x;
            String s = f.s;

            if (x == target) {
                System.out.println(s);
                return;
            }
            long nx = 0;
            for (int i=0; i < 4; i++) {
                switch (i) {
                    case 0:
                        nx = x * x;
                        break;
                    case 1:
                        nx = x + x;
                        break;
                    case 2:
                        nx = x - x;
                        break;
                    case 3:
                        if (x == 0) {
                            continue;
                        }
                        nx = x / x;
                        break;
                }
                if (!set.contains(nx)) {     
                    set.add(nx);           
                    q.add(new Node(nx, s + ch_list[i]));
                }
            }
        }
        System.out.println(-1);
    }

    public static class Node {
        long x;
        String s;
        public Node (long x, String s) {
            this.x = x;
            this.s = s;
        }
    }
}