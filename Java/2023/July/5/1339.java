import java.io.*;
import java.util.*;

class B1339 {
    static int n;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String[] sl = new String[n];
        for (int i=0; i< n; i++) {
            sl[i] = sc.next();
        }

        int[] alpha = new int[26];
        for (int i=0; i< n; i++) {
            int temp = (int) Math.pow(10, sl[i].length()-1);
            for (int j=0; j< sl[i].length();j++) {
                alpha[sl[i].charAt(j) - 'A'] += temp;
                temp /= 10;
            }
        }
        
        Arrays.sort(alpha);
        int num = 9;
        int sum = 0;
        for (int i=alpha.length-1; i>=0; i--) {
            if (alpha[i] == 0) {
                break;
            }
            sum += alpha[i] * num;
            num--;
        }

        System.out.println(sum);
    }
}