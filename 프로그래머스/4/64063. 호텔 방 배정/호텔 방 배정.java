import java.util.*;

class Solution {
    Map<Long, Long> mp = new HashMap<>();
    
    public long[] solution(long k, long[] room_number) {
        int n = room_number.length;
        long[] ans = new long[n];
        for (int i=0; i < n; i++) {
            ans[i] = findRoom(room_number[i]);
        }
        return ans;
    }
    
    public long findRoom(long room) {
        if (!mp.containsKey(room)) {
            mp.put(room, room+1);
            return room;    
        }
        
        long nxt = mp.get(room);
        long emptyRoom = findRoom(nxt);
        mp.put(room, emptyRoom);
        return emptyRoom;
    }
}