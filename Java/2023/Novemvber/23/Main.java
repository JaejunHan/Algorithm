import java.io.*;
import java.util.*;
class Main {
    static String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
    static int[] choices = {5, 3, 2, 7, 5};
    static String ans = "";
    static Map<Character, Integer> mp = new HashMap<>();
    public static void main(String[] args) {
        mp.put('R', 0);
        mp.put('T', 0);
        mp.put('C', 0);
        mp.put('F', 0);
        mp.put('J', 0);
        mp.put('M', 0);
        mp.put('A', 0);
        mp.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            int num = choices[i];
            String s = survey[i];
            if (num == 1) {
                int cur = mp.get(s.charAt(0));
                mp.put(s.charAt(0), cur + 3);
            } else if (num == 2) {
                int cur = mp.get(s.charAt(0));
                mp.put(s.charAt(0), cur + 2);
            } else if (num ==3) {
                int cur = mp.get(s.charAt(0));
                mp.put(s.charAt(0), cur + 1);
            } else if (num == 4) {
                continue;
            } else if (num == 5) {
                int cur = mp.get(s.charAt(1));
                mp.put(s.charAt(1), cur + 1);
            } else if (num == 6) {
                int cur = mp.get(s.charAt(1));
                mp.put(s.charAt(1), cur + 2);
            } else  { // num == 7
                int cur = mp.get(s.charAt(1));
                mp.put(s.charAt(1), cur + 3);
            }
        }

        if (mp.get('R') < mp.get('T')) {
            ans += 'T';
        } else {
            ans += 'R';
        }

        if (mp.get('C') < mp.get('F')) {
            ans += 'F';
        } else {
            ans += 'C';
        }

        if (mp.get('J') < mp.get('M')) {
            ans += 'M';
        } else {
            ans += 'J';
        }

        if (mp.get('A') < mp.get('N')) {
            ans += 'N';
        } else {
            ans += 'A';
        }

        System.out.println(ans);
    }

    public String solution(String[] survey, int[] choices) {
        String answer = "";
        return answer;
    }
}
