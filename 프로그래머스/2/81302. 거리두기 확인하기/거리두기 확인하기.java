import java.util.*;
class Solution {
    static char[][] board;
    static ArrayList<Node> sit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    private static class Node {
        int x; int y; int cnt;
        public Node(int x, int y, int cnt) {
            this.x = x; this.y =y; this.cnt = cnt;
        }
    }
    
    public int[] solution(String[][] places) {
        int[] ans = new int[5];
        int a = 0;
        for (String[] place: places) {
            // System.out.println("start");
            board = new char[5][5];
            sit = new ArrayList<>();
            for (int i=0; i < 5; i++) {
                String ele = place[i];
                for (int j=0; j < 5; j++) {
                    board[i][j] = ele.charAt(j);
                    if (board[i][j] == 'P') {
                        sit.add(new Node(i, j, 0));
                    }
                }
            }
            
            boolean able = true;
            for (int i=0; i< sit.size(); i++) {
                Node node = sit.get(i);
                // System.out.println("x = " + node.x + "y = " + node.y);
                if (!bfs(node)) {
                    able = false;
                    break;
                }
            }
            
            if (able) {
                ans[a++] = 1;
            } else {
                ans[a++] = 0;
            }
        }
        
        return ans;
    }
    
    private static boolean bfs(Node src) {
        boolean[][] visited = new boolean[5][5];
        
        Queue<Node> q = new ArrayDeque<>();
        q.add(src);
        visited[src.x][src.y] = true;
        
        while (!q.isEmpty()) {
            Node f = q.poll();
            int x = f.x;
            int y = f.y;
            int cnt = f.cnt;
            // System.out.println("x = " + x + ", y = " + y + ", cnt = " + cnt);
            
            for (int i=0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || visited[nx][ny] || board[nx][ny] == 'X') {
                    continue;
                }
                
                if (board[nx][ny] == 'P' && cnt + 1 <= 2) {
                    return false;
                }
                
                visited[nx][ny] = true;
                q.add(new Node(nx, ny, cnt + 1));
            }
        }
        
        return true;
    }
}