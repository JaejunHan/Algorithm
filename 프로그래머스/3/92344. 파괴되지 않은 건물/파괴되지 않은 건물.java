class Solution {
    static int rLen = 0, cLen = 0;
    static int[][] d = new int[1001][1001];
    static int cnt = 0;
    public int solution(int[][] board, int[][] skill) {
        rLen = board.length;
        cLen = board[0].length;
        
        for (int[] sk: skill) {
            int degree = sk[5];
            int r1 = sk[1];
            int c1 = sk[2];
            int r2 = sk[3];
            int c2 = sk[4];
            if (sk[0] == 1) {
                degree *= -1;
            }
            
            d[r1][c1] += degree;
            d[r1][c2+1] -= degree;
            d[r2+1][c1] -= degree;
            d[r2+1][c2+1] += degree;
        }
        
        for (int i=1; i < rLen; i++) {
            for (int j=0; j < cLen; j++) {
                d[i][j] += d[i-1][j];
            }
        }
        
        
        for (int i=0; i < rLen; i++) {
            for (int j=1; j < cLen; j++) {
                d[i][j] += d[i][j-1];
            }
        }
        
        
        for (int i=0; i< rLen; i++) {
            for (int j=0; j< cLen; j++) {
                board[i][j] += d[i][j];
                if (board[i][j] > 0) {
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}