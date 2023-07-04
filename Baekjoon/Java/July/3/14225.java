import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

class B14225 {
    static int size;
    static int[] arr;
    static boolean[] visited = new boolean[20*100000+10];
    static int answer = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        arr = new int[size];

        for (int i=0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        while (visited[answer]) {
            answer++;
        }
        System.out.println(answer);

    }

    public static void dfs(int idx, int sum) {
        if (idx == size) {
            visited[sum] = true;
        } else {
            dfs(idx+1, sum+arr[idx]);
            dfs(idx+1, sum);
        }
    }
}
