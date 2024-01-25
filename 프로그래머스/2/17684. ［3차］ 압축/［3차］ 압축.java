import java.util.*;

class Solution {
    static HashMap<String, Integer> mp = new HashMap<>();
    static int cnt = 27;
    static List<Integer> list = new ArrayList<>();
    
    public int[] solution(String msg) {
        init();
        StringBuilder sb = new StringBuilder();
        
        
        while (msg.length() != 0) {
            String str = getLongStr(msg);
            msg = msg.substring(str.length());
            
            if (msg.length() != 0) {
                str += msg.charAt(0);
            }
            
            if (!mp.containsKey(msg)) {
                mp.put(str, cnt++);
            }
        }
        
        int[] ans = new int[list.size()];
        for (int i=0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
    
    private String getLongStr(String s) {
        for (int i= s.length(); i > 0; i--) {
            String sub = s.substring(0, i);
            if (mp.containsKey(sub)) { // 포함하면
                list.add(mp.get(sub));
                return sub;
            }
        }
        
        return "";
    }
    
    private void init() {
        for (int i=0; i < 26; i++) {
            char ch = (char) ('A' + i);
            mp.put(Character.toString(ch), i+1);
        }
    }
}