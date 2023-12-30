#include <iostream>

using namespace std;

// int factor_sum(int n) {
//     int ret = 0;
//     for (int i=1;i*i<=n;i++) {
//         if (n % i == 0) {
//             if (n/i == i) {
//                 ret += i;
//             } else {
//                 ret += i + (n/i);
//             }
//         }
//     }
//     return ret;
// }

int main () {
    long long ans = 0;
    int N;
    cin >> N;

    for (int i=1; i<= N; i++) {
        ans += (N/i) * i;
    }

    cout << ans;
    return 0;
}