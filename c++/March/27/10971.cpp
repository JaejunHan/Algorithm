#include <iostream>
#include <vector>
#include <unordered_set>
#include <cmath>
#define MAX 11

using namespace std;


int N;
int ans = INFINITY;
bool visited[MAX];
vector<vector<int>> v;
unordered_set<int> s;

void dfs(short cnt, int sum, short current) {
    if (cnt == N-1) {
        if (v[current][0] != 0) {
            int temp = sum + v[current][0];
            if (ans > temp) ans = temp;
        }
        return;
    }
    for (int i=1; i < N; i++) {
        if (!visited[i] && v[current][i] != 0) {
            visited[i] = true;
            dfs(cnt+1, sum + v[current][i], i);
            visited[i] = false;
        }
    }
}

int main() {
    cin >> N;

    for (short i=0; i < N; i++) {
        s.insert(i);
    }

    for (int i=0; i< N; i++) {
        vector<int> temp;
        for (int j=0; j< N; j++) {
            int t;
            cin >> t;
            temp.push_back(t);
        }
        v.push_back(temp);
    }

    dfs(0, 0, 0);

    cout << ans;

    return 0;
}