#include <string>
#include <vector>
#include <unordered_set>
#include <algorithm>
#include <iostream>

using namespace std;

int makeConnect(int N, int cnt) {
    int ans = 0;
    for (int i=0; i< cnt; i++) {
        ans = ans *10 + N;
    }
    return ans;
}

int solution(int N, int number) {
    int ans = 0;
    unordered_set<int> dp[number+1];
    for (int i=1; i<= number; i++) {
        dp[i].insert(makeConnect(N, i));
    }
    
    for (int i=2; i <=number; i++) {
        // cout << i << "\n";
        for (auto ele: dp[i-1]) {
            // cout << ele <<  " ";
            dp[i].insert(ele + N);
            if (ele - N > 0) {
                dp[i].insert(ele - N);
            }
            dp[i].insert(ele * N);
            
            if (ele / N > 0) {
                dp[i].insert(ele / N);
            }
        }
        // cout << "\n";
    }
    
    ans = *min_element(dp[number].begin(), dp[number].end());
    
    return ans;
}

int main() {

    int a = solution(5, 12);

    cout << a;
    return 0;
}