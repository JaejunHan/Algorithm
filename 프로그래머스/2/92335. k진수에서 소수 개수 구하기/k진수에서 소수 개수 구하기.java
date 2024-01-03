import java.util.*;
class Solution {
    
    public int solution(int n, int k) {
        int answer = 0;
        String[] tmp = toBaseNum(n, k).split("0+");
        for (String s: tmp) {
            if (s.equals("")) {
                continue;
            }
            long num = Long.parseLong(s);
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }
    
    private static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        for (long i=2; i*i <= n; i++) {
            if (n % i == 0) { // 나눠지면
                return false;
            }
        }
        return true;
    }
    
    private static String toBaseNum(int n, int k) {
        String ret = "";
        
        while (n != 0) {
            int remain = n % k;
            ret = remain + ret;
            n /= k;
        }
        
        return ret;
    }
}