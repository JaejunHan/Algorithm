import java.util.*;
import java.io.*;

class Main {
    static int N, S, M;
    static int[] vector;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        M = sc.nextInt();
        int[] arr = new int[M+1];
        vector = new int[N+1];

        for (int i=1; i<=N; i++) {
            vector[i] = sc.nextInt();
        }
        Arrays.fill(arr, -1);

        arr[S] = 0;

        for (int i=1; i<=N; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j=0; j<= M; j++) {
                if (arr[j] == i-1) {
                    if (j - vector[i] >= 0 ) {

                        list.add(j - vector[i]);
                    }
                    if (j+vector[i] <= M) {
                        list.add(j + vector[i]);
                    }
                }
            }

            for (int ele: list) {
                arr[ele] = i;
            }
        }

        int max = -1;
        for (int i=0; i<=M; i++) {
            if (arr[i] == N) {
                max = Math.max(max, i);
            }
        }

        System.out.println(max);
    }

}