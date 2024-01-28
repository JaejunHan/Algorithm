import java.util.*;

class Solution {
    static int[] a;
    static int[] b;
    public int solution(int n, int[] tops) {
        a = new int[n];
        b = new int[n];
        
        a[0] = 1;
        if (tops[0] == 1) {
            b[0] = 3;
        } else {
            b[0] = 2;
        }
        
        for (int i=1; i< n; i++) {
            if (tops[i] == 1) {
                a[i] = (a[i-1] + b[i-1]) % 10007;
                b[i] = (2 * a[i-1] + 3 * b[i-1]) % 10007;
            } else {
                a[i] = (a[i-1] + b[i-1]) % 10007;
                b[i] = (a[i-1] + 2 * b[i-1]) % 10007;
            }
        }
        
        return (a[n-1] + b[n-1]) % 10007;
    }
}