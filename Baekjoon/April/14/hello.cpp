#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int countWays(int n, int k, vector<vector<int>>& dp) {
    if (n == 0) {
        return 1;
    }

    if (dp[n][k] != -1) {
        return dp[n][k];
    }

    int count = 0;
    for (int i = 1; i <= n; ++i) {
        if (abs(i - (n - i)) == k) {
            count += countWays(n - i, k, dp);
        }
    }

    return dp[n][k] = count;
}

int main() {
    int n, k;
    cin >> n >> k;

    vector<vector<int>> dp(n + 1, vector<int>(k + 1, -1));
    int result = countWays(n, k, dp);
    cout << result << endl;

    return 0;
}