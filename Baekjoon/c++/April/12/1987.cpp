#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
#define MAX 21

using namespace std;

char arr[MAX][MAX] = {{'\0'}};
bool visited[26] = {false};
int ans;
int R, C;

void dfs(int row, int col, int cnt) {
    ans = max(ans, cnt);
    if (row-1>=0 && !visited[arr[row-1][col]-'A']) {
        visited[arr[row-1][col]-'A'] = true;
        dfs(row-1, col, cnt+1);
        visited[arr[row-1][col]-'A'] = false;
    }
    if (row+1 < R && !visited[arr[row+1][col]-'A']) {
        visited[arr[row+1][col]-'A'] = true;
        dfs(row+1, col, cnt+1);
        visited[arr[row+1][col]-'A'] = false;
    }
    if (col-1>=0 && !visited[arr[row][col-1]-'A']) {
        visited[arr[row][col-1]-'A'] = true;
        dfs(row, col-1, cnt+1);
        visited[arr[row][col-1]-'A'] = false;
    }
    if (col+1 < C && !visited[arr[row][col+1]-'A']) {
        visited[arr[row][col+1]-'A'] = true;
        dfs(row, col+1, cnt+1);
        visited[arr[row][col+1]-'A'] = false;
    }

}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    ans = 0;
    cin >> R >> C;


    for (int i=0; i< R; i++) {
        for (int j=0; j< C; j++) {
            cin >> arr[i][j];
        }
    }

    visited[arr[0][0]-'A'] = true;
    dfs(0, 0, 1);

    cout << ans;
    
    return 0;
}