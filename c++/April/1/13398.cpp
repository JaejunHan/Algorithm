#include <iostream>
#include <algorithm>
#define MAX 100001
using namespace std;

int a[MAX] = {0};
int d[MAX][2] = {{0}};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    int ans = a[0];
    for (int i = 0; i < n; i++) {
        d[i][0] = d[i][1] = a[i];
        if (i==0) {
            continue;
        }
        d[i][0] = max(d[i-1][0] + a[i], a[i]);
        d[i][1] = max(d[i-1][0], d[i-1][1] + a[i]);
        ans = max(ans,max(d[i][0], d[i][1]));
    }

    cout << ans << '\n';
    return 0;
}