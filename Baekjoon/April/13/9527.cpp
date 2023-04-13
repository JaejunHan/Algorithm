#include <bits/stdc++.h>
using namespace std;
 
long long a, b;
long long d[55];
 
long long go(long long x, long long i = 54) {
    long long ans = x & 1;
    for (; i > 0; i--) {
        if (x & (1LL << i)) {
            ans += d[i - 1] + (x - (1LL << i) + 1);
            x -= 1LL << i;
        }
    }
    return ans;
}
 
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
 
    d[0] = 1;
    for (long long i = 1; i < 55; i++) {
        d[i] = d[i - 1] * 2 + (1LL << i);
    }
    cin >> a >> b;
    cout << go(b) - go(a - 1);
}