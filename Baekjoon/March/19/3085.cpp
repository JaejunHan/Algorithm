#include <string>
#include <stdio.h>
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

short ContiCnt (vector<vector<char>> &v) {
    short maximum = 0;
    for (short i=0; i < v.size(); i++) {
        short cnt = 1;
        for (short j=0; j< v[0].size();j++) {
            if (j+1 < v[0].size() && v[i][j] == v[i][j+1]) {
                cnt += 1;
            } else {
                if (cnt > maximum) {
                    maximum = cnt;
                }
                cnt = 1;
            }
        }
    }
    
    for (short j=0; j < v.size(); j++) {
        short cnt = 1;
        for (short i=0; i< v.size();i++) {
            if (i+1 < v.size() && v[i][j] == v[i+1][j]) {
                cnt += 1;
            } else {
                if (cnt > maximum) {
                    maximum = cnt;
                }
                cnt = 1;
            }
        }
    }
    return maximum;
}

int main () {
    short N;
    scanf("%hd", &N);

    vector<vector<char>> v;

    for (short i=0;i<N;i++) {
        string x;
        cin >> x;
        vector<char> temp;
        for (int j=0;j<N;j++) {
            temp.push_back(x[j]);
        }
        v.push_back(temp);
    }

    short ans=ContiCnt(v);
    short a;
    for (short i=0;i<N;i++) {
        for (short j=0;j<N;j++) {
            if (i+1 < N && v[i][j] != v[i+1][j]) {
                swap(v[i][j], v[i+1][j]);
                short res = ContiCnt(v);
                if (res > ans) {
                    ans = res;
                }
                swap(v[i+1][j], v[i][j]);
            }
            if (j+1 < N && v[i][j] != v[i][j+1]) {
                swap(v[i][j], v[i][j+1]);
                short res = ContiCnt(v);
                if (res > ans) {
                    ans = res;
                }
                swap(v[i][j+1], v[i][j]);
            }
        }
    }

    printf("%d\n", ans);

    return 0;
}