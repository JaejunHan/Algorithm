#include <algorithm>
#include <iostream>
#include <cstring>
#include <vector>

using namespace std;

bool mp[101][101];
int dx[] = { 0, -1, 0, 1 };
int dy[] = { 1, 0 ,-1 ,0 };

vector<int> direction(int d, int g) {
    vector<int> ret = {d};
    for (int i=0; i < g; i++) {
        vector<int> tmp;
        for (int j = ret.size()-1; j >=0 ; j--) {
            tmp.push_back((ret[j] + 1) % 4);
        }

        ret.insert(ret.end(), tmp.begin(), tmp.end());
    }
    return ret;
}

int cnt() {
    int ans = 0;
    for (int i=0; i < 100; i ++) {
        for (int j =0; j< 100; j++) {
            if (mp[i][j] && mp[i+1][j] && mp[i][j+1] && mp[i+1][j+1]) {
                ans++;
            }
        }
    }
    return ans;
}

int main() {
    memset(mp, false, sizeof(mp));
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N, x, y, d, g;
    cin >> N;
    for (int i=0; i < N; i++) {
        cin >> y >> x >> d >> g;
        mp[x][y] = true;
        vector<int> dir = direction(d, g);
        for (auto ele: dir) {
            x = x + dx[ele];
            y = y + dy[ele];
            if (x < 0 || y < 0 || x > 100 || y > 100) {
                continue;
            }
            mp[x][y] = true;
        }
    }

    cout << cnt();

    return 0;
}