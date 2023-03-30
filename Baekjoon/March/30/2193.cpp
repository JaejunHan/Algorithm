#include <iostream>
#include <algorithm>
#define MAX 91

using namespace std;

long long dp[MAX][2];

int main() {
    
    fill_n(&dp[0][0], MAX*2, 0);

    dp[1][0] = 0;
    dp[1][1] = 1; 
    dp[2][0] = 1;
    dp[2][1] = 1;

    for (short i=2; i < MAX; i++) {
        dp[i][0] = dp[i-1][0] + dp[i-1][1];
        dp[i][1] = dp[i-1][0];
    }


    int N;
    cin >> N;

    long long sum = 0;
    for (short i=0; i < 2; i++) {
        sum += dp[N][i];
    }

    cout << sum;

    return 0;

}