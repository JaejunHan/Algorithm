
import java.io.*;
import java.util.*;
class B20061 {
    static int n;
    static int[] t, x, y;
    static int ans = 0;
    static boolean[][] blue = new boolean[4][6];
    static boolean[][] green = new boolean[6][4];

    public static void main(String[] args) throws Exception {
        input();
        for (int i = 0; i < n; i++) {
            move(i);
            erase();
            clean();
            int a =1;
        }
        System.out.println(ans);
        System.out.println(cntBlock());
    }

    public static int cntBlock() {
        int cnt = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (green[i][j]) {
                    cnt++;
                }
            }
        }

        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 4; i++) {
                if (blue[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void move(int a) {
        //green
        for (int i=0; i<=6; i++) {
            Pair p = new Pair(i, y[a], t[a]);
            boolean isBreak = false;
            if (!p.xRange() || p.isBlock(green)) {
                Pair np = new Pair(i-1, y[a], t[a]);
                np.color(green);
                isBreak = true;
            }
            if (isBreak) {
                break;
            }
        }

        //blue
        for (int j = 0; j <= 6; j++) {
            Pair p = new Pair(x[a], j, t[a]);
            boolean isBreak = false;
            if (!p.yRange() || p.isBlock(blue)) {
                Pair np = new Pair(x[a], j-1, t[a]);
                np.color(blue);
                isBreak = true;
            }
            if (isBreak) {
                break;
            }
        }
    }

    public static void erase() {
        // green
        for (int i = 0; i < 6; i++) {
            boolean flag = true;
            for (int j=0; j < 4; j++) {
                if (!green[i][j]) {
                    flag = false;
                }
            }

            if (flag) {
                ans++;
                for (int x = i; x > 0; x--) {
                    for (int j=0; j<4; j++) {
                        green[x][j] = green[x-1][j];
                    }
                }
                Arrays.fill(green[0], false);
            }
        }


        // blue
        for (int j = 0; j < 6; j++) {
            boolean flag = true;
            for (int i=0; i < 4; i++) {
                if (!blue[i][j]) {
                    flag = false;
                }
            }

            if (flag) {
                ans++;
                for (int x = j; x > 0; x--) {
                    for (int i=0; i<4; i++) {
                        blue[i][x] = blue[i][x-1];
                    }
                }

                for (int r=0; r< 4; r++) {
                    blue[r][0] = false;
                }
            }
        }
    }

    public static void clean() {
        int cnt = 0;
        // green
        for (int i=0; i< 2; i++) {
            boolean flag = false;
            for (int j = 0; j < 4; j++) {
                if (green[i][j]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }

        for (int i=5; i>= cnt; i--) {
            for (int j = 0; j < 4; j++) {
                green[i][j] = green[i-cnt][j];
            }
        }
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < 4; j++) {
                green[i][j] = false;
            }
        }

        cnt = 0;
        // blue
        for (int j=0; j< 2; j++) {
            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                if (blue[i][j]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }

        for (int j=5; j>= cnt; j--) {
            for (int i = 0; i < 4; i++) {
                blue[i][j] = blue[i][j-cnt];
            }
        }
        for (int j = 0; j < cnt; j++) {
            for (int i = 0; i < 4; i++) {
                blue[i][j] = false;
            }
        }
    }


    public static class Pair {
        int x1; int y1;
        int x2; int y2;

        public void color(boolean[][] arr) {
            arr[x1][y1] = true;
            arr[x2][y2] = true;
        }

        public boolean isBlock(boolean[][] arr) {
            if (arr[x1][y1] || arr[x2][y2]) {
                return true;
            }
            return false;
        }

        public boolean xRange() {
            if (x1 >= 6 || x2 >= 6) {
                return false;
            }
            return true;
        }

        public boolean yRange() {
            if (y1>= 6 || y2 >= 6) {
                return false;
            }
            return true;
        }

        public Pair(int x, int y, int t) {
            this.x1 = x;
            this.y1 = y;
            if (t == 1) {
                this.x2 = x;
                this.y2 = y;
            } else if (t == 2) {
                this.x2 = x;
                this.y2 = y+1;
            } else if (t == 3) {
                this.x2 = x+1;
                this.y2 = y;
            }
        }
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        t = new int[n];
        x = new int[n];
        y = new int[n];

        for (int i=0; i< n; i++) {
            t[i] = sc.nextInt();
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
    }
}
