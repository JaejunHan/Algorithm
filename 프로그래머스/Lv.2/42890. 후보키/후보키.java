import java.util.*;

class Solution {
    static boolean[] visited;
    static int col, row;
    static int ans = 0;
    static String[][] Relation;
    static Set<String> used = new HashSet<>();
    public int solution(String[][] relation) {
        Relation = relation;
        col = relation[0].length;
        row = relation.length;
        
        for (int i=1; i <= 8; i++) {
            visited = new boolean[col];
            comb(0, 0, i);
        }
        
        return ans;
    }
    
    public void comb(int curr, int start, int depth) {
        if (curr == depth) {
            if (check()) {
                StringBuilder sb = new StringBuilder();
                for (int i=0; i < visited.length; i++) {
                    if (visited[i]) sb.append(i);
                }
                used.add(sb.toString());
                ans++;
            }
            return;
        }
        
        for (int i=start; i < col; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(curr+1, i, depth);
                visited[i] = false;
            }
        }
    }
    
    public boolean isContains(String str) {
        for (String s: used) {
            boolean tmp = true;
            for (int i=0; i<s.length(); i++) {
                String ch = s.charAt(i)+"";
                if (!str.contains(ch)) {
                    tmp = false;
                }
            }
            
            if (tmp) {
                return true;
            }
        }
        return false;
    }
    
    public boolean check() {
        String str = "";
        for (int i=0; i < visited.length; i++) {
           if (visited[i]) str += i; 
        }
        
        if (isContains(str)) { // 최소성에 위배
            return false;
        }
        
        Set<String> set = new HashSet<>();
        for (String[] r: Relation) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i < visited.length; i++) {
                if (visited[i]) {
                    sb.append(r[i]);
                }
            }
            String tmp = sb.toString();
            if (set.contains(tmp)) return false;
            set.add(tmp);
        }
        
        return true;
    }
}