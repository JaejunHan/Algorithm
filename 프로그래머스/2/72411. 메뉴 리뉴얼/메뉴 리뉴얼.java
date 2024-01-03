import java.util.*;

class Solution {
    static int MAX = Integer.MIN_VALUE;
    static int len = 0;
    static Set<Integer> set = new HashSet<>();
    static Map<String, Integer> mp = new TreeMap<>();
    static Map<Integer, PriorityQueue<Node>> retMap = new TreeMap<>(); // 길이 -> (횟수, 문자열)
    static boolean visited[];
    static String s;
    
    public static class Node implements Comparable<Node> {
        int cnt;
        String str;
        
        public Node (int cnt, String str) {
            this.cnt = cnt;
            this.str = str;
        }
        
        @Override
        public int compareTo(Node o) {
            return o.cnt - this.cnt;
        }
    }
    public String[] solution(String[] orders, int[] course) {
        
        for (int ele: course) {
            set.add(ele);
            MAX = Math.max(MAX, ele);
        }
        
        for (String order: orders) {
            char[] cArr = order.toCharArray();
            Arrays.sort(cArr);
            s = new String(cArr);
            visited = new boolean[11];
            len = order.length();
            comb(0, 0);
        }
        
        TreeSet<String> result = new TreeSet<>();
        mp.forEach((key, value) -> { // key: string, value: 횟수
            if (value >= 2) {
                PriorityQueue<Node> pq = retMap.getOrDefault(key.length(), new PriorityQueue<Node>());
                pq.add(new Node(value, key));
                retMap.put(key.length(), pq);
            }
        });
        
        retMap.forEach((key, pq) -> { // key: string 길이, value: priorityQueue<Node>
            int max = 0;
            while (!pq.isEmpty()) {
                Node f = pq.poll();
                if (f.cnt >= max) {
                    max = f.cnt;
                    result.add(f.str);
                } else {
                    break;
                }
            }
        });
        
        String[] ans = new String[result.size()];
        int a = 0;
        for (String it: result) {
            ans[a++] = it;
        }
        return ans;
    }
    
    private static void comb(int depth, int start) {
        if (depth > MAX || depth > len) {
            return;
        }
        
        if (set.contains(depth)) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i< 10; i++) {
                if (visited[i]) {
                    sb.append(s.charAt(i));
                }
            }
            String tmp = sb.toString();
            mp.put(tmp, mp.getOrDefault(tmp, 0) + 1);
        }
        
        for (int i= start; i < len; i++) {
            visited[i] = true;
            comb(depth + 1, i + 1);
            visited[i] = false;
        }
    }
}