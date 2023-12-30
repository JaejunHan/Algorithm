import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class B1182 {
    public static int n;
    public static int s;
    public static int[] arr;
    public static int res;

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        res = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i=1; i < (1<<n); i++) {
            sum = 0;

            for (int j=0; j < n; j++) {
                if ((i & (1<<j)) != 0) {
                    sum += arr[j];
                }
            }

            if (sum == s) {
                res++;
            }
        }

        System.out.println(res);
    }
}
