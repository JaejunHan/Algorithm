import java.io.*;
import java.util.*;

class Solution {
    static int nowdays = 0;
    static Map<String, Integer> mp = new HashMap<>();
    static List<Integer> answer = new ArrayList<>();
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        nowdays = fromDate(today);
        fromTerms(terms);
        fromPrivacy(privacies);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private void fromPrivacy(String[] privacies) {
        for (int i=1; i<= privacies.length; i++) {
            String ele = privacies[i-1];
            String[] splitList = ele.split(" ");
            int date = fromDate(splitList[0]);
            
            int month = (date / 100) % 100;
            int year = date / 10000;
            int day = date % 100;
            if (day == 1) {
                month -= 1;
                day = 28;
            } else {
                day -= 1;
            }
            
            month += mp.get(splitList[1]);
            if (month > 12) {
                year += month / 12;
                month = month % 12;
                if (month == 0) {
                    month = 12;
                    year--;
                }
            }
            
            date = year * 10000 + month * 100 + day;
            System.out.println(date);
            if (nowdays > date) {
                answer.add(i);
            }
        }
    }
    
    private void fromTerms(String[] terms) {
        for (String term: terms) {
            String[] elements = term.split(" ");
            mp.put(elements[0], Integer.parseInt(elements[1]));
        }
    }
    
    private int fromDate(String date) {
        int ans = 0;
        int quo = 10000;
        String[] dates = date.split("\\.");
        for (int i=0; i< 3; i++) {
            ans += Integer.parseInt(dates[i]) * quo;
            quo /= 100;
        }
        return ans;
    }
}