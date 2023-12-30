import java.io.*;
import java.util.*;

class B2003 {
    static int n, m;
    static int[] arr;
    static int cnt = 0;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n+1];
        for (int i=0; i< n; i++) {
            arr[i+1] = sc.nextInt();
        }

        // 누적합
        for (int i=1; i < n+1; i++) {
            arr[i] += arr[i-1];
        }
        for (int i=0; i< n+1; i++) {
            for (int j=i+1; j< n+1; j++) {
                if ((arr[j] - arr[i]) == m) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
