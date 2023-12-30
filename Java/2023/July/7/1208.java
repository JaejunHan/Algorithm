import java.io.*;
import java.util.*;

class B1208 {
    static int n, s;
    static long[] arr;
    static int[] left, right;
    static ArrayList<Long> leftSum = new ArrayList<>(), rightSum = new ArrayList<>();
    static long cnt = 0;
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();

        left = new int[n/2];
        right = new int[n - n/2];

        for (int i=0; i< n/2; i++) {
            left[i] = sc.nextInt();
        }

        for (int i=0; i < n- n/2; i++) {
            right[i] = sc.nextInt();
        }

        for (int i=0; i < (1<<n/2); i++) {
            long sum = 0;
            for (int j=0; j < n/2; j++) {
                if ((i & (1<<j)) != 0) {
                    sum += left[j];
                }
            }
            leftSum.add(sum);
        }

        for (int i=0; i < (1<<(n -n/2)); i++) {
            long sum = 0;
            for (int j=0; j < (n -n/2); j++) {
                if ((i & (1<<j)) != 0) {
                    sum += right[j];
                }
            }
            rightSum.add(sum);
        }

        Collections.sort(leftSum);
        Collections.sort(rightSum);
        
        getCnt();
        if (s == 0) {
            cnt--;
        }

        System.out.println(cnt);

    }

    public static void getCnt() {
        int p1= 0, p2 = rightSum.size()-1;
        while (p1 < leftSum.size() && p2 >= 0) {
            long sum = leftSum.get(p1) + rightSum.get(p2);
            if (sum == s) {
                long l = leftSum.get(p1);
                long r = rightSum.get(p2);
                long cnt1 =0, cnt2 = 0;

                while (p1 < leftSum.size() && leftSum.get(p1) == l) {
                    p1++;
                    cnt1++;
                }

                while (p2 >= 0 && rightSum.get(p2) == r) {
                    p2--;
                    cnt2++;
                }
                cnt += cnt1 * cnt2;

            } else if (sum > s) {
                p2--;
            } else {
                p1++;

            }
        }
    }
}
