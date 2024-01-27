import java.util.*;

class Solution {
    static int max = 0;
    static ArrayList<Integer>[] adj;
    static ArrayList<Integer>[] adj2;
    static int cnt = 0;
    static int a, b, c;
    
    public int[] solution(int[][] edges) {
        
        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            max = Math.max(max, from);
            max = Math.max(max, to);
        }
        adj = new ArrayList[max+1];
        adj2 = new ArrayList[max+1];
        
        for (int i=1; i <= max; i++) {
            adj[i] = new ArrayList<Integer>();
            adj2[i] = new ArrayList<Integer>();
        }
        
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adj[from].add(to);
            adj2[to].add(from);
        }
        
        int start = 0;
        for (int i=1; i <= max; i++) {
            if (adj2[i].size() == 0 && adj[i].size() >= 2) {
                start = i;
                break;
            }
        }
        
        cnt = adj[start].size();
        for (int i=0; i < adj[start].size(); i++) {
            int to = adj[start].get(i);
            adj2[to].remove((Integer) start);
        }
        
        for (int i=1; i <= max; i++) {
            if (adj2[i].size() == 2 && adj[i].size() == 2) {
                c++;
            } else if (adj[i].size() == 0) {
                b++;
            }
        }
        a = cnt - c - b;
        
        int[] answer = {start, a, b, c};
        return answer;
    }
}