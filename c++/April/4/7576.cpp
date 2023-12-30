#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#define MAX 1001

using namespace std;

int M, N;

int tomato[MAX][MAX] = {{0}};
bool visited[MAX][MAX] = {{false}};
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
queue<pair<int, int>> q;

// void bfs(){
    
// }

bool checkDone() {
    for (int i=0; i<N;i++) {
        for (int j=0; j <M; j++) {
            if (tomato[i][j] == 0) {
                return false;
            }
        }
    }
    return true;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> M >> N;

    int temp;
    for (int i=0; i< N;i++) {
        for (int j=0; j<M;j++) {
            cin >> tomato[i][j];
            if (tomato[i][j] == 1){
                q.push({i, j});
                visited[i][j] = true;
            }
        }
    }

    int ans=0;
    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        ans = max(tomato[x][y], ans);
        for (int i=0; i< 4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >=0 && ny>=0 && nx <N && ny < M && !visited[nx][ny] && tomato[nx][ny] >= 0) {
                q.push({nx, ny});
                visited[nx][ny] = true;
                tomato[nx][ny] = tomato[x][y] + 1;    
            }
        }
    }

    if (checkDone()) {
        cout << ans-1;
    } else {
        cout << -1;
    }

    return 0;
}