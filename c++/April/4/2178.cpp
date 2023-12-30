#include <queue>
#include <algorithm>
#include <iostream>
#include <vector>
#include <string>
#define MAX 101

using namespace std;

int N, M;

int bfs(int row, int col, queue<pair<int, int>>& q, int m[MAX][MAX], bool visited[MAX][MAX]) {
    int ans = 0;
    visited[row][col] = true;
    while (!q.empty()) {
        int r = q.front().first;
        int c = q.front().second;
        int temp = m[r][c];
        if (r == N-1 && c == M-1) {
            ans = m[r][c];
            break;
        }
        q.pop();
        if (r-1 >=0 && m[r-1][c] != 0 && !visited[r-1][c]) {
            m[r-1][c] += m[r][c];
            visited[r-1][c] = true;
            q.push({r-1, c});
        }
        if (r+1 < N && m[r+1][c] != 0 && !visited[r+1][c]) {
            m[r+1][c] += m[r][c];
            visited[r+1][c] = true;
            q.push({r+1, c});
        }
        if (c-1 >=0 && m[r][c-1] != 0 && !visited[r][c-1]) {
            m[r][c-1] += m[r][c];
            visited[r][c-1] = true;
            q.push({r, c-1});
        }
        if (c+1 < M && m[r][c+1] != 0 && !visited[r][c+1]) {
            m[r][c+1] += m[r][c];
            visited[r][c+1] = true;
            q.push({r, c+1});
        }
    }

    return ans;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    
    int m[MAX][MAX] = {{0}};
    bool visited[MAX][MAX] = {{false}};    
    queue<pair<int, int>> q;
    cin >> N >> M;

    string x;
    for (int i=0;i < N; i++) {
        cin >> x;
        for (int j=0; j<M;j++) {
            m[i][j] = x[j] - '0';
        }
    }

    q.push({0, 0});
    int ans = bfs(0, 0, q, m, visited);

    cout << ans;

    return 0;
}