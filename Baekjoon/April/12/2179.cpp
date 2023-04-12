#include <vector>
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;


int commonString(string x, string y) {
    int cnt = 0;
    int min_len = min(x.size(), y.size());

    for (int i=0 ; i<min_len;i++) {
        if (x[i]==y[i]) {
            cnt++;
        } else {
            break;
        }
    }
    return cnt;
}

bool isSame(string x, string y) {
    if (x.size() != y.size()) {
        return false;
    }

    for (int i=0 ; i<x.size();i++) {
        if (x[i]!=y[i]) {
            return false;
        }
    }

    return true;
}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N;
    cin >> N;

    vector<pair<string, int>> v;
    string x;
    for (int i=0; i<N; i++) {
        cin >> x;
        v.push_back({x, i});
    }
    sort(v.begin(), v.end());

    int max_len = 0;
    int pos1 = 987654321;
    int pos2 = -987654321;
    string ans1, ans2;
    for (int i=0; i< N-1; i++) {
        if (isSame(v[i].first, v[i+1].first))
            continue;
        int cnt = commonString(v[i].first, v[i+1].first);
        string last;
        if (v[i].second < v[i+1].second) {
            last = v[i].first;
        } else {
            last = v[i+1].first;
        }

        int min_pos = min(v[i].second, v[i+1].second);
        int max_pos = max(v[i].second, v[i+1].second);
        if (max_len < cnt) {
            max_len = cnt;
            pos1 = min_pos;
            pos2 = max_pos;
            if (v[i].second < v[i+1].second) {
                ans1 = v[i].first;
                ans2 = v[i+1].first;
            } else {
                ans2 = v[i].first;
                ans1 = v[i+1].first;
            }
        } else if (max_len == cnt && min_pos < pos1) {
            max_len = cnt;
            pos1 = min_pos;
            pos2 = max_pos;
            if (v[i].second < v[i+1].second) {
                ans1 = v[i].first;
                ans2 = v[i+1].first;
            } else {
                ans2 = v[i].first;
                ans1 = v[i+1].first;
            }
        } else if (max_len == cnt && min_pos < pos2 && cnt == commonString(ans1, last)) {
            pos2 = min_pos;
            if (v[i].second < v[i+1].second) {
                ans2 = v[i].first;
            } else {
                ans2 = v[i+1].first;
            }
        }
    }

    cout << ans1 << "\n";
    cout << ans2;

    return 0;
}