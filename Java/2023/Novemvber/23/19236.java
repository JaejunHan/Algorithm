import java.util.*;
class B19236 {
    static Node[] fishList = new Node[17];
    static int[][] arr = new int[4][4];

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int ans = 0;
    static int max = -1;
    static int d = -1;

    public static void main(String[] args) throws Exception {
        input();
        eatFirst();
        eat(0, 0, d);
        System.out.println(max);
    }

    private static void eat(int x, int y, int dir) {
        max = Math.max(ans, max);

        int[][] copy = new int[4][4];
        Node[] fishCpy = new Node[17];
        for(int i = 0; i < arr.length; i++) {
            System.arraycopy(arr[i], 0, copy[i], 0, arr.length);
        }

        for(int i = 1; i <= 16; i++)
            fishCpy[i] = new Node(fishList[i]);

        move(x, y);


        for (int i=1; i < 4; i++) {
            int nx = x + i * dx[dir];
            int ny = y + i * dy[dir];

            if (!isRange(nx, ny) || fishList[arr[nx][ny]].eaten) {
                continue;
            }

            int num = arr[nx][ny];
            Node fish = fishList[arr[nx][ny]];

            ans += fish.num;
            fishList[num].eaten = true;
            eat(nx, ny, fish.dir);
            fishList[num].eaten = false;
            ans -= fish.num;
        }

        // 맵 상태, 물고기 정보 되돌리기
        for(int j = 0; j < arr.length; j++)
            System.arraycopy(copy[j], 0, arr[j], 0, arr.length);

        for(int i=1; i<=16; i++)
            fishList[i] = new Node(fishCpy[i]);
    }

    public static void move(int a, int b) {
        for (int i = 1; i <= 16; i++) {
            if (fishList[i].eaten) {
                continue;
            }
            int x = fishList[i].x;
            int y = fishList[i].y;
            int dir = fishList[i].dir;

            for (int k=0; k < 8; k++) {
                fishList[i].dir = (dir + k) % 8;
                int nd = fishList[i].dir;
                int nx = x + dx[nd];
                int ny = y + dy[nd];
                boolean isBreak = false;
                if (isRange(nx, ny) && (nx != a || ny != b)) {
                    isBreak = true;
                    swap(x, y, nx, ny);
                }

                if (isBreak) {
                    break;
                }
            }
        }
    }

    public static void swap(int x, int y, int nx, int ny) {
        Node f = fishList[arr[x][y]];
        Node s = fishList[arr[nx][ny]];

        int tmp = arr[x][y];
        arr[x][y] = arr[nx][ny];
        arr[nx][ny] = tmp;

        f.x = nx; f.y = ny; s.x = x; s.y = y;
    }

    public static boolean isRange(int nx, int ny) {
        if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) {
            return false;
        }
        return true;
    }

    public static void eatFirst() {
        int num = arr[0][0];
        d = fishList[num].dir;
        ans += num;
        fishList[num].eaten = true;
    }


    public static void input() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = sc.nextInt();
                int dir = sc.nextInt() - 1;
                fishList[num] = new Node(i, j, num, dir);
                arr[i][j] = num;
            }
        }
    }

    public static class Node {
        int x; int y; int dir; int num; boolean eaten;
        public Node (int x, int y, int num, int dir) {
            this.x = x; this.y = y;
            this.num = num; this.dir = dir;
            this.eaten = false;
        }

        public Node (Node o) {
            this.x = o.x; this.y = o.y;
            this.num = o.num; this.dir = o.dir;
            this.eaten = o.eaten;
        }
    }

}
