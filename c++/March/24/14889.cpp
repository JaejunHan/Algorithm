#include <vector>
#include <algorithm>
#include <cmath>
#include <iostream>
#include <unordered_set>

using namespace std;

short n;
short half;

int ans = INFINITY;

int diff(vector<vector<short>>& v, unordered_set<short>& team1, unordered_set<short>& team2) {
    int sum1 = 0, sum2 = 0;
    for (auto i=team1.begin(); i != team1.end(); i++) {
        for (auto j=next(i); j != team1.end(); j++) {
            sum1 += v[*i-1][*j-1] + v[*j-1][*i-1];
        }
    }
    for (auto i=team2.begin(); i != team2.end(); i++) {
        for (auto j=next(i); j != team2.end(); j++) {
            sum2 += v[*i-1][*j-1] + v[*j-1][*i-1];
        }
    }

    return abs(sum1-sum2);
}


void dfs(int num, int cnt, vector<vector<short>>& v, unordered_set<short>& team1, unordered_set<short>& team2) {
    if (cnt == half) {
        for (auto ele: team1) {
            team2.erase(ele);
        }
        int temp = diff(v, team1, team2);
        for (auto ele: team1) {
            team2.insert(ele);
        }
        if (ans > temp)
            ans = temp;
        return;
    }
    for (short i=num; i <= n;i++) {
        team1.insert(i);
        dfs(i+1, cnt+1, v, team1, team2);
        team1.erase(i);
    }
}

int main() {
    
    unordered_set<short> team1;
    unordered_set<short> team2;
    vector<vector<short>> v;

    cin >> n;
    half = n/2;

    for (short i=1;i<=n;i++) {
        team2.insert(i);
    }

    for (short i=0; i< n; i++) {
        vector<short> ele;
        for (short j=0;j<n;j++) {
            short temp;
            cin >> temp;
            ele.push_back(temp);
        }
        v.push_back(ele);
    }
    
    team1.insert(1);
    dfs(2, 1, v, team1, team2);

    cout << ans;

    return 0;
}



//  

// 1, 2, 3

// 1, 2
// 1, 3
// 2, 3


// 1,2,3,4,5,6
// 1,2,3
// 4,5,6
