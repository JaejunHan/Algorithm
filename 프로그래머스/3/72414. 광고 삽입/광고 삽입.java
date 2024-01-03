class Solution {
    static int[] arr;
    static long max;
    public String solution(String play_time, String adv_time, String[] logs) {
        int total = convert(play_time);
        int len = convert(adv_time);
        arr = new int[total+1];
        
        
        for (String log: logs) {
            String[] tmp = log.split("-");
            int start = convert(tmp[0]);
            int end = convert(tmp[1]);
            arr[start] += 1;
            arr[end] -= 1;
        }
        
        for (int i=1; i< total; i++) {
            arr[i] += arr[i-1];
        }
        
        long currSum = 0;
        for (int i=0; i< len; i++) {
            currSum += arr[i];
        }
        max = currSum;
        
        int maxIdx = 0;
        for (int i=len; i < total; i++) {
            currSum += arr[i] - arr[i-len];
            if (currSum > max) {
                max = currSum;
                maxIdx = i - len + 1;
            }
        }
        
        return convertToTime(maxIdx);
    }
    
    private String convertToTime(int time) {
        StringBuilder sb = new StringBuilder();
        int h = time / 3600;
        int m = (time - 3600 * h) / 60;
        int sec = time % 60;
        
        if (h < 10) {
            sb.append('0');
        }
        sb.append(h);
        sb.append(":");
        if (m < 10) {
            sb.append('0');
        }
        sb.append(m);
        sb.append(":");
        if (sec < 10) {
            sb.append('0');
        }
        sb.append(sec);
        return sb.toString();
    }
    
    private int convert(String time) {
        String[] tmp = time.split(":");
        int hour = Integer.parseInt(tmp[0]);
        int minute = Integer.parseInt(tmp[1]);
        int sec = Integer.parseInt(tmp[2]);
        
        return 3600 * hour + minute * 60 + sec;
    }
}