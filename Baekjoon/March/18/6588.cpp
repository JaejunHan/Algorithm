#include <stdio.h>
#include <vector>

using namespace std;

vector<bool> dp(1000001, true);

int main() {

    dp[0] = false;
    dp[1] = false;

    for (int i=2;i*i <=1000000;i++) {
        if (dp[i] == false) {
            continue;
        }
        for (int j=2*i;j<=1000000;j +=i){
            dp[j] = false;
        }
    }

    while (true) {
        int n;
        bool isBreak = false;
        scanf("%d", &n);
        if (n == 0) break;
        for (int i=1;i<=n/2;i++) {
            if (dp[i] && dp[n-i]) {
                printf("%d = %d + %d\n", n, i, n-i);
                isBreak = true;
                break;
            }
        }
        if (isBreak) continue;
        printf("Goldbach's conjecture is wrong.");
    }

    return 0;
}