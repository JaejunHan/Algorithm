import java.util.*;

class Solution {
    public String solution(String p) {
        if (p.length() == 0) {
            return p;
        }
        
        return make(p);
        // String answer = "";
        // return answer;
    }
    
    private String make(String s) {
        if (s.length() == 0) {
            return s;
        }
        
        for (int i=1; i <= s.length(); i++) {
            String a = s.substring(0, i);
            String b = "";
            
            if (i != s.length()) {
                b = s.substring(i);
            }
            
            if (isBalanced(a)) {
                // System.out.println("a = " +  a + ", b = " + b);
                if (isCorrect(a)) {
                    return a + make(b);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append('(');
                    sb.append(make(b));
                    sb.append(')');
                    if (a.length() != 2) {
                        sb.append(getReversed(a.substring(1, a.length() - 1)));
                    }
                    return sb.toString();
                }
            }
        }
        
        return "";
    }
    
    private String getReversed(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }
    
    private boolean isBalanced(String s) {
        int cnt1 = 0;
        int cnt2 = 0;
        
        for (int i=0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt1++;
            } else {
                cnt2++;
            }
        }
        return cnt1 == cnt2;
    }
    
    private boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i< s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == '(') {
                stack.push(tmp);
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                stack.pop();
            }
        }
        
        return stack.size() == 0;
    }
}