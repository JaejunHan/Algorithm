import java.io.*;
import java.util.*;

class B17140 {
    static int r, c, k;
    static int[][] arr = new int[101][101];
    static int rLength, cLength;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        input();

        while (ans <= 100) {
            if (check()) {
                System.out.println(ans);
                return;
            }
            operate();
            ans++;
        }

        System.out.println(-1);
    }
    public static void R(int x) {
        Queue<Pair> q = new PriorityQueue<>();
        Map<Integer, Integer> mp = new HashMap<>();

        for (int j=0; j < cLength; j++) {
            if (arr[x][j] == 0) {
                continue;
            }
            if (!mp.containsKey(arr[x][j])) {
                mp.put(arr[x][j], 1);
            } else {
                mp.put(arr[x][j], mp.get(arr[x][j]) + 1);
            }
        }

        mp.forEach((num, cnt) -> q.offer(new Pair(num, cnt)));

        int idx = 0;
        while (!q.isEmpty()) {
            Pair f = q.poll();
            arr[x][idx++] = f.num;
            arr[x][idx++] = f.cnt;
        }

        cLength = Math.max(cLength, idx);

        while (idx <= 100) {
            arr[x][idx++] = 0;
        }
    }

    public static void C(int y) {
        Queue<Pair> q = new PriorityQueue<>();
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i=0; i < rLength; i++) {
            if (arr[i][y] == 0) {
                continue;
            }
            if (!mp.containsKey(arr[i][y])) {
                mp.put(arr[i][y], 1);
            } else {
                mp.put(arr[i][y], mp.get(arr[i][y]) + 1);
            }
        }

        mp.forEach((num, cnt) -> q.offer(new Pair(num, cnt)));

        int idx = 0;
        while (!q.isEmpty()) {
            Pair f = q.poll();
            arr[idx++][y] = f.num;
            arr[idx++][y] = f.cnt;
        }

        rLength = Math.max(rLength, idx);

        while (idx <= 100) {
            arr[idx++][y] = 0;
        }
    }

    public static class Pair implements Comparable<Pair> {
        int num;
        int cnt;

        public Pair(int num, int cnt) {
            this.num = num; this.cnt = cnt;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.cnt < o.cnt) {
                return -1;
            } else if (this.cnt == o.cnt) {
                return this.num - o.num;
            } else {
                return 1;
            }
        }
    }

    public static void operate() {
        if (rLength >= cLength) {
            for (int i=0; i < rLength; i++) {
                R(i);
            }
        } else {
            for (int j=0; j < cLength; j++) {
                C(j);
            }
        }
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt()-1;
        c = sc.nextInt()-1;
        k = sc.nextInt();

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        rLength = 3;
        cLength = 3;
    }

    public static boolean check() {
        if (arr[r][c] == k) {
            return true;
        }

        return false;
    }
}