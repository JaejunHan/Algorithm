import java.util.*;

class Solution {
    static String START = "09:00";
    static ArrayList<Integer>[] arr;
    static int[] tt;
    
    public String solution(int n, int t, int m, String[] timetable) {
        tt = new int[n];
        for (int i=0; i < n; i++) {
            tt[i] = timeToInt(START) + t * i;
        }
        
        arr = new ArrayList[n];
        for (int i=0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        
        Arrays.sort(timetable);
        int st = 0;
        for (String time : timetable) {
            int timeInt = timeToInt(time);
            
            for (int i=st; i < n; i++) {
                int ele = tt[i];
                if (timeInt > ele) {
                    continue;
                }
                for (int j=i; j < n; j++) {
                    if (arr[j].size() < m) {
                        arr[j].add(timeInt);
                        break;
                    }
                }
                st = i;
                break;
            }
        }
        
        // for (int i=0; i< n; i++) {
        //     for (int j=0; j < arr[i].size(); j++) {
        //         System.out.print(arr[i].get(j) + " ");
        //     }
        // }
        if (arr[n-1].size() == m) {
            return intToTime(arr[n-1].get(m-1) - 1);
        } else {
            return intToTime(tt[n-1]);
        }
        
    }
    
    private int timeToInt(String s) {
        String[] tmp = s.split("\\:");
        int hour = Integer.parseInt(tmp[0]);
        int min = Integer.parseInt(tmp[1]);
        return 60 * hour + min;
    }
    
    private String intToTime(int n) {
        StringBuilder sb = new StringBuilder();
        int hour = n / 60;
        int min = n % 60;
        if (hour < 10) {
            sb.append('0');
        }
        sb.append(hour);
        sb.append(':');
        if (min < 10) {
            sb.append('0');
        }
        sb.append(min);
        return sb.toString();
    }
}