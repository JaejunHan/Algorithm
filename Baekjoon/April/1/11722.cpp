#include <iostream>
#include <algorithm>
#define MAX 1001
using namespace std;

int arr[MAX] = {0, };
int dp[MAX] = {0, };

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    for (int i=1; i <= N; i++) {
        cin >> arr[i];
    }

    int ans=0;
    for (int i=1; i <=N; i++) {
        dp[i] = 1;
        for (int j=1; j <=i; j++) {
            if (arr[i] < arr[j]) {
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
        ans = max(dp[i], ans);
    }

    cout << ans;

    return 0;
}