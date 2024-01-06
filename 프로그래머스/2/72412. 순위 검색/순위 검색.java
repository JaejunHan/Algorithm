import java.util.*;

class Solution {
    static Map<String, List<Integer>> mp = new HashMap<>();
    static int[] ans;    
    public int[] solution(String[] info, String[] query) {
        ans = new int[query.length];
        
        for (String ele: info) {
            String[] tmp = ele.split(" ");
            makeSentence(0, tmp, "");    
        }
        
        mp.forEach((key, value) -> {
            Collections.sort(value);
        });
        
        int i=0;
        for (String q: query) {
            String[] tmp = q.replaceAll(" and ", "").split(" ");
            String cond = tmp[0];
            int num = Integer.parseInt(tmp[1]);
            
            if (mp.containsKey(cond)) {
                ans[i] = binarySearch(cond, num);
            }
            i++;
        }
        
        return ans;
    }
    
    private static int binarySearch(String cond, int num) {
        List<Integer> list = mp.get(cond);
        int start = 0, end = list.size()-1, mid = (start + end) / 2;
        
        while (start <= end) {
            mid = (start+end) / 2;
            if (list.get(mid) < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return list.size() - start;
    }
    
    private static void makeSentence(int depth, String[] p, String str) {
        if (depth == 4) {
            List<Integer> list = mp.getOrDefault(str, new ArrayList<Integer>());
            list.add(Integer.parseInt(p[4]));
            mp.put(str, list);
            return;
        }
        
        makeSentence(depth+1, p, str + p[depth]);
        makeSentence(depth+1, p, str + "-");
    }
}