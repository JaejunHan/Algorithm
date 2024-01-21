import java.util.*;

class Solution {
    static ArrayList<String> arr = new ArrayList<>();
    
    public int solution(int cacheSize, String[] cities) {
        int ans = 0;
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        
        for (String city: cities) {
            city = city.toLowerCase();
            if (arr.contains(city)) {
                arr.remove(city);
                arr.add(city);
                ans += 1;
            } else {
                if (arr.size() == cacheSize) {
                    arr.remove(0);
                }
                arr.add(city);
                ans += 5;
            }
        }
        
        return ans;
    }
}