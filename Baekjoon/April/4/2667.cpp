#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#define MAX 26

using namespace std;

vector<int> ans;

char inp[MAX][MAX] = {{0}};
bool visited[MAX][MAX] = {{false}};
int N;
int cnt = 0;

void dfs(int row, int col) {
    cnt += 1;
    visited[row][col] = true;
    if (row-1 >= 0 && inp[row-1][col] == '1' && !visited[row-1][col]) {
        dfs(row-1, col);
    }
    if (row+1 < N && inp[row+1][col] == '1' && !visited[row+1][col]) {
        dfs(row+1, col);
    }
    if (col-1 >= 0 && inp[row][col-1] == '1' && !visited[row][col-1]) {
        dfs(row, col-1);
    }
    if (col+1 < N && inp[row][col+1] == '1' && !visited[row][col+1]) {
        dfs(row, col+1);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    
    // fill_n(&inp[MAX][MAX], MAX*MAX, 0);
    // fill_n(&visited[MAX][MAX], MAX*MAX, false);

    cin >> N;

    string x;

    for (int i=0; i< N; i++) {
        cin >> x;
        for (int j=0; j< x.size(); j++) {
            inp[i][j] = x[j];
        }
    }

    for (int i=0; i< N; i++) {
        for (int j=0; j<N; j++) {
            if (inp[i][j] == '1' && !visited[i][j]) {            
                cnt = 0;
                dfs(i, j);
                if (cnt != 0)
                    ans.push_back(cnt);
            }
        }
    }

    cout << ans.size() << "\n";
    sort(ans.begin(), ans.end());
    for (int i=0; i < ans.size(); i++) {
        cout << ans[i] << "\n";
    }

    return 0;
}