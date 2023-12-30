import java.util.*;
import java.io.*;
class Solution {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String[] sList = {"d", "l", "r", "u"};
    static String ans = null;
    static int n, m;
    static int dr, dc;
    static int len;
    static StringBuilder sb;
    public String solution(int sn, int sm, int sx, int sy, int r, int c, int k) {
        n = sn;
        m = sm;
        dr = r;
        dc = c;
        len = k;
        sb = new StringBuilder();
        int dist = distance(sx, sy, r, c);
        
        if ((k - dist % 2 == 1) || k < dist) {
            return "impossible";
        }
        
        dfs(sx, sy, 0);
        
        if (ans == null) {
            ans = "impossible";
        }
        return ans;
    }
    
    public int distance(int x, int y, int r, int c) {
        return Math.abs(x-r) + Math.abs(y-c);
    }
    
    public void dfs(int x, int y, int depth) {
        if (ans != null) {
            return;
        }
        int dist = distance(x, y, dr, dc);
        int remain = len - depth;
        if (dist > remain || (remain - dist) % 2 == 1) {
            return;
        }
        
        if (depth == len) {
            if (x == dr && y == dc) {
                String s = sb.toString();
                if (ans == null) {
                    ans = s;
                } else if (ans.compareTo(s) > 0) {
                    ans = s;
                }
            }
            return;
        }
        for (int i=0; i< 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 1 || ny < 1 || nx > n || ny > m) {
                continue;
            }
            sb.append(sList[i]);
            dfs(nx, ny, depth+1);
            sb.delete(depth, depth+1);
        }
        
    }
}