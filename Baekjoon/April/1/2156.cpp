#include <iostream>
#include <algorithm>
#define MAX 10001

using namespace std;

int arr[MAX] = {0,};
int dp[MAX] = {0, };

int main () {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    for (int i=1; i<= N; i++) {
        cin >> arr[i];
    }

    dp[1] = arr[1];
    dp[2] = arr[1] + arr[2];

    for (int i=3; i<= N; i++) {
        dp[i] = max(dp[i-1], arr[i] + max(arr[i-1] + dp[i-3], dp[i-2]));
    }

    cout << dp[N];
    
    return 0;
}