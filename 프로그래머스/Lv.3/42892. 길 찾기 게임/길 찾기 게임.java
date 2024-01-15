import java.util.*;

class Solution {
    static int N = 0;
    static int idx = 0;
    static int[][] ans;
    public int[][] solution(int[][] nodeinfo) {
        N = nodeinfo.length;
        Node[] nodeList = new Node[N];
        for (int i=0; i < N; i++) {
            nodeList[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1, null, null);
        }
        
        Arrays.sort(nodeList, (o1, o2) -> {
            if (o1.y == o2.y) {
                return o1.x - o2.x;
            } else {
                return o2.y - o1.y;
            }
        });
        
        Node root = nodeList[0];
        for (int i=1; i < nodeList.length; i++) {
            insertNode(root, nodeList[i]);
        }
        
        ans = new int[2][N];
        idx = 0;
        preorder(root);
        idx = 0;
        postorder(root);
        return ans;
    }
    
    public void preorder(Node node) {
        if (node != null) {
            ans[0][idx++] = node.value;
            preorder(node.left);
            preorder(node.right);
        }
    }
    
    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            ans[1][idx++] = node.value;
        }
    }
    
    public void insertNode(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }
    
    
    public class Node {
        int x; int y; int value;
        Node left;
        Node right;
        public Node(int x, int y, int value, Node left, Node right) {
            this.x = x; this.y = y; this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}