import java.io.*;
import java.util.*;

class Solution {
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();
    static long ans = 0;
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        init(deliveries, pickups);
        
        // 둘 중 하나라도 비어 있지 않으면 계속 진행됨
        while (!s1.isEmpty() || !s2.isEmpty()) {
            // 0인 값들을 제거함.
            removeZeros();            
            int dist = Math.max(s1.size(), s2.size());
            removeCap(cap);
            ans += dist * 2;
        }
        return ans;
    }
    
    private void removeCap(int cap) {
        int tmp = cap;
        while (!s1.isEmpty()) {
            int top = s1.peek();
            if (cap > top) {
                cap -= top;
                s1.pop();
            } else {
                s1.pop();
                s1.push(top - cap);
                break;
            }
        }
        cap = tmp;
        
        while (!s2.isEmpty()) {
            int top = s2.peek();
            if (cap > top) {
                cap -= top;
                s2.pop();
            } else {
                s2.pop();
                s2.push(top - cap);
                break;
            }
        }
    }
    
    
    private void removeZeros() {
        while (!s1.isEmpty() && s1.peek() == 0) {
            s1.pop();
        }
        
        while (!s2.isEmpty() && s2.peek() == 0) {
            s2.pop();
        }
    }
    
    private void init(int[] dl, int[] pu) {
        for (int ele: dl) {
            s1.push(ele);
        }
        
        for (int ele: pu) {
            s2.push(ele);
        }
        return;
    }
}