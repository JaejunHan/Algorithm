#include <string>
#include <stdio.h>
#include <iostream>
#include <vector>

using namespace std;

int main () {
    short N;
    scanf("%hd", &N);

    vector<vector<char>> v;

    for (short i=0;i<N;i++) {
        string x;
        getline(cin, x);
        for (int j=0;j<N;j++) {
            v[i].push_back(x[j]);
        }
    }

    for (short i=0;i<N;i++) {
        for (short j=0;j<N;j++) {
            for (short k=0;k<4;k++) {
                switch (k) {
                case 0:
                    if (i-1 >=0) {
                        v[i-1][j];
                    }
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                }

            }
        }
    }

    return 0;
}