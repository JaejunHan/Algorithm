import java.util.*;

class Solution {
    static Queue<Integer> q1 = new ArrayDeque<>();
    static Queue<Integer> q2 = new ArrayDeque<>();
    static long sum1 = 0;
    static long sum2 = 0;
    static int t = 0;
    static int m = 0;
    static int ans = 0;
    public int solution(int[] queue1, int[] queue2) {
        init(queue1, queue2);
        m = queue1.length + queue2.length;
        
        int i = 0, j = 0;
        while (true) {
            if (i > m || j > m) {
                return -1;
            }
            
            if (sum1 > sum2) {
                int tmp = q1.poll();
                q2.add(tmp);
                sum2 += tmp;
                sum1 -= tmp;
                i++;
            } else if (sum1 < sum2) {
                int tmp = q2.poll();
                q1.add(tmp);
                sum1 += tmp;
                sum2 -= tmp;
                j++;
            } else {
                break;
            }
            ans++;
        }
        
        return ans;
    }
    
    private static void init(int[] queue1, int[] queue2) {
        for (int ele: queue1) {
            q1.add(ele);
            sum1 += ele;
        }
        
        for (int ele: queue2) {
            q2.add(ele);
            sum2 += ele;
        }
    }
}