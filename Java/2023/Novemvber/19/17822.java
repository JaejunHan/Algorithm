import java.io.*;
import java.util.*;

class B17822 {
    static int n, m, t;
    static ArrayList<Integer>[] arr;
    static int[] x, d, k;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean change = false;

    public static void main(String[] args) throws Exception {
        input();
        for (int i=0; i< t; i++) {
            cycle(i);
            change = false;
            for (int a=0; a < n; a++) {
                for (int b=0; b< m; b++) {
                    if (arr[a].get(b) != -1) {
                        erase(a, b, arr[a].get(b));
                    }
                }
            }

            if (!change) {
                avg();
            }
        }

        System.out.println(sum());
    }

    public static void print() {
        System.out.println("print start");
        for (int i=0; i< n; i++) {
            for (int j=0; j<m; j++) {
                System.out.print(arr[i].get(j) + " ");
            }
            System.out.println();
        }
    }

    public static int sum() {
        int ans = 0;
        for (int i=0; i < n; i++) {
            for (int j=0; j < m; j++) {
                if (arr[i].get(j) != -1) {
                    ans += arr[i].get(j);
                }
            }
        }

        return ans;
    }

    public static void avg() {
        double avg = 0;
        int sum = 0;
        int cnt = 0;
        for (int i=0; i< n; i++) {
            for (int j=0; j< m; j++) {
                if (arr[i].get(j) != -1) {
                    sum += arr[i].get(j);
                    cnt++;
                }
            }
        }

        if (cnt == 0) {
            return;
        }
        avg = (double) sum / cnt;

        for (int i=0; i< n; i++) {
            for (int j=0; j< m; j++) {
                if (arr[i].get(j) != -1) {
                    if (arr[i].get(j) > avg) {
                        arr[i].set(j, arr[i].get(j) - 1);
                    } else if (arr[i].get(j) < avg)  {
                        arr[i].set(j, arr[i].get(j) + 1);
                    }
                }
            }
        }
    }

    public static void erase(int a, int b, int num) {
        for (int i=0; i< 4; i++) {
            int nx = a + dx[i];
            int ny = b + dy[i];

            if (ny == m) {
                ny = 0;
            } else if (ny == -1) {
                ny = m-1;
            }

            if (nx < 0 || nx >= n) {
                continue;
            }

            if (arr[nx].get(ny) == num) {
                arr[nx].set(ny, -1);
                change = true;
                erase(nx, ny, num);
            }
        }
    }

    public static void cycle(int idx) {
        int xi = x[idx];
        int di = d[idx];
        int ki = k[idx];

        for (int i= xi; i <= n; i += xi) {
            for (int j = 0; j < ki; j++) {
                if (di == 0) {
                    rotateClock(i-1);
                } else {
                    rotateInvClock(i-1);
                }
            }
        }
    }

    public static void rotateClock(int r) {
        int num = arr[r].remove(arr[r].size()-1);
        arr[r].add(0, num);
    }

    public static void rotateInvClock(int r) {
        int num = arr[r].remove(0);
        arr[r].add(num);
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();

        arr = new ArrayList[n+1];
        x = new int[t];
        d = new int[t];
        k = new int[t];

        for (int i=0; i< n; i++) {
            arr[i] = new ArrayList<>();
            for (int j=0; j < m; j++) {
                arr[i].add(sc.nextInt());
            }
        }

        for (int i=0; i < t; i++) {
            x[i] = sc.nextInt();
            d[i] = sc.nextInt();
            k[i] = sc.nextInt();
        }
    }
}