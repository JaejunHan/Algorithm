import java.util.*;

class Solution {
    public int solution(String[] words) {
        Trie trie = new Trie();
        for (String w: words) {
            trie.insert(w);
        }
        int answer = trie.cal(trie, 0);
        return answer;
    }
    
    public class Trie {
        HashMap<Character, Trie> child = new HashMap<>();
        int maxDepth = 0;
        
        Trie put(char ch) {
            maxDepth++;
            if (!child.containsKey(ch)) {
                child.put(ch, new Trie());
            }
            
            return child.get(ch);
        }
        
        
        void insert(String word) {
            Trie nxt = this;
            for (char ch: word.toCharArray()) {
                nxt = nxt.put(ch);
            }
            nxt.put('-');
        }
        
        int cal(Trie node, int depth) {
            if (node.maxDepth == 1) {
                return depth;
            }
            
            int cnt = 0;
            for (char key: node.child.keySet()) {
                if (key == '-') {
                    cnt += depth;
                } else {
                    cnt += cal(node.child.get(key), depth + 1);
                }
            }
            return cnt;
        }
    }
}