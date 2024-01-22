import java.util.*;

class Solution {
    static Map<String, Integer> mp1 = new HashMap<>();
    static Map<String, Integer> mp2 = new HashMap<>();
    static Map<String, Integer> union = new HashMap<>();
    static Map<String, Integer> intersect = new HashMap<>();
    static int n1 = 0, n2 = 0;
    
    public int solution(String str1, String str2) {
        strToMap(str1, mp1);
        strToMap(str2, mp2);
        
        if (mp1.size() == 0 && mp2.size() == 0) {
            return 65536;
        }
        
        mp1.forEach((key, value) -> {
            // System.out.println(key);
            int min = value;
            int max = value;
            if (mp2.containsKey(key)) {
                min = Math.min(min, mp2.get(key));
                max = Math.max(max, mp2.get(key));
                intersect.put(key, min);
                union.put(key, max);
            } else {
                union.put(key, max);
            }
        });
        
        mp2.forEach((key, value) -> {
            if (!mp1.containsKey(key)) {
                union.put(key, value);
            }
        });
        
        
        union.forEach((key, value) -> {
            n1 += value;
        });
        
        System.out.println("22222");
        intersect.forEach((key, value) -> {
            n2 += value;
        });

        int ans = (int) Math.floor(((float) n2 / n1) * 65536);
        return ans;
    }
    
    private void strToMap(String str, Map<String, Integer> map) {
        for (int i=0; i < str.length() - 1; i++) {
            if (!Character.isAlphabetic(str.charAt(i)) || !Character.isAlphabetic(str.charAt(i+1))) {
                continue;
            }
            
            String sub = str.substring(i, i+2).toLowerCase();
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }
    }
}