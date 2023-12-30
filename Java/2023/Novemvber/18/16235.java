import java.io.*;
import java.util.*;

class B16235 {
    static int n, m, k;
    static int[][] ground;
    static PriorityQueue<Tree> q;
    static Queue<Tree> deadTrees;
    static int[][] add;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static void main(String[] args) throws Exception {
         getInput();
         while (k > 0) {
            k--;

            spring();
            summer();
            fall();
            winter();
         }

         System.out.println(q.size());
    }

    public static void spring() {
        PriorityQueue<Tree> nq = new PriorityQueue<>();
        deadTrees = new ArrayDeque<>();
        while (!q.isEmpty()) {
            Tree f = q.poll();
            int x = f.x;
            int y = f.y;
            int age = f.age;
            
            if (age > ground[x][y]) {
                deadTrees.add(new Tree(x, y, age));
                continue;
            }

            ground[x][y] -= age;
            nq.offer(new Tree(x, y, age+1));
        }

        q = nq;
    }
    
    public static void summer() {
        while (!deadTrees.isEmpty()) {
            Tree f = deadTrees.poll();
            int x = f.x;
            int y = f.y;
            int age = f.age;

            ground[x][y] += age / 2;
        }
    }
    
    public static void fall() {
        Queue<Tree> tmp = new ArrayDeque<>();
        for (Tree t: q) {
            int x = t.x; int y = t.y; int age = t.age;
            for (int i=0; i< 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || age % 5 != 0) {
                    continue;
                }

                tmp.offer(new Tree(nx, ny, 1));
            }
        }

        for (Tree t: tmp) {
            q.offer(t);
        }
    }
    
    public static void winter() {
        for (int i=0; i< n; i++) {
            for (int j=0; j < n; j ++) {
                ground[i][j] += add[i][j];
            }
        }
    }

    public static void getInput() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        q = new PriorityQueue<>();

        ground = new int[n][n];
        add = new int[n][n];
        for (int i=0; i<n; i++) {
            Arrays.fill(ground[i], 5);
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                add[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i< m; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            int age = sc.nextInt();
            q.offer(new Tree(x, y, age));
        }
    }

    public static class Tree implements Comparable<Tree> {
        int x; int y; int age;
        public Tree (int x, int y, int age) {
            this.x = x; this.y = y; this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }

}