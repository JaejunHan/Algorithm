import java.util.*;

class Solution {
    static int time = Integer.MIN_VALUE;
    static String ans;
    
    public String solution(String m, String[] musicinfos) {
        m = replace(m);
        for (String musicinfo: musicinfos) {
            String[] tmp = musicinfo.split("\\,");
            String startTime = tmp[0];
            String endTime = tmp[1];
            
            String[] t1 = startTime.split("\\:");
            String[] t2 = endTime.split("\\:");
            
            int hour = Integer.parseInt(t2[0]) - Integer.parseInt(t1[0]);
            int min =  Integer.parseInt(t2[1]) - Integer.parseInt(t1[1]);
            min += 60 * hour;
            
            String title = tmp[2];
            
            String music = tmp[3];
            music = replace(music);
            
            String repetition = music;
            if (music.length() > min) {
                repetition = music.substring(0, min);
            } else {
                while (true) {
                    if (repetition.length() > min) {
                        repetition = repetition.substring(0, min);
                        break;
                    }
                    repetition += music;
                }
            }
            
            if (repetition.contains(m) && min > time) {
                time = min;
                ans = title;
            }
        }
        
        if (time == Integer.MIN_VALUE) {
            return "(None)";
        }
        return ans;
    }
    
    private String replace(String s) {
        s = s.replaceAll("C#", "c");
        s = s.replaceAll("D#", "d");
        s = s.replaceAll("F#", "f");
        s = s.replaceAll("G#", "g");
        s = s.replaceAll("A#", "a");
        return s;
    }
}