import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] s1 = new String[n];
        String[] s2 = new String[n];
        
        for (int i=0; i < n; i++) {
            s1[i] = toBinary(arr1[i], n);
            s2[i] = toBinary(arr2[i], n);
        }
        
        String[] ans = new String[n];
        for (int i=0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j < n; j++) {
                if (s1[i].charAt(j) == '1' || s2[i].charAt(j) == '1') {
                    sb.append('#');
                } else {
                    sb.append(' ');
                }
            }
            ans[i] = sb.toString();
        }
        
        return ans;
    }
    
    public String toBinary(int num, int len) {
        StringBuilder sb = new StringBuilder();
        
        for (int i=len-1; i >= 0; i--) {
            int tmp = 1 << i;
            if ((num & tmp) != 0) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        
        return sb.toString();
    }
}