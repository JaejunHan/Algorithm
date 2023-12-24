class Solution {
    static int[] ans;
    static long[] nums;
    public int[] solution(long[] numbers) {
        nums = numbers;
        int len = numbers.length;
        ans = new int[len];
        
        for (int i=0; i< len; i++) {
            check(i);
        }
        return ans;
    }
    
    private void check(int idx) {
        String s = getFullBinaryString(Long.toBinaryString(nums[idx]));
        
        int mid = (s.length()-1) / 2;
        if (s.charAt(mid) == '0') {
            return;
        }
        
        if (valid(s)) {
            ans[idx] = 1;
        }
        return;
    }
    
    private String getFullBinaryString(String s) {
        int node = 1;
        int level = 1;
        while (node < s.length()) {
            level *= 2;
            node += level;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i< node - s.length(); i++) {        
            sb.append("0");
        }
        sb.append(s);
        
        return sb.toString();
    }
    
    private boolean valid(String s) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        int mid = (len-1) / 2;
        
        if (s.charAt(mid) == '0') {
            return isZero(s.substring(0, mid)) && isZero(s.substring(mid+1));
        }
        
        return valid(s.substring(0, mid)) && valid(s.substring(mid+1));
    }
    
    private boolean isZero(String s) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        int mid = (len-1) / 2;
        
        if (s.charAt(mid) == '1') {
            return false;
        }
        
        return isZero(s.substring(0, mid)) && isZero(s.substring(mid+1));
    }
}