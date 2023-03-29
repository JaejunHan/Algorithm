#include <iostream>
#include <algorithm>
#define MAX 1001
using namespace std;

int dp[MAX] = {0, };
int arr[MAX] = {0, };

int main () {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    for (int i=1; i<= N; i++) {
        cin >> arr[i];
    }

    for (int i=1; i <= N; i++) {
        for (int j=1;j<=i;j++) {
            dp[i] = max(dp[i], dp[i-j] + arr[j]);
        }
    }

    cout << dp[N];

    return 0;
}