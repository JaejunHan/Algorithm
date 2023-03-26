#include <iostream>
#include <algorithm>
#include <cmath>

#define MAX 1000001

using namespace std;

int dp[MAX] = {0, };

int main() {
    int N;
    cin >> N;

    dp[0] = INFINITY;
    dp[1]= 0;
    for (int i=2; i <= MAX; i++) {
        int temp = dp[i-1] + 1;
        if (i % 3 == 0) {
            temp = min(dp[i/3] + 1, temp);
        }
        
        if (i % 2 == 0) {
            temp = min(dp[i/2] + 1, temp);
        }

        dp[i] = temp;
    }

    cout << dp[N];

    return 0;
}


// 1 0
// 2 1
// 3 1
// 4 2