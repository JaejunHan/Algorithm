import java.util.*;
import java.io.*;

class Test {
    public static void main(String[] args) throws Exception{

        int[][] v = {{1, 1}, {2, 2}, {1, 2}};
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        for (int[] ele: v) {
            int v1 = ele[0];
            int v2 = ele[1];
            if (s1.contains(v1)) {
                s1.remove(v1);
            } else {
                s1.add(v1);
            }

            if (s2.contains(v2)) {
                s2.remove(v2);
            } else {
                s2.add(v2);
            }
        }
        int[] answer = new int[2];

        for (int ele : s1) {
            answer[0] = ele;
        }
        for (int ele : s2) {
            answer[1] = ele;
        }

        System.out.println(Arrays.toString(answer));
    }
    
}
