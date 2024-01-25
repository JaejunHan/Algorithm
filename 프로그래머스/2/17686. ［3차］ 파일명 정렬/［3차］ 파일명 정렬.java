import java.util.*;

class Solution {
    static Node[] arr;
    
    public String[] solution(String[] files) {
        arr = new Node[files.length];
        
        for (int i=0; i < files.length; i++) {
            String file = files[i];
            arr[i] = toNode(file, i);
        }
        
        Arrays.sort(arr, (o1, o2) -> {
            if (!o1.head.equals(o2.head)) {
                return o1.head.compareTo(o2.head);
            } else if (o1.number != o2.number) {
                return o1.number - o2.number;
            } else {
                return o1.idx - o2.idx;
            }
        });
        
        String[] ans = new String[files.length];
        for (int i=0; i < files.length; i++) {
            ans[i] = arr[i].origin;
        }
        return ans;
    }
    
    private Node toNode(String s, int idx) {
        int from = 0;
        for (int a = 0; a < s.length(); a++){
            char ch = s.charAt(a);
            if (ch >= '0' && ch <= '9') {
                from = a;
                break;
            }
        }
        
        String head = s.substring(0, from).toLowerCase();
        
        int to = from;
        for (int a = from; a < s.length(); a++) {
            char ch = s.charAt(a);
            if (ch < '0' || ch > '9') { // 숫자가 아니면
                to = a;
                break;
            }
            
            if (a == s.length() - 1) {
                to = s.length();
            }
        }
        
        // if (to == s.length() -1) to = s.length();
        // System.out.println(from);
        // System.out.println(to);
        int number = Integer.parseInt(s.substring(from, to));
        return new Node(head, number, idx, s);
    }
    
    public class Node {
        String head;
        int number;
        int idx;
        String origin;
        
        public Node(String head, int number, int idx, String origin) {
            this.head = head;
            this.number = number;
            this.idx = idx;
            this.origin = origin;
        }
    }
}