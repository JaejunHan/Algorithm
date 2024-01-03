class Solution {
    static int n;
    static int[] info;
    static int[] ret = new int[11];
    static int[] ans = {-1};
    static int maxDiff = 0;
    
    public int[] solution(int n1, int[] info1) {
        n = n1;
        info = info1;
        
        backTrack(0, 0);
        if (maxDiff == 0) {
            ans = new int[1];
            ans[0] = -1;
        }
        
        return ans;
    }
    
    private static void backTrack(int depth, int start) {
        if (depth == n) {
            int score = getScore();
            if (score <= 0) {
                return;
            }
            if (score > maxDiff) {
                maxDiff = score;
                ans = ret.clone();
            } else if (score == maxDiff) {
                for (int i=10; i >= 0; i--) {
                    if (ans[i] < ret[i]) {
                        ans = ret.clone();
                        break;
                    } else if (ans[i] > ret[i]) {
                        break;
                    }
                }
            }
            return;
        }
        
        for (int i=start; i< info.length; i++) {
            ret[i]++;
            backTrack(depth+1, i);
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