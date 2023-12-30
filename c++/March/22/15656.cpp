#include <iostream>
#include <vector>
#include <algorithm>
#define MAX 9

using namespace std;

int  n, m;
vector<int> v;
int arr[MAX] = {0, };
bool visit[MAX] = {false, };


void dfs(int cnt) {
    if (cnt == m) {
        for (int i=0;i<m;i++) {
            cout << arr[i] << " ";
        }
        cout << "\n";
        return;
    }
    for (int i=0; i < n; i++) {
        arr[cnt] = v[i];
        dfs(cnt+1);
    }
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> m;
    for (int i=0;i < n; i++) {
        int temp;
        cin >> temp;
        v.push_back(temp);
    }
    sort(v.begin(), v.end());

    dfs(0);

    return 0;
}