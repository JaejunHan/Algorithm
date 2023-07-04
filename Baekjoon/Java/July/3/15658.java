import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class B15658 {
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int N;
    static int[] arr;
    static int[] op = new int[4];
    static int[] res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0]);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int idx, int sum) {
        if (idx == N) {
            MAX = Math.max(MAX, sum);
            MIN = Math.min(MIN, sum);
            return;
        }

        if (op[0] != 0) {
            op[0] -= 1;
            dfs(idx+1, sum + arr[idx]);
            op[0] += 1;
        }
        if (op[1] != 0) {
            op[1] -= 1;
            dfs(idx+1, sum - arr[idx]);
            op[1] += 1;
        }
        if (op[2] != 0) {
            op[2] -= 1;
            dfs(idx+1, sum * arr[idx]);
            op[2] += 1;
        }
        if (op[3] != 0) {
            op[3] -= 1;
            dfs(idx+1, sum / arr[idx]);
            op[3] += 1;
        }
    }
}
