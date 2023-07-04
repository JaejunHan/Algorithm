#include <cstdio>
#define MAX 9

using namespace std;

int n, m;
int arr[MAX] = {0, };
int visit[MAX] = {false, };

void dfs (int num, int cnt) {
    if (cnt == m) {
        for (int i=0;i < m;i++) {
            printf("%d ", arr[i]);
        }
        printf("\n");
        return;
    }
    for (int i=num;i <= n; i++) {
        if (!visit[i]) {
            visit[i] = true;
            arr[cnt] = i;
            dfs(i+1, cnt+1);
            visit[i] = false;
        }
    }
}

int main() {
    scanf("%d %d", &n, &m);
    dfs(1, 0);

    return 0;
}