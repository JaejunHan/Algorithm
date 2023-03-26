#include <iostream>
#define MAX 1001

using namespace std;

short dp[MAX] = {0, };

int main() {
    int N;
    cin >> N;

    dp[1] = 1;
    dp[2] = 3;
    for (short i=3; i< MAX; i++) {
        dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007;
    }

    cout << dp[N];

    return 0;
}