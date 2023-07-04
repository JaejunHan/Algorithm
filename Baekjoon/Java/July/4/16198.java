import java.io.*;
import java.util.*;

class B16198 {
    static int n, max = 1;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i=0; i< n; i++) {
            list.add(sc.nextInt());
        }
        dfs(list, 0);
        System.out.println(max);
    }
    
    public static void dfs(List<Integer> list, int sum) {
        if (list.size() <= 2) {
            max = Math.max(max, sum);
            return;
        }

        for (int i=1; i< list.size()-1; i++) {
            int temp = list.get(i);
            int num = list.get(i-1)* list.get(i+1);
            list.remove(i);
            dfs(list, sum+num);
            list.add(i, temp);
        }
    }
}
