import java.util.*;

class Solution {
    static int allRemoved = 1;
    static int[][] arr;
    static int N, M;
    static Map<Integer, ArrayList<Node>> mp = new HashMap<>();
    static int minCnt = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public static class Node {
        int x; int y; int cnt;
        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public int solution(int[][] board, int r, int c) {
        arr = board;
        N = board.length;
        M = board[0].length;
        
        for (int i=0; i< N; i++) {
            for (int j=0; j< M; j++) {
                int num = board[i][j];
                if (num == 0) continue;
                
                allRemoved |= 1 << num;
                if (!mp.containsKey(num)) {
                    ArrayList<Node> list = new ArrayList<>();
                    list.add(new Node(i, j, 0));
                    mp.put(num, list);
                } else {
                    ArrayList<Node> list = mp.get(num);
                    list.add(new Node(i, j, 0));
                    mp.put(num, list);
                }
            }
        }
        
        permutate(0, 1, new Node(r, c, 0));
        return minCnt;
    }
    
    private static void permutate(int cnt, int removed, Node node) {
        if (cnt >= minCnt) {
            return;
        }
        
        if (removed == allRemoved) {
            minCnt = Math.min(minCnt, cnt);
            return;
        }
        
        for (int num: mp.keySet()) {
            ArrayList<Node> a = mp.get(num);
            if ((removed & 1 << num) != 0) { // 해당 숫자가 삭제된 것이면 continue
                continue;
            }
            
            int one = bfs(removed, node, a.get(0)) + bfs(removed, a.get(0), a.get(1)) + 2;
            int two = bfs(removed, node, a.get(1)) + bfs(removed, a.get(1), a.get(0)) + 2;
            
            permutate(cnt + one, removed | 1 << num, a.get(1));
            permutate(cnt + two, removed | 1 << num, a.get(0));
        }
    }
    
    private static int bfs(int removed, Node src, Node dst) {
        boolean[][] visited = new boolean[4][4];
        Queue<Node> q = new ArrayDeque<>();
        q.add(src);
        visited[src.x][src.y] = true;
        
        while (!q.isEmpty()) {
            Node f = q.poll();
            if (f.x == dst.x && f.y == dst.y) {
                return f.cnt;
            }
            
            for (int i=0; i<4; i++) {
                int nx = f.x + dx[i];
                int ny = f.y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) {
                    continue;
                }
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, f.cnt + 1));   
                }
                
                while (true) {
                    if ((removed & 1 << arr[nx][ny]) == 0) {
                        break;
                    }
                    nx += dx[i]; ny += dy[i];
                    if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) {
                        nx -= dx[i]; ny -= dy[i];
                        break;
                    }
                }
                
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, f.cnt + 1));
                }
            }
        }
        
        return Integer.MAX_VALUE - 1;
    }
}