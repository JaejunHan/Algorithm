import java.io.*;
import java.util.*;

class Main {
    static int n, k;
    static int[][] arr;
    static Node[] hList;

    static ArrayDeque<Integer>[][] qs;
    static int[] dx = {-1, 0, 1, 0}; // 상우하좌
    static int[] dy = {0, -1, 0, 1};

    static boolean flag = false;
    
    public static void main(String[] args) throws Exception {
        input();
        int times = 0;

        while (times <= 1000) {
            times++;

            for (int i=0; i< k; i++) {
                move(i);
                if (flag) {
                    System.out.println(times);
                    return;
                }
            }
        }
        System.out.println(-1);

    }

    public static void move(int idx) {

        Node horse = hList[idx];
        int x = horse.x;
        int y = horse.y;

        if (!isBottom(x, y, idx)) {
            return;
        }

        int dir = horse.dir;
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (blueOrOut(nx, ny)) {
            dir = (dir + 2) % 4;
            nx = x + dx[dir];
            ny = y + dy[dir];
            hList[idx].dir = dir;

            if (blueOrOut(nx, ny)) {
                nx = x; ny = y;
                return;
            }
            
        }
        
        if (arr[nx][ny] == 0) {
            ArrayDeque<Integer> oldQ = qs[x][y];
            while (!oldQ.isEmpty()) {
                int f = oldQ.poll();
                hList[f].x = nx;
                hList[f].y = ny;
                qs[nx][ny].offer(f);
            }
        } else {
            ArrayDeque<Integer> oldQ = qs[x][y];
            while (!oldQ.isEmpty()) {
                int f = oldQ.pollLast();
                hList[f].x = nx;
                hList[f].y = ny;
                qs[nx][ny].offer(f);
            }
        }

        if (qs[nx][ny].size() >= 4) {
            flag = true;
        }
    }

    public static boolean isBottom(int x, int y, int idx) {
        if (qs[x][y].size() != 0 && qs[x][y].getFirst() == idx) {
            return true;
        }

        return false;
    }

    public static boolean blueOrOut(int nx, int ny) {
        if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] == 2) {
            return true;
        }

        return false;
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n][n];
        hList = new Node[k];
        qs = new ArrayDeque[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
                qs[i][j] = new ArrayDeque<>();
            }
        }

        for (int i=0; i<k; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            int d = sc.nextInt();

            // 상좌하우

            if (d == 3) {
                d = 0;
            } else if (d == 1) {
                d = 3;
            } else if (d == 4) {
                d = 2;
            } else if (d == 2) {
                d = 1;
            }

            hList[i] = new Node(x, y, d);
            qs[x][y].offer(i);
        }

    }

    public static class Node {
        int x; int y; int dir;

        public Node(int x, int y, int dir) {
            this.x = x; this.y = y; this.dir = dir;
        }
    }
}