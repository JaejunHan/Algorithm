#include <vector>
#include <iostream>
#include <algorithm>
#define MAX 100001

using namespace std;

const int mod = 1000000009;

long long dp[MAX][4];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
    for (int n = 4; n < MAX; n++) {
        dp[n][1] = (dp[n-1][2] + dp[n-1][3]) % mod;
        dp[n][2] = (dp[n-2][1] + dp[n-2][3]) % mod;
        dp[n][3] = (dp[n-3][1] + dp[n-3][2]) % mod;
    }

    for (int i=0;i<N;i++) {    
        int tmp;
        cin >> tmp;
        cout << (dp[tmp][1] + dp[tmp][2] + dp[tmp][3]) % mod << "\n";   
    }


    return 0;
}