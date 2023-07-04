#include <iostream>
#include <vector>
#include <stdio.h>

using namespace std;

vector<bool> dp(1000001, true);

int main() {
    int M, N;
    scanf("%d %d", &M, &N);

    dp[0] = false;
    dp[1] = false;

    // 2
    // 4, 6, 8, 10, ... , x
    // N/2 + N/3+ ...  +
    //k=2 to n까지 시그마 1/k
    // 6
    // O(N*log(log(N)))

    // N/2 + N/3 + N/5 + N/7 + N/11 + ...
    // = N*(1/2 + 1/3 + 1/5 + 1/7 + 1/11 + ...)    (i 항의 개수 무시)
    // <= N*(1/2 + 1/3 + 1/4 + 1/5 + 1/6 + ...)
    // <= N*(1 + log(log(N)))                       (하모닉 수열의 상한값이 log(log(N))임을 이용)
    
    for(int i=2; i*i<= 1000000; i++) {
        if (dp[i] == false) {
            continue;
        }
        for (int j=2*i; j <= 1000000; j +=i) {
            dp[j] = false;
        }
    }

    for (int i=M;i<=N;i++) {
        if (dp[i] == true) {
            printf("%d\n", i);
        }
    }
    
    return 0;
}