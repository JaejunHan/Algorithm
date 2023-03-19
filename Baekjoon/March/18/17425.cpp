#include <iostream>

using namespace std;

long long dp[1000001];

int main() {
    int N;
    cin >> N;

    for (int i=1; i<1000001; i++){
        for (int j=i; j<1000001; j+=i) {
            dp[j] += i;
        }
    }

    for (int i=2; i < 1000001; i++) {
        dp[i] += dp[i-1];
    }

    for (int i=0;i< N;i++) {    
        int num;
        cin >> num;
        cout << dp[num] << endl;
    }

    return 0;
}