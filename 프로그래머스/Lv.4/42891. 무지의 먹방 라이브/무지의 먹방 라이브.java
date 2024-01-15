import java.util.*;

class Solution {
    static PriorityQueue<Integer> cost = new PriorityQueue<>();
    // static List<Integer> list = new ArrayList<>();
    static int[] list;
    static int maxRemoved = 0;
    static int pos = 0;
    public int solution(int[] food_times, long k) {
        for (int ele: food_times) {
            cost.add(ele);
        }
        
        while (true) {
            if (cost.size() == 0 || k == 0) {
                break;
            }
            
            int front = cost.peek() - maxRemoved;
            if (k < ((long) front) * cost.size()) {
                break;
            }
            
            maxRemoved = cost.peek();
            k -= ((long)front) * cost.size();
            cost.poll();
        }
        
        int cnt = 0;
        for (int i=0; i < food_times.length; i++) {
            if (food_times[i] > maxRemoved) {
                // list.add(i+1);
                cnt++;
            }
        }
        
        list = new int[cnt];
        int tmp = 0;
        for (int i=0; i < food_times.length; i++) {
            if (food_times[i] > maxRemoved) {
                // list.add(i+1);
                list[tmp++] = i+1;
                // cnt++;
            }
        }
        
        if (list.length != 0) {
            long idx = k % ((long) list.length);
            pos = list[(int) idx];
        } else {
            return -1;
        }
        
        return pos;
    }
}