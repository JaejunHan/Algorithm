//https://jojaeng2.tistory.com/85
import java.util.*;
class Solution {
    static ArrayList[] adj;
    static boolean[] visited;
    static int[] type;
    static int intensity = Integer.MAX_VALUE;
    static int[] ret = new int[2];
    static int[] distance;
    static Queue<Node> pq = new PriorityQueue<>();
    
    public static class Node implements Comparable<Node> {
        int x;
        int cost;
        
        public Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        ret[1] = intensity;
        adj = new ArrayList[n+1];
        distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i=0; i< n+1; i++) {
            adj[i] = new ArrayList<Node>();
        }
        visited = new boolean[n+1];
        type = new int[n+1];
        
        for (int i: gates) {
            type[i] = 1;
        }
        
        for (int i: summits) {
            type[i] = 2;
        }
        
        for (int[] p: paths) {
            int i = p[0];
            int j = p[1];
            int cost = p[2];
            adj[i].add(new Node(j, cost));
            adj[j].add(new Node(i, cost));
        }
        
        for (int ele: gates) {
            pq.add(new Node(ele, 0));
            distance[ele] = 0;
        }
        
        dijkstra();
        
        int d = Integer.MAX_VALUE;
        int num = 0;
        for (int ele: summits) {
            if (distance[ele] < d) {
                num = ele;
                d = distance[ele];
            } else if (distance[ele] == d && ele < num) {
                
                num = ele;
                d = distance[ele];
            }
        }
        
        ret[0] = num;
        ret[1] = d;
        
        return ret;
    }
    
    private static void dijkstra() {
        while (!pq.isEmpty()) {
            Node f = pq.poll();
            int x = f.x;
            int cost = f.cost;
            
            if (cost > distance[x] || type[x] == 2) { // 거리 정보가 최신 값이 아니면 continue
                continue;
            }
            
            ArrayList<Node> a = adj[x];
            for (int i=0; i < a.size(); i++) {
                Node nxt = a.get(i);
                int num = nxt.x;
                int nxtCost = Math.max(cost, nxt.cost);
                
                if (nxtCost >= distance[num] || type[num] == 1) {
                    continue;
                }
                
                distance[num] = nxtCost;
                pq.add(new Node(num, nxtCost));
            }
        }
    }
    
    
    private static void dfs(int start, int curr, int inten) {
        ArrayList<Node> a = adj[curr];
        for (int i=0; i< a.size(); i++) {
            Node node = a.get(i);
            int nxt = node.x;
            int cost = Math.max(node.cost, inten);
            
            if (!visited[nxt]) {
                if (type[nxt] == 1) { // 출입구
                    continue;
                } else if (type[nxt] == 2 && cost <= intensity) { // 산봉우리
                    intensity = cost;
                    ret[0] = nxt;
                    ret[1] = intensity;
                    continue;
                } else { // 쉽터
                    visited[nxt] = true;
                    dfs(start, nxt, cost);
                    visited[nxt] = false;
                }
            }
        }
        
        
    }
}