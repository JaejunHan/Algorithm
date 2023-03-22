#include <cstdio>
#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int n, m, k, maximum = -INFINITY;

bool validPosition(int i, int j, vector<vector<bool>>& visited) {
    if (visited[i][j]) return false;
    if (i-1>=0 && visited[i-1][j]) return false;
    if (j-1>=0 && visited[i][j-1]) return false;
    if (i+1<n && visited[i+1][j]) return false;
    if (j+1<m && visited[i][j+1]) return false;
    return true;
}


void dfs(int sum, int cnt, vector<vector<bool>>& visited, vector<vector<int>>& v) {
    if (cnt == k) {
        if (sum > maximum) {
            maximum = sum;
        }
        return;
    }
    for (int i=0 ; i< n; i++) {
        for (int j=0; j < m; j++) {
            if (validPosition(i, j, visited)) {
                visited[i][j] = true;
                dfs(sum+v[i][j], cnt+1, visited, v);
                visited[i][j] = false;
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    vector<vector<int>> v;
    vector<vector<bool>> visited;
    cin >> n >> m >> k;
    for (int i=0; i < n; i++) {
        vector<int> ele;
        vector<bool> visit_ele (m, false);
        for (int j=0;j < m;j++) {
            int temp;
            cin >> temp;
            ele.push_back(temp);
        }
        v.push_back(ele);
        visited.push_back(visit_ele);
    }

    dfs(0, 0, visited, v);

    cout << maximum;

    return 0;
}
