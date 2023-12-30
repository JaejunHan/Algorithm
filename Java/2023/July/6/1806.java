import java.io.*;
import java.util.*;

class B1806 {
    
    static int n, s;
    static int[] arr;
    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        arr = new int[n];
        
        for (int i=0; i< n; i++) {
            arr[i] = sc.nextInt();
        }

        int start = 0, end = 0, total = 0;
        while (true) {
            if (total >= s) {
                MIN = Math.min(MIN, end - start);
                total -= arr[start++];
            } else if (end == n) {
                break;
            } else {
                total += arr[end++];
            }
        }
        if (MIN == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(MIN);
        }
    }
}
