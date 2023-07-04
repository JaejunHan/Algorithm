#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>
#include <string.h>

#define MAX 1001

using namespace std;

vector<int> dp (MAX, 10001);
vector<int> arr (MAX, 0);

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;
    
    for (int i=1; i<= N; i++) {
        cin >> arr[i];    
    }

    dp[0] = 0;
    
    for (int i=1; i<=N;i++) {
        for (int j=1;j<=i;j++) {
            dp[i] = min(dp[i], dp[i-j] + arr[j]);
        }
    }

    cout << dp[N];

    return 0;
}