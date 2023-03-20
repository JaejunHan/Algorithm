#include <cstdio>

using namespace std;

int dp[12];

int main() {
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    for (short i=4; i <= 11; i++) {
        dp[i] += dp[i-1];
        dp[i] += dp[i-2];
        dp[i] += dp[i-3];
    }


    int T;
    scanf("%d", &T);

    for (int i=0;i < T;i++) {
        int n;
        scanf("%d", &n);
        printf("%d\n", dp[n]);
    }

    return 0;
}