#include <algorithm>
#include <iostream>
#include <cstring>
#include <queue>
#define MAX 51

using namespace std;

int N, M;
int mp[MAX][MAX];
int ans=0;
// int dx[] = {-1, 0, 1, 0};
// int dy[] = {0, 1, 0, -1};
int dx[] = {1, 0, -1, 0};
int dy[] = {0, -1, 0, 1};

bool isSurroundingClean(int r, int c) {
    for (int i=0; i< 4; i++) {
        int nx = r + dx[i];
        int ny = c + dy[i];
        if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
            continue;
        }
        if (mp[nx][ny] == 0) {
            return false;
        }
    }
    return true;
}

int main() {
    memset(mp, 0, sizeof(mp));
    int r, c, d;

    cin >> N >> M;
    cin >> r >> c >> d;

    for (int i=0; i < N; i++) {
        for (int j=0; j < M; j++) {
            cin >> mp[i][j];
        }
    }

    queue<pair<int, int>> q;
    q.push({r, c});
    while (!q.empty()) {
        r = q.front().first;
        c = q.front().second;
        q.pop();
        if (mp[r][c] == 0) {
            ans++;
            mp[r][c] = -1;
        }

        if (isSurroundingClean(r, c)) { // 청소되지 않은 칸이 주변에 아예 없음
            int nx = r + dx[d];
            int ny = c + dy[d];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) { // 범위에서 벗어나면 작동을 멈춤
                break;
            }
            if (mp[nx][ny] == -1) { // 청소 되어있는 칸이면
                q.push({nx, ny});
                continue;
            }
        } else { // 청소되지 않는 칸이 주변에 하나라도 있음
            for (int i=0; i < 4;i++) {
                d = (d+3) % 4;
                int tmp = (d+2) % 4;
                int nx = r + dx[tmp];
                int ny = c + dy[tmp];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) { // 범위에서 벗어나면 다음으로 넘어감
                    continue;
                }
                if (mp[nx][ny] == 0) {
                    q.push({nx, ny});
                    break;
                }
            }
        }       
    }

    cout << ans;

    return 0;
}