#include <cstdio>
#define MAX 9
using namespace std;


int m, n;

int arr[MAX] = {0, };
bool visit[MAX] = { false, };

void dfs(int cnt) {
    if (cnt == m) {
        for (int i=0;i <m; i++) {
            printf("%d ", arr[i]);
        }
        printf("\n");
        return;
    }
    for (int i=1; i<=n; i++) {
        if (!visit[i]) {
            visit[i] = true;
            arr[cnt] = i;
            dfs(cnt+1);
            visit[i] = false;
        }
    }
}

int main() {
    scanf("%d %d", &n, &m);
    dfs (0);
    return 0;
}