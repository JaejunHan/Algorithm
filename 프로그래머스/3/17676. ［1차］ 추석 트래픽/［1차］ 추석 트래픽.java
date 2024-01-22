import java.util.*;

class Solution {
    static Queue<Node> q = new PriorityQueue<>();
    public int solution(String[] lines) {
        for (String line: lines) {
            String[] tmp = line.split(" ");
            String endStr = tmp[1];
            int endTime = 0;
            String[] tmp2 = endStr.split("\\:");
            endTime += Integer.parseInt(tmp2[0]) * 3600 * 1000;
            endTime += Integer.parseInt(tmp2[1]) * 60 * 1000;
            endTime += (int) (Double.parseDouble(tmp2[2]) * 1000);
            
            String durateStr = tmp[2].substring(0, tmp[2].length() - 1);
            
            int duration = (int) (Double.parseDouble(durateStr) * 1000);
            
            int startTime = endTime - duration + 1;
            q.add(new Node(startTime, true));
            q.add(new Node(endTime + 999, false));
        }
        
        int ans = 0;
        int cnt = 0;
        while (!q.isEmpty()) {
            Node f = q.poll();
            if (f.isStart) {
                cnt++;
                ans = Math.max(ans, cnt);
            } else {
                cnt--;
            }
        }
        return ans;
    }
    
    public class Node implements Comparable<Node>{
        int time; boolean isStart;
        public Node (int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
        
        @Override
        public int compareTo(Node o) {
            if (this.time != o.time) {
                return this.time - o.time;
            } else {
                return Boolean.compare(o.isStart, this.isStart);
            }
        }
    }
}