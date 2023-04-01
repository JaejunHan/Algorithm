#include <iostream>
#include <algorithm>
#define MAX 1001

using namespace std;

const int mod = 10007;

int dp[MAX][10] = {0, };

int main() {    
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    for (int i=0; i < 10; i++) {
        dp[1][i] = 1;
    }
    
    int N;
    cin >> N;

    for (int i=2;i <=N;i++) {
        for (int j=0;j <10;j++) {
            for (int k=j; k<10;k++) {            
                dp[i][j] += dp[i-1][k];
                dp[i][j] = dp[i][j] % mod;
            }
        }
    }

    int ans=0;
    for (int i=0; i<10; i++) {
        ans += dp[N][i];
    }

    cout << ans % mod;

    return 0;
}