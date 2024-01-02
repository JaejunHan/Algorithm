class Solution {
    static int n;
    static int[] info;
    static int[] ret = new int[11];
    static int[] ans = {-1};
    static int maxDiff = 0;
    
    public int[] solution(int n1, int[] info1) {
        n = n1;
        info = info1;
        
        backTrack(0);
        if (maxDiff == 0) {
            ans = new int[1];
            ans[0] = -1;
        }
        
        return ans;
    }
    
    private static void backTrack(int depth) {
        if (depth == n) {
            int score = getScore();
            if (score >= maxDiff) {
                maxDiff = score;
                ans = ret.clone();
            }
            return;
        }
        
        for (int i=0; i< info.length; i++) {
            if (ret[i] > info[i]) {
                return;
            }
            ret[i]++;
            backTrack(depth+1);
            ret[i]--;
        }
    }
    
    private static int getScore() {
        int s1 = 0;
        int s2 = 0;
        for (int i=0; i< 11; i++) {
            if (info[i] < ret[i]) {
                s2 += 10-i;
            } else if (info[i] != 0) {
                s1 += 10-i;
            }
        }
        
        return s2-s1;
    }
}