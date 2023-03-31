#include <iostream>
#define MAX 1000001
using namespace std;

const int mod = 1000000009;

long long dp[MAX];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    for (int i=4; i<MAX;i++) {
        dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % mod;
    }

    int N;
    cin >> N;
    int temp;

    for (int i=0; i < N;i++) {
        cin >> temp;
        cout << dp[temp] << "\n";
    }

    return 0;
}