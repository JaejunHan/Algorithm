import java.util.*;

class Solution {
    static Queue<Node> q = new PriorityQueue<>();
    static int[] cntList;
    static int[] sumList;
    public int[] solution(int N, int[] stages) {
        cntList = new int[N+2];
        sumList = new int[N+2];
        for (int s: stages) {
            cntList[s] += 1;
            sumList[s] += 1;
        }
        
        for (int i= N; i > 0; i--) {
            sumList[i] += sumList[i+1];
        }
        
        for (int i=1; i <= N; i++) {
            double ratio = 0.0;
            if (sumList[i] != 0) ratio = ((double) cntList[i]) / sumList[i];
            
            q.add(new Node(i, ratio));
        }
        
        int[] ans = new int[N];
        int idx = 0;
        while (!q.isEmpty()) {
            Node f = q.poll();
            ans[idx++] = f.x;
        }
        return ans;
    }
    
    public class Node implements Comparable<Node>{
        int x; double r;
        public Node(int x, double r) {
            this.x = x;
            this.r = r;
        }
        
        @Override
        public int compareTo(Node o) {
            if (this.r < o.r) {
                return 1;
            } else if (this.r > o.r) {
                return -1;
            } else {
                return this.x - o.x;
            }
        }
    }
}