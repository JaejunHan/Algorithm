import java.io.*;
import java.util.*;

class B16947 {
    static int n;
    static ArrayList<Integer>[] list;
    static boolean[] cycle;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cycle = new boolean[n+1];
        list = new ArrayList[n+1];

        for (int i=1; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }

        int a, b;
        for (int i=0; i< n; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        for (int i=1; i<=n; i++) {
            cycle[i] = true;
            if (checkCycle(i, i, i)) {
                break;
            }
            cycle[i] = false;
        }

        // System.out.println(Arrays.toString(list));

        for (int i=1; i <=n; i++) {
            int res = getDistance(i);
            System.out.print(res + " ");
        }

    }

    public static boolean checkCycle(int prev, int node, int start) {
        for (int i=0; i< list[node].size(); i++) {
            int nxt = list[node].get(i);
            if (!cycle[nxt]) {
                cycle[nxt] = true;
                if (checkCycle(node, nxt, start)) {
                    return true;
                }
                cycle[nxt] = false;
            } else {
                if (nxt == start && prev != nxt){
                    return true;
                }
            }
        }
        return false;
    }

    public static int getDistance(int i) {
        if (cycle[i]) return 0;

        boolean[] visited = new boolean[n+1];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, 0));
        visited[i] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int v = node.v;
            if (cycle[node.v]) {
                return node.cnt;
            }
            for (int k=0; k < list[v].size(); k++) {
                int nxt = list[v].get(k);
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    q.add(new Node(nxt, node.cnt+1));
                }
            }
        }

        return 0;
    }

    public static class Node {
        int v;
        int cnt;
        public Node(int v, int cnt) {
            this.v = v;
            this.cnt = cnt;
        }
    }
}
