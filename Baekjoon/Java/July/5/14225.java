import java.io.*;
import java.util.*;

class B14225 {
    static int n;
    static int[] arr;
    static boolean[] visited = new boolean[20*100000+1];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i< n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        visited[0] = true;
        for (int i=1; i < (1<<n); i++) {
            sum = 0;
            for (int j= 0; j < n;j++) {
                if ((i & (1<<j)) != 0) {
                    sum += arr[j];
                }
            }
            visited[sum] = true;
        }

        for (int i=0; i < visited.length; i++) {
            if (!visited[i]) {
                System.out.println(i);
                break;
            }
        }
    }
}
