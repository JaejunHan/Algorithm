#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


void dfs(int cur, vector<vector<int>>& v, bool* visited) {
    visited[cur] = 1;
    for (int i=0; i< v[cur].size();i++) {
        int nxt = v[cur][i];
        if (!visited[nxt]) {
            dfs(nxt, v, visited);
        }
    }
    return;
}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n, m;
    cin >> n >> m;

    vector<vector<int>> v(n+1);
    bool visited[n+1] = {false, };
    int a, b;
    for (int i=0; i<m;i++) {
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }

    int ans = 0;
    for (int i=1; i<=n; i++) {
        if (!visited[i]) {      
            ans++;
            dfs(i, v, visited);
        }
    }

    cout << ans;

    return 0;
}