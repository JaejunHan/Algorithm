import java.util.*;

class Solution {
    static Stack<Integer>[] stackList;
    static Stack<Integer> s1 = new Stack<>();
    static int N = 0;
    static int ans = 0;
    public int solution(int[][] board, int[] moves) {
        N = board.length;
        stackList = new Stack[N+1];
        for (int i=0; i < N; i++) {
            stackList[i] = new Stack<Integer>();
        }
        
        for (int j=N-1; j >= 0; j--) {
            for (int i=N-1; i >= 0; i--) {
                if (board[i][j] != 0) {
                    stackList[j].push(board[i][j]);
                }
            }
        }
        
        for (int m: moves) {
            if (stackList[m-1].isEmpty()) continue;
            int ele = stackList[m-1].pop();
            int top = s1.isEmpty() ? -1 : s1.peek();
            if (ele == top) {
                s1.pop();
                ans += 2;
            } else {
                s1.push(ele);
            }
        }
        
        return ans;
    }
}