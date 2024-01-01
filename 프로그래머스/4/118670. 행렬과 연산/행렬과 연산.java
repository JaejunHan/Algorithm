import java.util.*;

class Solution {
    static ArrayDeque<ArrayDeque<Integer>> q = new ArrayDeque<>();
    static ArrayDeque<Integer> c1 = new ArrayDeque<>();
    static ArrayDeque<Integer> c2 = new ArrayDeque<>();
    static int rLen = 0, cLen = 0;
    
    static int[][] ans;
    public int[][] solution(int[][] rc, String[] operations) {
        rLen = rc.length;
        cLen = rc[0].length;
        ans = new int[rLen][cLen];
        
        arrToDeque(rc);
        for (String s: operations) {
            if (s.charAt(0) == 'S') {
                shiftRow();
            } else { // rotate
                rotate();
            }
        }
        
        DequeToArr();
        return ans;
    }
    
    private static void DequeToArr() {
        int a = 0;
        for (int ele: c1) {
            ans[a++][0] = ele;
        }
        a = 0;
        for (int ele: c2) {
            ans[a++][cLen-1] = ele;
        }
        
        int i=0;
        while (!q.isEmpty()) {
            ArrayDeque<Integer> tmp = q.poll();
            int j = 1;
            while (!tmp.isEmpty()) {
                ans[i][j++] = tmp.poll();
            }
            i++;
        }
    }
    
    private static void shiftRow() {
        q.addFirst(q.pollLast());
        c1.addFirst(c1.pollLast());
        c2.addFirst(c2.pollLast());
    }
    
    private static void rotate() {
        q.peekLast().add(c2.pollLast());
        c1.addLast(q.peekLast().pollFirst());
        q.peek().addFirst(c1.pollFirst());
        c2.addFirst(q.peek().removeLast());
    }
    
    private static void arrToDeque(int[][] rc) {
        for (int[] row: rc) {
            c1.add(row[0]);
            c2.add(row[row.length-1]);
            ArrayDeque<Integer> tmp = new ArrayDeque<>();
            int j=-1;
            for (int ele: row) {
                j++;
                if (j == 0 || j == rc[0].length-1) {
                    continue;
                }
                tmp.add(ele);
            }
            q.add(tmp);
        }
    }
}