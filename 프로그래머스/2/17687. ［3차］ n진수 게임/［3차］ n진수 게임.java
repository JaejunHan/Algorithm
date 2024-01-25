import java.util.*;

class Solution {
    static StringBuilder sb1 = new StringBuilder();
    static int turn = 0;
    
    public String solution(int n, int t, int m, int p) {
        int num = 0;
        
        while (sb1.length() != t) {
            String s = toNAryString(num++, n);
            for (int i=0; i < s.length(); i++) {
                turn = (turn + 1) % m;
                if (turn == 0) turn = m;
                
                if (turn == p) {
                    sb1.append(s.charAt(i));
                    if (sb1.length() == t) {
                        break;
                    }
                }
            }
        }
        
        return sb1.toString();
    }
    
    private String toNAryString(int num, int n) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        
        while (num != 0) {
            int remainder = num % n;
            num /= n;
            
            sb.append(remainToString(remainder));
        }
        
        return sb.reverse().toString();
    }
    
    private String remainToString(int remain) {
        StringBuilder sb = new StringBuilder();
        if (remain < 10) {
            sb.append(remain);
        } else if (remain == 10) {
            sb.append('A');
        } else if (remain == 11) {
            sb.append('B');
        } else if (remain == 12) {
            sb.append('C');
        } else if (remain == 13) {
            sb.append('D');
        } else if (remain == 14) {
            sb.append('E');
        } else if (remain == 15) {
            sb.append('F');
        }
        return sb.toString();
    }
}