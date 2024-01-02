import java.util.*;

class Solution {
    static List[] adj;
    static int[] type;
    static int ans = 0;
    public int solution(int[] info, int[][] edges) {
        type = info;
        int n = info.length;
        adj = new ArrayList[n];
        for (int i=0; i< n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        
        for (int[] e: edges) {
            int from = e[0];
            int to = e[1];
            adj[from].add(to);
        }
        
        Set<Integer> possible = new HashSet<>();
        
        List<Integer> tmp = adj[0];
        for (int i=0; i< tmp.size(); i++) {        
            possible.add(tmp.get(i));
        }
        
        dfs(possible, 1, 0);
        
        return ans;
    }
    
    private static void dfs(Set<Integer> possible, int cnt1, int cnt2) {
        if (possible.size() == 0 || cnt1 == cnt2) {
            ans = Math.max(ans, cnt1);
            return;
        }
        
        
        for (int ele: possible) {
            
            Set<Integer> tmp = new HashSet<>();
            for (int ele2: possible) {
                tmp.add(ele2);
            }
            
            tmp.remove(ele);
            
            List<Integer> nxt = adj[ele];
            for (int j=0; j< nxt.size(); j++) {
                tmp.add(nxt.get(j));
            }
            
            if (type[ele] == 0) {
                dfs(tmp, cnt1+1, cnt2);
            } else {
                dfs(tmp, cnt1, cnt2+1);
            }
            
        }
    }
    
}