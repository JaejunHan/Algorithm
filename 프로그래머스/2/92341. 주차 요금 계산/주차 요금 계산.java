import java.util.*;

class Solution {
    static Map<String, Integer> mp = new TreeMap<>();
    static Map<String, Integer> timeMap = new HashMap<>();
    static int[] ans;
    
    public int[] solution(int[] fees, String[] records) {
        
        for (String r: records) {
            String[] tmp = r.split(" ");
            int time = getTime(tmp[0]);
            String car = tmp[1];
            
            if (timeMap.containsKey(car)) { // 출차인 경우
                int inTime = timeMap.get(car);
                timeMap.remove(car);
                
                mp.put(car, mp.getOrDefault(car, 0) + time - inTime);
                
            } else { // 입차인 경우
                timeMap.put(car, time);
            }
        }
        
        int endTime = getTime("23:59");
        timeMap.forEach((key, value) -> {
            mp.put(key, mp.getOrDefault(key, 0) + endTime - value);
        });
        int[] ans = new int[mp.size()];
        
        int i=0;
        for (String car: mp.keySet()) {
            int totalTime = mp.get(car);
            
            if (totalTime <= fees[0]) {
                ans[i++] = fees[1];
            } else {
                int temp = (totalTime - fees[0]) / fees[2];
                if ((totalTime - fees[0]) % fees[2] != 0) {
                    temp++;
                }
                ans[i++] = fees[1] + temp * fees[3];
            }
            // ans[i++] = 
        }
        
        return ans;
    }
    
    
    private static int getTime(String s) {
        int ret = 0;
        String[] tmp = s.split(":");
        ret += Integer.parseInt(tmp[0]) * 60;
        ret += Integer.parseInt(tmp[1]);
        
        return ret;
    }
}