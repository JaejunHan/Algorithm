import java.util.*;

class Solution {
    static int lx = 3, ly = 0;
    static int rx = 3, ry = 2;
    static boolean isRight;
    static Map<Integer, Node> mp = new HashMap<>();
    
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        if (hand.equals("right")) {
            isRight = true;
        } else {
            isRight = false;
        }
        init();
        
        for (int num: numbers) {
            Node node = mp.get(num);
            int x = node.x;
            int y = node.y;
            
            if (num == 1 || num == 4 || num == 7) {
                
                lx = x;
                ly = y;
                sb.append('L');
                continue;
            } else if (num == 3 || num == 6 || num == 9) {
                rx = x;
                ry = y;
                sb.append('R');
                continue;
            }
            
            int leftDistance = Math.abs(x - lx) + Math.abs(y - ly);
            int rightDistance = Math.abs(x - rx) + Math.abs(y - ry);
            
            if (leftDistance < rightDistance) {
                lx = x;
                ly = y;
                sb.append('L');
            } else if (leftDistance > rightDistance) {
                rx = x;
                ry = y;
                sb.append('R');
            } else {
                if (isRight) { // 오른손 잡이
                    rx = x;
                    ry = y;
                    sb.append('R');
                } else {
                    lx = x;
                    ly = y;
                    sb.append('L');
                }
            }
            
        }
        
        return sb.toString();
    }
    
    private void init() {
        mp.put(1, new Node(0, 0));
        mp.put(2, new Node(0, 1));
        mp.put(3, new Node(0, 2));
        mp.put(4, new Node(1, 0));
        mp.put(5, new Node(1, 1));
        mp.put(6, new Node(1, 2));
        mp.put(7, new Node(2, 0));
        mp.put(8, new Node(2, 1));
        mp.put(9, new Node(2, 2));
        mp.put(0, new Node(3, 1));
    }
    
    public class Node {
        int x; int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}