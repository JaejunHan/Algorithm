#include <iostream>
#define MAX 101

using namespace std;

const int mod = 1000000000;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    long long dp[MAX][11] = {2};

    int N;
    cin >> N;

    for (short i=1; i<=9;i++) {    
        dp[1][i] = 1;
    }
    dp[1][0] = 1; 

    for (int i=2; i< MAX; i++) {
        dp[i][0] = dp[i-1][1];
        for (int j=1; j<=9;j++) {
            dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
        }
    }

    dp[1][0] = 0;

    long long sum = 0;
    for (short i=1; i <=9;i++) {
        sum += dp[N][i];
    }

    cout << sum % mod;

    return 0;
}