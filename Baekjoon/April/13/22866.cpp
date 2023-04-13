#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int N;
    cin >> N;

    vector<int> v;
    int temp;
    for (int i=0; i< N; i++) {
        cin >> temp;
        v.push_back(temp);
    }

    int cnt[N+1] = {0};
    int res[N+1] = {0};
    vector<pair<int, int>> ls;
    fill(res, res+N, -987654321);

    for (int i=0; i < N; i++) {
        while (!ls.empty()) {
            pair<int, int> p = ls.back();
            if (p.second > v[i]) {
                break;
            } else {
                ls.pop_back();
            }
        }
        cnt[i] += ls.size();
        if (!ls.empty())
            res[i] = ls.back().first;
        ls.push_back({i, v[i]});
    }
    ls.clear();

    for (int i=N-1; i >= 0; i--) {
        while (!ls.empty()) {
            pair<int, int> p = ls.back();
            if (p.second > v[i]) {
                break;
            } else {
                ls.pop_back();
            }
        }
        cnt[i] += ls.size();
        if (!ls.empty()) {
            int tmp = ls.back().first;
            if (i-res[i] > tmp-i) {
                res[i] = tmp;
            }
        }
        ls.push_back({i, v[i]});
    }

    for (int i=0; i < N; i++) {
        int tmp = cnt[i];
        if (tmp == 0) {
            cout << 0 << "\n";
        } else {
            cout << tmp << " " <<res[i]+1 << "\n";
        }
    }

    return 0;
}