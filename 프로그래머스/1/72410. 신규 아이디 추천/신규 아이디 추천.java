import java.util.*;

class Solution {
    static String ans;
    public String solution(String new_id) {
        ans = new_id;
        One();
        Two();
        Three();
        Four();
        Five();
        Six();
        Seven();
        return ans;
    }
    
    private static void One() {
        ans = ans.toLowerCase();
    }
    
    private static void Two() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i< ans.length(); i++) {
            char c = ans.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }
        ans = sb.toString();
    }
    
    private static void Three() {
        while (ans.contains("..")) {
            ans = ans.replace("..", ".");
        }
    }
    
    private static void Four() {
        if (ans.length() > 0 && ans.charAt(0) == '.') {
            ans = ans.substring(1, ans.length());
        }
        
        if (ans.length() > 0 && ans.charAt(ans.length()-1) == '.') {
            ans = ans.substring(0, ans.length()-1);
        }
    }
    
    private static void Five() {
        if (ans.length() == 0) {
            ans = "a";
        }
    }
    
    private static void Six() {
        if (ans.length() >= 16) {
            ans = ans.substring(0, 15);
        }
        if (ans.length() > 0 && ans.charAt(ans.length()-1) == '.') {
            ans = ans.substring(0, ans.length()-1);
        }
    }
    
    private static void Seven() {
        if (ans.length() > 2) {
            return;
        }
        while (ans.length() < 3) {
            ans += ans.charAt(ans.length()-1);
        }
    }
}