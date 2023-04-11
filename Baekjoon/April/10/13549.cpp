#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>

using namespace std;

const int MAX = 100000;

queue<int> q;

int main() {
int take[MAX+1] = {0};
bool visited[MAX+1] = {false};
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n, m;
    cin >> n >> m;

    q.push(n);
    take[n] = 0;
    visited[n] = true;
    int ans = -1;
    while (!q.empty()) {
        int pos = q.front();
        q.pop();

        if (pos == m) {
            ans = take[pos];
            while (!q.empty()) {
                q.pop();
            }
            break;
        }
        
        if (pos*2 <= MAX && !visited[pos*2]) {
            visited[pos*2] = true;
            take[pos*2] = take[pos];
            q.push(pos*2);
        }
        
        if (pos-1>=0 && !visited[pos-1]) {
            visited[pos-1] = true;
            take[pos-1] = take[pos] + 1;
            q.push(pos-1);
        }
        if (pos+1 <= MAX && !visited[pos+1]) {
            visited[pos+1] = true;
            take[pos+1] = take[pos] + 1;
            q.push(pos+1);
        }
    }

    cout << ans;

    return 0;
}