import java.util.*;
class Solution {
    int root = -1;
    int cnt = 0;
    int[] parent;
    Node[] nodes;
    int[] Num;
    int mid = 0;
    public int solution(int k, int[] num, int[][] links) {
        Num = num;
        parent = new int[num.length];
        nodes = new Node[num.length];
        Arrays.fill(parent, -1);
        setTree(links);
        int sum = 0;
        for (int ele: num) {
            sum += ele;
        }
        
        int low = 0; int high = sum;
        for(int n : num) low = Math.max(low, n);
        while (low <= high) {
            mid = (low + high) / 2;
            if (check() <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    private int dfs(int n) {
        Node node = nodes[n];
        
        int lft = 0; int rht = 0;
        
        if (node.left != -1)
            lft = dfs(node.left);
        
        if (node.right != -1)
            rht = dfs(node.right);
        
        if (Num[n] + lft + rht <= mid) {
            return Num[n] + lft + rht;
        }
        
        if (Num[n] + Math.min(lft, rht) <= mid) {
            cnt++;
            return Num[n] + Math.min(lft, rht);
        }
        
        //둘다 잘라야하는 경우
        cnt += 2;
        return Num[n];
    }
        
    private int check() {
        cnt = 0;
        dfs(root);
        return cnt + 1;
    }
    
    private void setTree(int[][] links) {
        int i=0;
        for (int[] link: links) {
            int left = link[0];
            int right = link[1];
            nodes[i] = new Node(left, right);
            if (left != -1) {
                parent[left] = i;     
            }
            if (right != -1) {
                parent[right] = i;     
            }
            i++;
        }
        
        for (int j = 0; j < parent.length; j++) {
            if (parent[j] == -1) {
                root = j;
                break;
            }
        }
    }
 
    public class Node {
        int left; int right;
        public Node(int left, int right) {
            this.left = left; this.right = right;
        }
    }
}