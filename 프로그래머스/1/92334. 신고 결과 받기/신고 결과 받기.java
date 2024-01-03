import java.util.*;

class Solution {
    static Map<String, Integer> idToNum = new HashMap<>();
    static Map<String, Set<String>> mp = new HashMap<>();
    static int[] ans;
    public int[] solution(String[] id_list, String[] report, int k) {
        ans = new int[id_list.length];
        for (int i=0; i< id_list.length; i++) {
            idToNum.put(id_list[i], i);
            Set<String> tmp = new HashSet<>();
            mp.put(id_list[i], tmp);
        }
        
        for (String s: report) {
            String[] tmp = s.split(" ");
            String from = tmp[0];
            String to = tmp[1];
            
            mp.get(to).add(from);
        }
        
        mp.forEach((key, value) -> {
            if (value.size() >= k) {
                for (String s: value) {
                    ans[idToNum.get(s)]++;
                }
            }
        });
        
        return ans;
    }
}