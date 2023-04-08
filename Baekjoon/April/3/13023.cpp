#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;



bool dfs (int cnt, int start, vector<vector<int>>& v, vector<bool>& visited) {
    if (cnt == 4) {
        return true;
    }

    for (int i=0; i< v[start].size();i++) {
        int nxt = v[start][i];
        if (!visited[nxt]) {
            visited[nxt] = true;
            if (dfs(cnt+1, nxt, v, visited)){
                return true;
            }
            visited[nxt] = false;
        }
    }
    return false;
}



int main() {
    int m, n;
    cin >> m >> n;

    vector<vector<int>> v(m);

    int a, b;
    for (int i=0; i< n; i++) {
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }

    int ans = 0;
    for (int i=0; i< m;i++) {
        vector<bool> visitied(m, false);
        visitied[i] = true;
        if (dfs(0, i, v, visitied)){
            ans = 1;
            break;
        }
        visitied[i] = false;
    }

    cout << ans;

    return 0;
}