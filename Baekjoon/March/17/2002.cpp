#include <string>
#include <queue>
#include <iostream>
#include <unordered_map>


using namespace std;

int main () {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    short N;
    cin >> N;
    
    unordered_map<string, short> mp;

    for (short i=0; i < N; i++) {
        string x;
        cin >> x;
        mp[x] = i;
    }

    vector<short> v;
    for (short i=0; i< N; i++) {
        string x;
        cin >> x;
        v.push_back(mp[x]);
    }

    int ans = 0;
    for (short i=0;i < N;i++) {
        for (short j=i+1; j< N; j++) {
            if (v[j] < v[i]) {
                ans += 1;
                break;
            }
        }
    }
    cout << ans;

    return 0;
}