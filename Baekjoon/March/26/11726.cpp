#include <iostream>
#define MAX 10001

int dp[MAX] = {0, };

using namespace std;

int main() {
    int N;
    cin >> N;

    dp[1] = 1;
    dp[2] = 2;

    for (int i=3;i < MAX; i++) {
        dp[i] = (dp[i-1] + dp[i-2]) % 10007;
    }

    cout << dp[N];

    return 0;
}