import java.util.*;

class Solution {
    static boolean[][] erase;
    static int[] cnt;
    static char[][] arr;
    static int ans = 0;
    static int m, n;
    public int solution(int M, int N, String[] board) {
        m = M; n = N;
        arr = new char[m][n];
        
        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                arr[i][j] = board[i].charAt(j);
            }
        }
        
        
        while (true) {
            cnt = new int[n];
            erase = new boolean[m][n];
            
            boolean tmp = false;
            for (int i=0; i < m-1; i++) {
                for (int j=0; j < n-1; j++) {
                    if (canErase(i, j)) {
                        tmp = true;
                    }
                }
            }
            
            doErase();
            
            if (!tmp) {
                break;
            }
        }
        
        return ans;
    }
    
    public void doErase() {
        char[][] tmp = new char[arr.length][arr[0].length];
        for (int j=0; j < n; j++) {
            Queue<Character> q = new ArrayDeque<>();
            for (int i=m-1; i >= 0; i--) {
                if (!erase[i][j]) {
                    q.add(arr[i][j]);
                } else {
                    ans++;
                }
            }
            
            for (int i=m-1; i >= 0; i--) {
                if (!q.isEmpty()) {
                    char f = q.poll();
                    tmp[i][j] = f;
                } else {
                    tmp[i][j] = '#';   
                }
            }
        }
        
        arr = tmp.clone();
    }
    
    public boolean canErase(int i, int j) {
        char ch = arr[i][j];
        if (ch == '#') {
            return false;
        }
        
        if (arr[i+1][j] == ch && arr[i][j+1] == ch && arr[i+1][j+1] == ch) {
            erase[i][j] = true;
            erase[i+1][j] = true;
            erase[i][j+1] = true;
            erase[i+1][j+1] = true;
            
            cnt[j] += 2;
            cnt[j+1] += 2;
            return true;
        }
        
        return false;
    }
}