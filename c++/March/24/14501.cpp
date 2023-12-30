#include <vector>
#include <iostream>
#include <cmath>

using namespace std;


int N;
int ans = -INFINITY;
vector<pair<short, short>> v;

void dfs(int sum, int day) {
    if (day == N) {
        if (sum > ans) ans = sum;
        return;
    }
    for (int i=day;i<N;i++) {
        if (i+v[i].first > N) {
            dfs(sum, N);
            continue;
        }
        dfs(sum + v[i].second, i+v[i].first);
    }
}


int main() {
    cin >> N;

    for (int i=0; i < N; i++) {
        int t, p;
        cin >> t >> p;
        v.push_back({t, p});
    }

    dfs(0, 0);

    cout << ans;

    return 0;
}