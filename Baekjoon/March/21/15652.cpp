#include <cstdio>
#define MAX 9
using namespace std;

int n, m;

int arr[MAX] = {0, };

void dfs(int min_num, int cnt) {
    if (cnt == m) {
        for (int i=0;i<m;i++) {
            printf("%d ", arr[i]);
        }
        printf("\n");
        return;
    }
    for (int i=min_num;i <= n; i++) {
        arr[cnt] = i;
        dfs(i, cnt+1);
    }
}

int main () {
    scanf ("%d %d", &n, &m);
    dfs(1, 0);
    return 0;
}