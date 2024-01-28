import java.util.*;

class Solution {
    static int[] pair;
    static boolean[] used;
    static int n;
    static int coin;
    static int[] cards;
    
    public int solution(int coin, int[] cards) {
        this.n = cards.length;
        this.coin = coin;
        this.cards = cards;
        
        pair = new int[n];
        Arrays.fill(pair, -1);
        used = new boolean[n];
        
        findPairs();
        
        int cnt = 0;
        for (int i=n/3; i <= n; i += 2) {
            cnt++;
            if (i ==  n) break;
            if (!check(i)) break;
        }
        return cnt;
    }
    
    private boolean check(int k) {
        for (int i=0; i < n/3; i++) {
            if (!used[i] && pair[i] < n /3) {
                int p = pair[i];
                used[p] = true;
                used[i] = true;
                return true;
            }
        }
        
        for (int i=0; i < n/3; i++) {
            if (!used[i] && pair[i] <= k + 1) {
                if (coin < 1) break;
                int p = pair[i];
                used[p] = true;
                used[i] = true;
                coin--;
                return true;
            }
        }
        
        for (int i=n/3; i <= k+1; i++) {
            if (!used[i] && pair[i] <= k+1) {
                if (coin < 2) break;
                int p = pair[i];
                used[p] = true;
                used[i] = true;
                coin -= 2;
                return true;
            }
        }
        
        return false;
    }
    
    private void findPairs() {
        for (int i=0; i < n; i++) {
            if (pair[i] != -1) continue;
            
            for (int j=0; j < n; j++) {
                if (pair[j] != -1) continue;
                if (cards[i] + cards[j] == n+1) {
                    pair[i] = j;
                    pair[j] = i;
                    break;
                }
            }
        }
    }
}