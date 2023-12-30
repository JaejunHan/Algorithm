import java.util.*;
class Solution {
    static ArrayDeque<Integer> q1 = new ArrayDeque<>();
    static ArrayDeque<Integer> q2 = new ArrayDeque<>();
    static int ans = 0;
    public int solution(int[] queue1, int[] queue2) {
    long s1 = 0;
        for (int ele: queue1) {
            q1.add(ele);
            s1 += ele;
        }

        long s2 = 0;
        for (int ele: queue2) {
            q2.add(ele);
            s2 += ele;
        }

        long sum = s1 + s2;
        if (sum % 2 != 0) {
            return -1;
        }

        int i = 0;
        int j = 0;
        int t = queue1.length;

        while (true) {
            if (s1 == s2) {
                return ans;
            }
            ans++;
            int n = 0;
            if (s1 < s2) {
                n = q2.pollFirst();
                q1.add(n);
                s2 -= n;
                s1 += n;
                j++;
            } else {
                n = q1.pollFirst();
                q2.add(n);
                s1 -= n;
                s2 += n;
                i++;
            }
            if (i >= 2 * t || j >= 2 * t) {
                return -1;
            }
        }
    }
}