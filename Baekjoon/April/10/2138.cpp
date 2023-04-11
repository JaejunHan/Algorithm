#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int N;
string x, y;
int cnt;
int final_cnt;

char flip(char ch) {
    if (ch == '0') {
        return '1';
    } else {
        return '0';
    }
}

bool isPossible(string& k) {
    bool ans = false;
    for (int i=1; i < N-1; i++) {
        if (k[i-1] != y[i-1]) {
            cnt += 1;
            k[i-1] = flip(k[i-1]);
            k[i] = flip(k[i]);
            k[i+1] = flip(k[i+1]);
        }
    }
    if (k[N-2] != y[N-2]) {
        cnt += 1;
        k[N-2] = flip(k[N-2]);
        k[N-1] = flip(k[N-1]);
    }
    if (k[N-1] == y[N-1]) {
        ans = true;
    }

    return ans;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> N;
    cin >> x;
    cin >> y;

    string tmp = x;

    cnt = 0;
    bool able1 = isPossible(tmp);
    int cnt1 = cnt;

    tmp = x;
    cnt = 1;
    tmp[0] = flip(tmp[0]);
    tmp[1] = flip(tmp[1]);
    bool able2 = isPossible(tmp);
    int cnt2 = cnt;

    if (able1 && able2) {
        cout << min(cnt1, cnt2);
    } else if (able1 && !able2) {
        cout << cnt1;
    } else if (!able1 && able2) {
        cout << cnt2;
    } else {
        cout << -1;
    }

    return 0;
}