#include <iostream>
#include <queue>
#include <algorithm>
#include <cstring>
#include <vector>

#define MAX 101

using namespace std;

int mp[MAX][MAX];
bool visited[MAX][MAX][MAX*MAX];

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

struct node {
    int x;
    int y;
    int cnt;
};

struct cmp {
    bool operator() (node a, node b) {
        return a.cnt > b.cnt;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0); 

    int n, m;
    cin >> m >> n;

    memset(mp, 0, sizeof(mp));
    memset(visited, false, sizeof(visited));

    char tmp;
    for (int i=0; i< n; i++) {
        for (int j=0; j < m; j++) {
            cin >> tmp;
            mp[i][j] = tmp - '0';
        }
    }

    priority_queue<node, vector<node>, cmp> q;
    q.push({0, 0, 0});
    visited[0][0][0] = true;

    int ans = 0;
    while (!q.empty()) {
        node curr = q.top();
        q.pop();

        if (curr.x == n-1 && curr.y == m-1) {
            ans = curr.cnt;
            break;
        }

        for (int i=0;i <4;i++) {
            int nx = curr.x + dx[i];
            int ny = curr.y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }
            if (mp[nx][ny] == 0 && !visited[nx][ny][curr.cnt]) {
                visited[nx][ny][curr.cnt] = true;
                q.push({nx, ny, curr.cnt});
            } else if (mp[nx][ny] == 1 && !visited[nx][ny][curr.cnt+1]) {
                visited[nx][ny][curr.cnt+1] = true;
                q.push({nx, ny, curr.cnt+1});
            }
        }
    }
    
    cout << ans;

    return 0;
}