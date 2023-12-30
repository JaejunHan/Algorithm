import java.io.*;
import java.util.*;

class B16974 {
    static int n;
    static long x;
    static long[] p, h;
    public static void main(String[] args) throws Exception {
        input();

        long ans = eat(n, x);
        System.out.println(ans);
    }

    public static long eat(int level, long cnt) {
        if (level == 0) {
            if (cnt == 0) {
                return 0;
            } else {
                return 1;
            }
        }

        if (cnt == 0) {
            return 0;
        } else if (h[level] == cnt) {
            return p[level];
        } else if (h[level-1]+2 == cnt) {
            return p[level-1] + 1;
        } else if (h[level-1] + 2 < cnt) {
            return p[level-1] + 1 + eat(level-1, cnt - (h[level-1] + 2));
        } else {
            return eat(level-1, cnt-1);
        }
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextLong();
        p = new long[n+1];
        h = new long[n+1];

        p[0] = 1;
        h[0] = 1;
        for (int i=1; i <= n; i++) {
            p[i] = p[i-1] * 2 + 1;
            h[i] = h[i-1] * 2 + 3;
        }
    }
}