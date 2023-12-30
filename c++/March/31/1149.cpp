#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;



int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    
int dp[1001][3];

    int N;
    cin >> N;

    int v[N+1][3];

    int temp;
    for (int i=1; i<=N; i++) {
        for (int j=0;j<3;j++) {
            cin >> v[i][j];
        }
    }

    dp[1][0] = v[1][0];
    dp[1][1] = v[1][1];
    dp[1][2] = v[1][2];

    for (int i=2 ; i<= N; i++) {
        dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + v[i][0];
        dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + v[i][1];
        dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + v[i][2];
    }

    int ans = min(dp[N][0], min(dp[N][1], dp[N][2]));

    cout << ans;

    return 0;
}