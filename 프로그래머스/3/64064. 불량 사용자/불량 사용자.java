import java.util.*;

class Solution {
    static boolean[] visited;
    static HashSet<String> set= new HashSet<>();
    static String[] userId;
    static String[] bannedId;
    public int solution(String[] ui, String[] bi) {
        userId = ui;
        bannedId = bi;
        visited = new boolean[ui.length];
        
        //정규식표현을 위해 '*'를 '.'로 바꾼다.
        //정규식표현에서 '.'은 해당 위치의 모든 문자를 대변한다.
        for (int i=0; i < bannedId.length; i++) {
            bannedId[i] = bannedId[i].replace('*', '.');
        }
        
        perm(0, "");
        int answer = 0;
        return set.size();
    }
    
    public void perm(int depth, String str) {
        if (depth == bannedId.length) {
            String[] arr = str.split(" ");
            Arrays.sort(arr);
            
            String tmp = "";
            for (String s: arr) {
                tmp += s;
            }
            set.add(tmp);
            return;
        }
        
        for (int i=0; i < userId.length; i++) {
            if (visited[i] || !userId[i].matches(bannedId[depth])) continue;
            visited[i] = true;
            perm(depth+1, str + " " + userId[i]);
            visited[i] = false;
        }
    }
}