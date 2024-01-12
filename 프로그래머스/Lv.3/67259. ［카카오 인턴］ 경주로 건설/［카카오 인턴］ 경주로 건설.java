import java.util.*;
class Solution {
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][][] visited;
    
    public int solution(int[][] board) {
        int n = board.length;
        visited = new int[n][n][4];
        for (int i=0; i < n; i++) {
            for (int j=0; j<n;j++) {
                for (int k=0;k < 4; k++) {
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, -1, 0));
        
        while (!q.isEmpty()) {
            Node f = q.poll();
            int x = f.x;
            int y = f.y;
            int dir = f.dir;
            int cost = f.cost;
            
            if (x == n-1 && y == n-1) {
                ans = Math.min(ans, cost);
            }
            
            for (int i=0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) continue;
                
                int nxtcost = cost;
                if (dir == -1) {
                    nxtcost += 100;
                } else if (dir == i) {
                    nxtcost += 100;
                } else {
                    nxtcost += 600;
                }
                
                if (visited[nx][ny][i] >= nxtcost) {
                    visited[nx][ny][i] = nxtcost;
                    q.add(new Node(nx, ny, i, nxtcost));
                }
            }
        }
        
        
        return ans;
    }
    
    public class Node {
        int x; int y; int dir; int cost;
        public Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
}