#include <iostream>
#include <algorithm>
#define MAX 1001
using namespace std;

int arr[MAX] = {0, };
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int dp1[MAX] = {0, };
    int dp2[MAX] = {0, };

    int N;
    cin >> N;

    for (int i=1;i <= N; i++) {
        cin >> arr[i];
    }

    int ans=0;
    
    for (int i=1; i<=N; i++) {
        dp1[i] = 1;
        for (int j=1; j<=i;j++) {
            if (arr[i] > arr[j]) {
                dp1[i] = max(dp1[j]+1, dp1[i]);
            }
        }
    }

    for (int i=N; i>= 1;i--) {
        dp2[i] = 1;
        for (int j=N; j>=i;j--) {
            if (arr[i] > arr[j]) {
                dp2[i] = max(dp2[j]+1, dp2[i]);
            }
        }
        ans = max(ans, dp1[i]+dp2[i]-1);
    }

    cout << ans;
    
    return 0;
}