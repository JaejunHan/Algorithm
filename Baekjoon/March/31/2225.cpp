#include <iostream>
#define MAX 201
using namespace std;

int dp[MAX][MAX];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, k;
    cin >> n >> k;

    for (int i=0; i < MAX; i++) {
        dp[1][i] = i;
    }

    for (int i=2; i<=n; i++) {
        for (int j=1;j<=k; j++) {
            dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
        }
    }

    cout << dp[n][k];

    return 0;
}