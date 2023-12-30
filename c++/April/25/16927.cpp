#include <algorithm>
#include <iostream>
#include <cstring>
#define MAX 301

using namespace std;

int mp[MAX][MAX];
int cp[MAX][MAX];
int n, m, r;

void copy() {
    for (int i=0; i < n; i++) {
        for (int j=0; j < m; j++) {
            mp[i][j] = cp[i][j];
        }
    }
}

void print() {
    for (int i=0; i < n; i++) {
        for (int j=0; j < m; j++) {
            cout << mp[i][j] << " ";
        }
        cout << "\n";
    }
}

void rotate(int r) {
    for (int box = 0; box < min(n, m)/2; box++) {
        int x = box;
        int y = box;
        int x_end = n-1-x;
        int y_end = m-1-y;
        int len_total = (x_end - x + 1 + y_end - y) * 2-2;

        int left_r = r % len_total;
        while(left_r--) {
            // 위쪽
            for (int j=y_end-1; j>=y; j--) {
                cp[x][j] = mp[x][j+1];
            }
            // 아래쪽
            for (int j=y+1; j <= y_end;j++) {
                cp[x_end][j] = mp[x_end][j-1];
            }
            
            // 왼쪽
            for (int i=x+1; i <= x_end;i++) {
                cp[i][y] = mp[i-1][y];
            }
            // 오른쪽
            for (int i=x_end-1; i >= x;i--) {
                cp[i][y_end] = mp[i+1][y_end];
            }

            // partial copy
            for (int i= x; i<=x_end; i++) {
                mp[i][y] = cp[i][y];
                mp[i][y_end] = cp[i][y_end];
            }
            for (int j= y; j<=y_end;j++) {
                mp[x][j] = cp[x][j];
                mp[x_end][j] = cp[x_end][j];
            }
        }
    }
}

int main() {
    memset(mp, 0, sizeof(mp));
    cin >> n >> m >> r;

    for (int i=0; i < n; i++) {
        for (int j=0; j < m; j++) {
            cin >>  mp[i][j];
        }
    }

    rotate(r);

    print();

    return 0;
}