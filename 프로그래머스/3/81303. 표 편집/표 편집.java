import java.util.*;

class Solution {
    static Stack<Node> stack = new Stack<>();
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] nxt = new int[n];
        
        for (int i=0; i< n; i++) {
            prev[i] = i - 1;
            nxt[i] = i + 1;
        }
        nxt[n-1] = -1; // 맨 마지막 node의 다음 값은 -1
        
        StringBuilder sb = new StringBuilder("O".repeat(n));
        for (String ele: cmd) {
            if (ele.charAt(0) == 'U') {
                int d = Integer.parseInt(ele.substring(2));
                while (d-- > 0) {
                    k = prev[k];   
                }
            } else if (ele.charAt(0) == 'D') {
                int d = Integer.parseInt(ele.substring(2));
                while (d-- > 0) {
                    k = nxt[k];
                }
            } else if (ele.charAt(0) == 'C') {
                stack.push(new Node(prev[k], k, nxt[k]));
                if (nxt[k] != -1)
                    prev[nxt[k]] = prev[k];
                if (prev[k] != -1)
                    nxt[prev[k]] = nxt[k];
                sb.setCharAt(k, 'X');
                
                if (nxt[k] == -1) {
                    k = prev[k];
                } else {
                    k = nxt[k];
                }
            } else {
                Node f = stack.pop();
                if (f.prev != -1)
                    nxt[f.prev] = f.curr;
                if (f.nxt != -1)
                    prev[f.nxt] = f.curr;
                sb.setCharAt(f.curr, 'O');
            }
        }
        
        return sb.toString();
    }
    
    public class Node {
        int prev; int curr; int nxt;
        public Node(int prev, int curr, int nxt) {
            this.prev = prev;
            this.curr = curr;
            this.nxt = nxt;
        }
    }
}