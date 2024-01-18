import java.util.*;
class Solution {
    static ArrayList<Integer>[] arr;
    static Set<Integer> set = new LinkedHashSet<>();
    public int[] solution(String s) {
        String tmp = s.substring(2, s.length()-2);
        String[] eleList = tmp.split("\\},\\{");
        
        arr = new ArrayList[eleList.length+1];
        for (int i=0; i <= eleList.length; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        
        for (String ele: eleList) {
            String[] temp = ele.split("\\,");
            
            for (String str: temp) {
                arr[temp.length].add(Integer.parseInt(str));
            }
        }
        
        for (int i=1; i < arr.length; i++) {
            for (int ele: arr[i]) {
                if (set.contains(ele)) continue;
                set.add(ele);
            }
        }
        
        int[] ans = new int[set.size()];
        int idx = 0;
        for (int ele: set) {
            ans[idx++] = ele;
        }
        return ans;
    }
}