#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    int dp[N];
    int arr[N]; 
    for (int i=0; i< N;i++) {
        cin >> arr[i];
    }
    
    
    int ans = arr[0];

    dp[0] = arr[0];
    for (int i=1; i < N; i++) {
        if (arr[i] < arr[i]+dp[i-1]) {
            dp[i] = arr[i]+dp[i-1];
        } else {
            dp[i] = arr[i];
        }
        ans = max(dp[i], ans);
    }

    cout << ans;

    return 0;
}