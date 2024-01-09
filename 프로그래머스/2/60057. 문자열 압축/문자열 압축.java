import java.util.*;

class Solution {
    static StringBuilder sb;
    static int ans = Integer.MAX_VALUE;
    
    public int solution(String s) {
        for (int i=1; i <= s.length(); i++) {
            compare(s, i);   
        }
        
        return ans;
    }
    
    private void compare(String s, int len) {
        sb = new StringBuilder();
        for (int i=0; i < s.length(); i+=len) {
            // System.out.println("여기");
            String sub;
            if (i + len > s.length()) {
                sub = s.substring(i);
            } else {
                sub = s.substring(i, i + len);
            }
            // System.out.println("sub = " + sub);
            int incre = 0;
            boolean isAdd = false;
            for (int k=i + len; k < s.length(); k += len) {
                if (k + len > s.length()) {
                    break;
                }
                String tmp;
                if (k + len > s.length()) {
                    tmp = s.substring(k);
                } else {
                    tmp = s.substring(k, k+ len);
                }
                // System.out.println("tmp = " + tmp + ", k = " + k + ", i = " + i);
                if (!sub.equals(tmp)) {
                    isAdd = true;
                    if ((k-i) / len != 1) {
                        sb.append((k-i) / len);   
                    }
                    sb.append(sub);
                    break;
                } else {
                    incre++;
                }
            }
            i += incre * len;
            // System.out.println(isAdd);
            // System.out.println("incre = " + incre);
            if (!isAdd) {
                if (incre+1 != 1) {            
                    sb.append(incre + 1);   
                }
                sb.append(sub);
            }
        }
        // System.out.println(sb.toString());
        ans = Math.min(sb.toString().length(), ans);
    }
}