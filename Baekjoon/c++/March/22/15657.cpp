#include <iostream>
#include <vector>
#include <algorithm>
#define MAX 9

using namespace std;

int n, m;
int arr[MAX] = {0, };
vector<int> v;

void dfs(int num, int cnt) {
    if (cnt == m) {
        for (int i=0;i<m;i++) {
            cout << arr[i] << " ";
        }
        cout << endl;
        return;
    }
    for (int i=0; i<n;i++) {
        if (v[i] >= num) {
            arr[cnt] = v[i];
            dfs(v[i], cnt+1);
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> m;
    for (int i=0;i <n;i++) {
        int temp;
        cin >> temp;
        v.push_back(temp);
    }
    sort(v.begin(), v.end());

    dfs(1, 0);

    return 0;
}