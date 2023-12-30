import java.io.*;
import java.util.*;

class B1644 {
    static int n, cnt = 0;
    static boolean[] prime;
    static ArrayList<Integer> primeList = new ArrayList<>();
    // ArrayList와 LinkedList의 차이점
    // indexing O(1), O(N)
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        prime = new boolean[n+1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int i=1; i*i<= n; i++) {
            if (prime[i]) { // 만약 주어진 수가 소수이면
                int a= 1;
                for (int j=2*i; j <=n; j += i) {
                    if (!prime[i]) {
                        break;
                    }
                    prime[j] = false;
                }
            }
        }

        for (int i=2; i <=n; i++) {
            if (prime[i]) primeList.add(i);
        }
        // System.out.println(primeList);
        int start= 0, end= 0, sum = 0;
        while (true) {
            if (sum > n) {
                sum -= primeList.get(start++);
            } else if (sum == n) {
                cnt++;
                sum -= primeList.get(start++);
            } else if (end == primeList.size()) {
                break;
            }
            else {
                sum += primeList.get(end++);
            }
        }

        System.out.println(cnt);

    }
}
