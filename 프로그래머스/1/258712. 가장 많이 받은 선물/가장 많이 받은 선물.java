import java.util.*;

class Solution {
    static HashMap<String, Integer> idxMp = new HashMap<>();
    static HashMap<Integer, Integer> presentIdx = new HashMap<>();
    static int[][] arr;
    static int ans = 0;
    
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        arr = new int[n][n];
        
        for (int i=0; i < friends.length; i++) {
            idxMp.put(friends[i], i);
        }
        
        for (String gift : gifts) {
            String[] tmp = gift.split(" ");
            int from = idxMp.get(tmp[0]);
            int to = idxMp.get(tmp[1]);
            arr[from][to]++;
        }
        
        for (int i=0; i < n; i++) {
            int give = 0;
            int take = 0;
            for (int j=0; j < n; j++) {
                if (i != j) {
                    give += arr[i][j];
                    take += arr[j][i];
                }
            }
            presentIdx.put(i, give - take);
        }
        
        for (int i=0; i < n; i++) {
            int cnt = 0;
            for (int j=0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                
                if (arr[i][j] > arr[j][i]) { // 준게 받은 것보다 크면
                    cnt++;
                } else if (arr[i][j] == arr[j][i] && presentIdx.get(i) > presentIdx.get(j)) {
                    cnt++;
                }
            }
            
            ans = Math.max(ans, cnt);
        }
        
        return ans;
    }
}