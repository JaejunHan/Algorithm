#include <iostream>
#include <algorithm>
#define MAX 501

using namespace std;

int arr[MAX][MAX];
int dp[MAX][MAX];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // fill_n(&arr[MAX][MAX], MAX*MAX, -1);
    // fill_n(&dp[MAX][MAX], MAX*MAX, -1);

    short N;
    cin >> N;
    
    for (short i=1; i<=N; i++) {
        for (short j=1; j<=i;j++) {
            cin >> arr[i][j];
        }
    }

    dp[1][1] = arr[1][1];
    for (short i=2; i <=N; i++) {
        for (short j=1; j<=i;j++) {
            dp[i][j] = arr[i][j] + max(dp[i-1][j-1], dp[i-1][j]);
        }
    }

    int ans = 0;
    for (short i=1; i <= N; i++) {
        ans = max(ans, dp[N][i]);
    }

    cout << ans;

    return 0;
}