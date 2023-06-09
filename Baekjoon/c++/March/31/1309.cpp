#include <iostream>
#include <algorithm>
#define MAX 100001

using namespace std;

const int mod = 9901;

int dp[MAX][3];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    dp[1][0] = dp[1][1] = dp[1][2] = 1;

    for (int i=2; i<= N;i++) {
        dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%mod;
        dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % mod;
        dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % mod;
    }

    cout << (dp[N][0] + dp[N][1] + dp[N][2]) % mod;

    return 0;
}
