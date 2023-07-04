#include <iostream>

using namespace std;



int main() {
    
    int dp[12];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    for (int i=4;i<12;i++) {
        dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
    }

    int num;
    cin >> num;
    for (int i=0;i<num;i++) {
        int temp;
        cin >> temp;
        cout << dp[temp] << endl;
    }

    return 0;
}


// 1

// 2
// 1+1

// 3
// 2 + 1
// 1+1+1
// 1+2

// 4
// 3+1
// 2+1+1
// 1+1+1+1
// 1+2+1
// 2+2
// 1+1+2
// 1+3