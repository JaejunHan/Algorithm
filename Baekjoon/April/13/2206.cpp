#include <queue>
#include <tuple>
#include <vector>
#include <iostream>
#include <algorithm>
#define MAX 1001

using namespace std;
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int mp[MAX][MAX] = {{0}};
int visited[2][MAX][MAX] = {{{0}}};

int N, M;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> N >> M;

    char tmp;
    for (int i=0; i<N;i++) {
        for (int j=0; j<M;j++) {
            cin >> tmp;
            mp[i][j] = tmp - '0';
        }
    }

    queue<tuple<int, int, bool>> q;
    q.push({0, 0, true});
    visited[1][0][0] = 1;

    while (!q.empty()) {
        tuple<int, int, bool> tp = q.front();
        int x = get<0>(tp);
        int y = get<1>(tp);
        bool notUse = get<2>(tp);
        int block;
        if (notUse) {
            block = 1;
        } else {
            block = 0;
        }

        q.pop();
        
        if (x == N-1 && y == M-1) {
            break;
        }

        for (int i=0;i < 4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny <0 || ny >= M)
                continue;

            if (mp[nx][ny] == 1 && notUse) {
                q.push({nx, ny, !notUse});
                visited[0][nx][ny] = visited[1][x][y] + 1;
            } else if (mp[nx][ny] == 0 && visited[block][nx][ny] == 0) {
                q.push({nx, ny, notUse});
                visited[block][nx][ny] = visited[block][x][y] + 1;
            }
        }
    }

    if (visited[1][N-1][M-1] == 0 && visited[0][N-1][M-1] == 0) {
        cout << -1;
    } else if (visited[1][N-1][M-1] == 0) {
        cout << visited[0][N-1][M-1];
    } else if (visited[0][N-1][M-1] == 0) {
        cout << visited[1][N-1][M-1];
    } else if (visited[1][N-1][M-1] != 0 && visited[0][N-1][M-1] != 0) {
        cout << min(visited[1][N-1][M-1], visited[0][N-1][M-1]);
    }

    return 0;
}