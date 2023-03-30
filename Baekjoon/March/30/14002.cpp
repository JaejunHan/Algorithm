#include <iostream>
#include <vector>
#include <algorithm>
#include <deque>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    vector<int> v;
    int dp[N];

    int ans = 0;
    int tmp;
    for (int i=0; i< N;i++) {
        cin >> tmp;
        v.push_back(tmp);

        int dp_max = 0;

        for (int j=0; j < i; j++) {
            if (v[i] > v[j] && dp_max < dp[j])
                dp_max = dp[j];
        }

        dp[i] = ++dp_max;
        ans = max(dp_max, ans);
    }

    cout << ans << "\n";

    deque<int> dq;
    for (int i=N-1; i>=0;i--) {
        if (dp[i] == ans) {        
            dq.push_front(v[i]);
            ans--;
        }

        if (ans == 0) {
            break;
        }
    }


    while (!dq.empty()) {
        cout<< dq.front() << " ";
        dq.pop_front();
    }

    return 0;
}