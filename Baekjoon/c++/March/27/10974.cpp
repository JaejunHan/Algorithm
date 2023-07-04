#include <iostream>
#include <algorithm>
#include <vector>
#define MAX 9

using namespace std;


short N;
vector<short> v;
bool visited[MAX] = {false, };

void dfs(short depth) {
    if (depth == N) {
        for (short i=0; i< N; i++) {
            cout << v[i] << " ";
        }
        cout << "\n";
        return;
    }

    for (short i=1; i <= N; i++) {
        if (!visited[i]) {
            visited[i] = true;
            v.push_back(i);
            dfs(depth+1);
            v.pop_back();
            visited[i] = false;
        }
    }

}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;

    dfs(0);
    
    return 0;
}