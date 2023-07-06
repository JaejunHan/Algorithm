import java.io.*;
import java.util.*;

class B2529 {
    static int n;
    static boolean[] visited = new boolean[10];
    static char[] arr;
    static int[] res;
    static long MAX = Long.MIN_VALUE, MIN = Long.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new char[n];
        res = new int[n+1];

        for (int i=0; i < n; i++) {
            arr[i] = sc.next().charAt(0);
        }

        for (int i=0; i <= 9; i++) {
            visited[i] = true;
            res[0] = i;
            dfs(0, i);
            res[0] = 0;
            visited[i] = false;
        }
        
        if (MAX / (long) Math.pow(10, n) == 0) {
            System.out.print('0');
        }
        System.out.println(MAX);
        if (MIN / (long) Math.pow(10, n) == 0) {
            System.out.print('0');
        }
        System.out.println(MIN);
    }

    public static void dfs(int idx, int num) {
        if (idx == n) {
            long sum = 0;
            for (int i=n; i>=0; i--) {
                sum += ((long) res[i]) * ((long) Math.pow(10, n-i));
            }
            MAX = Math.max(sum, MAX);
            MIN = Math.min(MIN, sum);
            return;
        }

        for (int i=0; i <=9 ; i++) {    
            if (arr[idx] == '<' && res[idx] < i && !visited[i]) {
                visited[i] = true;
                res[idx+1] = i;
                dfs(idx+1, i);
                res[idx+1] = 0;
                visited[i] = false;
            } else if (arr[idx] == '>' && res[idx] > i && !visited[i]) {
                visited[i] = true;
                res[idx+1] = i;
                dfs(idx+1, i);
                res[idx+1] = 0;
                visited[i] = false;
            }
        }
    }
}