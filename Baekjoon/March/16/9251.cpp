#include <iostream>
#include <string>
#include <algorithm>
#include <string>

using namespace std;

const int MAX = 10001;
int dp[MAX][MAX];

int main () {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    string x, y;
    getline(cin, x);
    getline(cin, y);
    
    for (int i=1;i<= x.length();i++) {
        for (int j=1;j<=y.length();j++) {
            if (x[i-1] == y[j-1]) {
                dp[i][j] = dp[i-1][j-1] + 1;
            } else {
                dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
            }
        }
    }

    cout << dp[x.length()][y.length()];

    return 0;
}