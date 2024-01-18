import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int start = 0;
        int end = Integer.MAX_VALUE;
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (check(mid, k, stones)) {
                start = mid + 1;
                // result = mid;
            } else {
                end = mid - 1;
            }
        }
        return start-1;
    }
    
    public boolean check(int mid, int k, int[] stones) {
        int cnt = 0;
        for (int i=0; i < stones.length; i++) {
            if (stones[i] < mid) {
                cnt++;
                if (cnt >= k) {
                    return false;
                }
            } else {
                cnt = 0;
            }
        }
        
        return true;
    }
}