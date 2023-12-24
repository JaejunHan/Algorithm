import java.util.*;

class Solution {
    static String[][] arr = new String[51][51];
    static int[][] mergeInfo = new int[51][51];
    static int mergeCnt = 0;
    static List<String> ans = new ArrayList<>();
    public String[] solution(String[] commands) {
        
        for (String s: commands) {
            String[] split = s.split(" ");
            String cmd = split[0];
            if (cmd.equals("UPDATE")) {
                if (split.length == 4) {
                    update1(Integer.parseInt(split[1]), Integer.parseInt(split[2]), split[3]);
                } else {
                    update2(split[1], split[2]);
                }
            } else if (cmd.equals("MERGE")) {
                // System.out.println("merge done: ");
                int r1 = Integer.parseInt(split[1]);
                int c1 = Integer.parseInt(split[2]);
                int r2 = Integer.parseInt(split[3]);
                int c2 = Integer.parseInt(split[4]);
                merge(r1, c1, r2, c2);
            } else if (cmd.equals("UNMERGE")) {
                int r1 = Integer.parseInt(split[1]);
                int c1 = Integer.parseInt(split[2]);
                unmerge(r1, c1);
            } else if (cmd.equals("PRINT")) {
                int r1 = Integer.parseInt(split[1]);
                int c1 = Integer.parseInt(split[2]);
                print(r1, c1);
            }
            // debug();
            // System.out.println();
        }
        
        
        
        return ans.stream().toArray(String[]::new);
    }
    
    private void debug() {
        for (int i=1; i<= 4; i++) {
            for (int j=1; j <= 4; j++) {
                if (arr[i][j] == null) {
                    arr[i][j] = "EMPTY";
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    private void print(int r, int c) {
        String tmp = arr[r][c];
        if (tmp == null) {
            ans.add("EMPTY");
        } else {
            ans.add(tmp);
        }
    }
    
    private void unmerge(int r, int c) {
        int m = mergeInfo[r][c];
        String tmp = arr[r][c];
        if (m != 0) {
            changeMergeInfo(m, 0, null);
        }
        arr[r][c] = tmp;
    }
    
    private void merge(int r1, int c1, int r2, int c2) {
        int m1 = mergeInfo[r1][c1];
        int m2 = mergeInfo[r2][c2];
        
        if (m1 != 0 && m2 != 0 && m1 == m2) { // 두 셀이 같은 셀일 경우 무시
            return;
        }
        if (r1 == r2 && c1 == c2) {
            return;
        }
        
        mergeCnt += 1;
        
        // 두 셀 모두 값을 가지고 있을 경우에는 r1, c1의 셀의 값을 가짐.
        String res = null;
        if (arr[r2][c2] != null) { // 두 번째 값이 있을 경우
            res = arr[r2][c2];
        }
        if (arr[r1][c1] != null) { // 첫 번째 값이 있을 경우
            res = arr[r1][c1];
        }
        
        if (m1 == 0 && m2 == 0) {
            mergeInfo[r1][c1] = mergeCnt;
            mergeInfo[r2][c2] = mergeCnt;
            arr[r1][c1] = res;
            arr[r2][c2] = res;
        } else if (m1 == 0 && m2 != 0) {
            mergeInfo[r1][c1] = mergeCnt;
            arr[r1][c1] = res;
            changeMergeInfo(m2, mergeCnt, res);
        } else if (m1 != 0 && m2 == 0) {
            mergeInfo[r2][c2] = mergeCnt;
            arr[r2][c2] = res;
            changeMergeInfo(m1, mergeCnt, res);
        } else {
            changeMergeInfo2(m1, m2, mergeCnt, res);
        }
    }
    
    private void changeMergeInfo(int prev, int next, String res) {
        for (int i=0; i <= 50; i++) {
            for (int j=0; j <= 50; j++) {
                if (mergeInfo[i][j] == prev) {
                    mergeInfo[i][j] = next;
                    arr[i][j] = res;
                }
            }
        }
    }
    
    private void changeMergeInfo2(int prev1, int prev2, int next, String res) {
        for (int i=0; i <= 50; i++) {
            for (int j=0; j <= 50; j++) {
                if (mergeInfo[i][j] == prev1 || mergeInfo[i][j] == prev2) {
                    mergeInfo[i][j] = next;
                    arr[i][j] = res;
                }
            }
        }
    }
    
    private void update1(int r, int c, String val) {
        arr[r][c] = val;
        
        int m = mergeInfo[r][c];
        
        if (m == 0) { // 병합된 부분이 없으면
            return;
        }
        
        // 병합된 부분도 같이 처리.
        for (int i = 1; i<= 50; i++) {
            for (int j=1; j<= 50; j++) {
                if (mergeInfo[i][j] == m) {
                    arr[i][j] = val;
                }
            }
        }
    }
    
    
    private void update2(String prev, String next) {
        for (int i=1; i<= 50; i++) {
            for (int j=1; j<= 50; j++) {
                if (arr[i][j] == null) {
                    continue;
                }
                if (arr[i][j].equals(prev)) {
                    arr[i][j] = next;
                }
            }
        }
    }
}