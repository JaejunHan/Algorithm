import java.util.*;
class Solution {
    static int[] distA;
    static int[] distB;
    static int A, B, start;
    static ArrayList[] adj;
    static int MAX = Integer.MAX_VALUE;
    static boolean[] visited;
    static boolean findA = false, findB = false;
    static int totalDist = 0;
    
    public static class Node implements Comparable<Node>{
        int x;
        int cost;
        
        public Node(int x, int cost) {
            this.x =x;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    public int solution(int n, int s, int a1, int b1, int[][] fares) {
        visited = new boolean[n+1];
        distA = new int[n+1];
        distB = new int[n+1];
        Arrays.fill(distA, Integer.MAX_VALUE);
        Arrays.fill(distB, Integer.MAX_VALUE);
        distA[a1] = 0;
        distB[b1] = 0;
        adj = new ArrayList[n+1];
        for (int i=0; i<= n; i++) {
            adj[i] = new ArrayList<Node>();
        }
        start = s;
        A = a1;
        B = b1;
        
        for (int[] fare: fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];
            adj[from].add(new Node(to, cost));
            adj[to].add(new Node(from, cost));
        }
        
        
        for (int i=1; i<= n; i++) {
            int[] temp = new int[n+1];
            Arrays.fill(temp, Integer.MAX_VALUE);
            findA = false; findB = false;
            dijsktra(i, temp);
        }
        
        totalDist = distA[s] + distB[s];
        int[] temp = new int[n+1];
        Arrays.fill(temp, Integer.MAX_VALUE);
        dik(s, temp);
        // visited[s] = true;
        // dfs(s, totalDist, 0);
        // for(int i=1; i<=n; i++) {
        //     System.out.println(distA[i]);
        // }
        return totalDist;
    }
    
    private static void dik(int start, int[] temp) {
        Queue<Node> q = new PriorityQueue<>();
        temp[start] = 0;
        q.add(new Node(start, 0));
        
        while (!q.isEmpty()) {
            Node f = q.poll();
            int x = f.x;
            int cost = f.cost;
            int tc = distA[x] + distB[x] + cost;
            totalDist = Math.min(tc, totalDist);
            if (temp[x] < cost) { //  큰 값이면 pass
                continue;
            }
            
            ArrayList<Node> list = adj[x];
            for (int i=0; i< list.size(); i++) {
                Node node = list.get(i);
                int n_x = node.x;
                int nxt_cost = node.cost + cost;
                
                if (temp[n_x] <= nxt_cost) { // 크거나 같은 값이면 pass
                    continue;
                }
                
                temp[n_x] = nxt_cost;
                q.add(new Node(n_x, nxt_cost));
            }
        }
    }
    
    private static void dfs(int start, int dist, int edgeCost) {
        ArrayList<Node> list = adj[start];
        for (int i=0; i< list.size(); i++) {
            Node node = list.get(i);
            int x = node.x;
            int cost = node.cost + edgeCost + distA[x] + distB[x] ;
            if (!visited[x]) {
                totalDist = Math.min(totalDist, cost);
                visited[x] = true;
                dfs(x, cost, edgeCost + node.cost);
                visited[x] = false;
            }
        }
    }
    
    
    private static void dijsktra(int start, int[] temp) {
        
        Queue<Node> q = new PriorityQueue<>();
        temp[start] = 0;
        q.add(new Node(start, 0));
        
        while (!q.isEmpty()) {
            Node f = q.poll();
            int x = f.x;
            int cost = f.cost;
            if (temp[x] < cost) { //  큰 값이면 pass
                continue;
            }
            
            if (x == A) {
                distA[start] = cost;
                findA = true;
            } else if (x == B) {
                distB[start] = cost;
                findB = true;
            }
            if (findA && findB) {
                return;
            }
            
            ArrayList<Node> list = adj[x];
            for (int i=0; i< list.size(); i++) {
                Node node = list.get(i);
                int n_x = node.x;
                int nxt_cost = node.cost + cost;
                
                if (temp[n_x] <= nxt_cost) { // 크거나 같은 값이면 pass
                    continue;
                }
                
                temp[n_x] = nxt_cost;
                q.add(new Node(n_x, nxt_cost));
            }
        }
    }
}