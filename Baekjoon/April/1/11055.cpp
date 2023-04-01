#include <iostream>
#include <algorithm>
#define MAX 1001
using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
int arr[MAX] = {0, };
int dp[MAX] = {0, };


    int N;
    cin >> N;

    cin >> arr[1];
    dp[1] = arr[1];

    int ans=dp[1];
    for (int i=2; i<= N; i++) {
        cin >> arr[i];
        dp[i] = arr[i]; // 최솟값은 자기 자신이기때문에 0으로 초기화 하면 안됨.
        for (int j=1; j<=i; j++) {
            if (arr[i] > arr[j]) {
                dp[i] = max(dp[j]+arr[i], dp[i]);
            }
        }
        ans = max(ans, dp[i]);
    }

    cout << ans;

    return 0;
}