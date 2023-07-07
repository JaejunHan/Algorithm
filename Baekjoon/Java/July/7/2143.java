import java.io.*;
import java.util.*;

class B2143 {
    static int target, n, m;
    static int[] arr1, arr2;
    static ArrayList<Integer> a = new ArrayList<>(), b = new ArrayList<>();
    static long cnt = 0;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        target = sc.nextInt();
        n = sc.nextInt();
        arr1 = new int[n+1];
        for (int i=1; i<= n; i++) {
            arr1[i] = sc.nextInt();
        }

        m = sc.nextInt();
        arr2 = new int[m+1];
        for (int i=1;i <= m; i++) {
            arr2[i] = sc.nextInt();
        }

        // 누적합 구하기
        for (int i=1; i<= n; i++) {
            arr1[i] += arr1[i-1];
        }
        for (int i=1; i<= m; i++) {
            arr2[i] += arr2[i-1];
        }

        for (int i=0; i< n+1; i++) {
            for (int j=i+1; j< n+1; j++) {
                a.add(arr1[j] - arr1[i]);
            }
        }
        for (int i=0; i< m+1; i++) {
            for (int j=i+1; j< m+1; j++) {
                b.add(arr2[j] - arr2[i]);
            }
        }
        
        Collections.sort(a);
        Collections.sort(b);

        getCnt();

        System.out.println(cnt);

    }

    public static void getCnt() {
        int p1 = 0;
        int p2 = b.size()-1;
        int sum = 0;
        while (p1 < a.size() && p2 >=0) {
            sum = a.get(p1)+ b.get(p2);
            if (sum == target) {
                int temp1 = a.get(p1);
                long cnt1 = 0;
                while (p1 < a.size() && a.get(p1) == temp1) {
                    p1++;
                    cnt1++;
                }

                int temp2 = b.get(p2);
                long cnt2 = 0;
                while (p2 >=0 && b.get(p2) == temp2) {
                    p2--;
                    cnt2++;
                }
                cnt += cnt1 * cnt2;
            } else if (sum < target) {
                p1++;
            } else {
                p2--;
            }
        }
    }
}
