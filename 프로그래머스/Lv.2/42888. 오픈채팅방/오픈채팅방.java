import java.util.*;

class Solution {
    static Map<String, String> mp = new HashMap<>();
    static List<Boolean> isEnter = new ArrayList<>();
    static List<String> uidList = new ArrayList<>();
    
    public String[] solution(String[] record) {
        for (String s: record) {
            String[] tmp = s.split(" ");
            String cmd = tmp[0];
            String uid = tmp[1];
            if (cmd.equals("Enter")) {
                String nick = tmp[2];
                isEnter.add(true);
                uidList.add(uid);
                mp.put(uid, nick);
            } else if (cmd.equals("Leave")) {            
                isEnter.add(false);
                uidList.add(uid);
            } else {
                String nick = tmp[2];
                mp.put(uid, nick);
            }
        }
        String[] ans = new String[isEnter.size()];
        for (int i=0; i < isEnter.size(); i++) {
            StringBuilder sb = new StringBuilder();
            String nick = mp.get(uidList.get(i));
            boolean isE = isEnter.get(i);
            sb.append(nick);
            if (isE) {
                sb.append("님이 들어왔습니다.");
            } else {
                sb.append("님이 나갔습니다.");
            }
            ans[i] = sb.toString();
        }
        return ans;
    }
}