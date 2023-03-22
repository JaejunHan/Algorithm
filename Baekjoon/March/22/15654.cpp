#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#define MAX 9
using namespace std;

int n,m;
vector<short> v;
int arr[MAX] = {0, };
bool visited[MAX] = {false, };

void dfs(int cnt) {
    if (cnt == m) {
        for (int i=0;i<m;i++) {
            printf("%d ", arr[i]);
        }
        printf("\n");
        return;
    }
    for (int i=0;i < n; i++) {
        if (visited[i] == false) {
            visited[i] = true;
            arr[cnt] = v[i];
            dfs(cnt+1);
            visited[i] = false;
        }
    }
}


int main() {
    scanf("%d %d", &n, &m);
    
    for (short i=0; i< n; i++) {
        short n;
        cin >> n;
        v.push_back(n);
    }
    sort(v.begin(), v.end());
    dfs(0);

    return 0;
}