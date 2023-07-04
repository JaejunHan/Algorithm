import java.util.Scanner;

class B9663 {

    static int n;
    static int[] arr;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        Queen(0);
        System.out.println(cnt);
    }

    public static void Queen(int depth) {
        if (depth == n) {
            cnt++;
            return;
        }

        for (int i=0; i< n; i++) {
            arr[depth] = i;      
            if (possible(depth)) {
                Queen(depth+1);
            }
        }
    }

    public static boolean possible(int depth) {
        for (int i=0; i< depth; i++) {
            if (arr[depth] == arr[i]) { // 행이 같을 경우
                return false;
            } else if (Math.abs(depth - i) == Math.abs(arr[depth]-arr[i])) { // 대각선에 있는 경우
                return false;
            }
        }
        
        return true;
    }
}