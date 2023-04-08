#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <queue>

using namespace std;


int N, M, V;

// bool dfs(int depth, int curr, vector<set<int>>& vs, vector<bool>& visitied, vector<int>& res) {
//     if (depth == N-1) {
//         for (auto ele: res) {
//             cout << ele << " ";
//         }
//         cout << "\n";
//         return true;
//     }
//     for (auto ele: vs[curr]) {
//         int nxt = ele -1;
//         if (!visitied[nxt]) {
//             visitied[nxt] = true;
//             res.push_back(ele);
//             if (dfs(depth+1, nxt, vs, visitied, res)) return true;
//             res.pop_back();
//             visitied[nxt] = false;
//         }
//     }
//     return false;
// }

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> N >> M >> V;

    vector<set<int>> vs(N);
    int a, b;
    for (int i=0; i< M; i++){
        cin >> a >> b;
        vs[a-1].insert(b);
        vs[b-1].insert(a);
    }


    // stack = 뒤에 넣고 뒤에 빼는거
    vector<int> res;
    res.push_back(V);
    vector<bool> visited(1000, false);
    // visited[V-1] = true;
    vector<int> dfs;
    dfs.push_back(V);
    // cout << V << " ";
    while (!dfs.empty()) {
        int back = dfs.back();
        dfs.pop_back();

        if (!visited[back-1]) {
            visited[back-1] = true;
            cout << back << " ";
            for (auto itr= vs[back-1].rbegin(); itr != vs[back-1].rend(); itr++) {
                // next(itr);
                auto ele = *itr;
                if (!visited[ele-1]){
                    dfs.push_back(ele);
                }
            }
        }
        // visited[back-1] = false;
    }
    // 1 2 4 3
    // 1 2 3 4
    // 1 3 2 4
    // ...
    cout << "\n";

    // dfs(0, V-1, vs, visited, res);
    visited[V-1] = false;
    vector<bool> visited2(1000, false);
    visited2[V-1] = true;
    queue<int> q;
    q.push(V);
    cout << V << " ";
    int cnt = 1;
    while (!q.empty()) {
        int front = q.front();
        q.pop();
        for (auto ele: vs[front-1]) {        
            int nxt = ele-1;
            if (!visited2[nxt]) {            
                visited2[nxt] = true;
                cout << ele << " ";
                q.push(ele);
            }
        }
    }

    return 0;
}