import java.util.*;
import java.util.stream.Collectors;

class Solution {
//        static int[][] dice ={{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}};
//        static int[][] dice = {{1, 2, 3, 4, 5, 6}, {2, 2, 4, 4, 6, 6}};
//    static int[][] dice = {{40, 41, 42, 43, 44, 45}, {43, 43, 42, 42, 41, 41}, {1, 1, 80, 80, 80, 80}, {70, 70, 1, 1, 70, 70}};


    static int coin = 2;
//    static int[] cards = {3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4};

    static int[] cards = {5, 8, 1, 2, 9, 4, 12, 11, 3, 10, 6, 7};

    public static void main(String[] args) {
        System.out.println(solution(coin, cards));
    }

    static int[] canPick;
    public static int solution(int coin, int[] cards) {
        int n = cards.length;
        int pairCnt = getPair(cards);
        int round = 0;
        int ans = 0;

        int tmpCoin = coin;
        int tmpPairCnt = pairCnt;
        for (int x = n/3; x <= n; x+=2) {
            if (x == n) {
                round++;
                ans = Math.max(round, ans);
                break;
            }
            round++;
            canPick = new int[n+1];
            Arrays.fill(canPick, -1);
            
            // canPick 초기화
            int maxRange = Math.min(n, x+2);
            for (int a=0; a < maxRange; a++) {
                for (int b = a+1; b < maxRange; b++) {
                    if (cards[a] + cards[b] == n+1) {
                        canPick[cards[a]] = b;
                        canPick[cards[b]] = a;
                    }
                }
            }

            boolean possible = true;
            for (int i= x; i < maxRange; i += 2) {
                if (canPick[cards[i]] != -1) {
                    if (tmpCoin > 0) {
                        tmpCoin--;
                        if (canPick[cards[i]] <= i+1) {
                            tmpPairCnt++;
                        }
                    }
                }
                if (canPick[cards[i+1]] != -1) {
                    if (tmpCoin > 0) {
                        tmpCoin--;
                        if (canPick[cards[i+1]] <= i+1) {
                            tmpPairCnt++;
                        }
                    }
                }
                // 중복으로 센거
                if (cards[i] + cards[i+1] == n+1) {
                    tmpPairCnt--;
                }

                if (tmpPairCnt > 0) {
                    tmpPairCnt--;
                } else {
                    possible = false;
                    break;
                }
            }

            int a  =1;
            ans = Math.max(ans, round);
            if (!possible) break;
        }
        return ans;
    }

    private static int getPair(int[] cards) {
        int cnt = 0;
        for (int i=0; i< cards.length / 3; i++) {
            for (int j = i+1; j < cards.length / 3; j++) {
                if (cards[i] + cards[j] == cards.length + 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
//    public static int[] solution(int[][] dice) {
//        int n = dice.length;
//        List<Integer> bestCombination = new ArrayList<>();
//        int maxWins = 0;
//
//        for (int mask = 0; mask < (1 << n); mask++) {
//            if (Integer.bitCount(mask) == n / 2) {
//                List<Integer> comboA = new ArrayList<>();
//                List<Integer> comboB = new ArrayList<>();
//
//                for (int i = 0; i < n; i++) {
//                    if ((mask & (1 << i)) != 0) {
//                        comboA.add(i);
//                    } else {
//                        comboB.add(i);
//                    }
//                }
//
//                int[] dpA = calculateDp(comboA, dice);
//                int[] dpB = calculateDp(comboB, dice);
//
//                int wins = 0;
//                for (int sumA = 1; sumA <= 100 * n / 2; sumA++) {
//                    for (int sumB = 0; sumB < sumA; sumB++) {
//                        wins += dpA[sumA] * dpB[sumB];
//                    }
//                }
//
//                if (wins > maxWins) {
//                    maxWins = wins;
//                    bestCombination = comboA;
//                }
//            }
//        }
//
//        return bestCombination.stream().mapToInt(i -> i + 1).toArray();
//    }
//
//    private static int[] calculateDp(List<Integer> diceSet, int[][] dice) {
//        int maxSum = 500;
//        int[] dp = new int[maxSum + 1];
//        dp[0] = 1;
//
//        for (int dieIndex : diceSet) {
//            int[] currentDice = dice[dieIndex];
//            int[] newDp = new int[maxSum + 1];
//            for (int sum = 0; sum <= maxSum; sum++) {
//                for (int faceValue : currentDice) {
//                    if (sum >= faceValue) {
//                        newDp[sum] += dp[sum - faceValue];
//                    }
//                }
//            }
//            dp = newDp;
//        }
//
//        return dp;
//    }

