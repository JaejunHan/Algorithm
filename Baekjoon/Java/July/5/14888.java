import java.io.*;
import java.util.*;

class B14888 {
    static int n;
    static int[] arr;
    static int[] op = new int[4];
    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        
        for (int i=0; i< n; i++) {
            arr[i] = sc.nextInt();
        } 

        for (int i=0; i< 4; i++) {
            op[i] = sc.nextInt();
        }

        dfs(1, arr[0]);

        System.out.println(MAX);
        System.out.println(MIN);

    }
    
    public static void dfs(int depth, int sum) {
        if (depth == n) {
            MIN = Math.min(MIN, sum);
            MAX = Math.max(MAX, sum);
            return;
        }

        for (int i=0; i< 4; i++) {
            if (op[i] != 0) {
                op[i] -= 1;
                switch (i) {
                    case 0:
                        dfs(depth+1, sum+arr[depth]);
                        break;
                    case 1:
                        dfs(depth+1, sum-arr[depth]);
                        break;
                    case 2:
                        dfs(depth+1, sum*arr[depth]);
                        break;
                    case 3:
                        dfs(depth+1, sum/arr[depth]);
                        break;
                }
                op[i] += 1;
            }
        }
    }


}