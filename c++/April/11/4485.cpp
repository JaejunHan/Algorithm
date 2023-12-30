#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>
#include <tuple>
#include <cmath>
#define MAX 126

using namespace std;

int arr[MAX][MAX] = {{0}};
vector<vector<int>> dik(MAX, vector<int> (MAX, INFINITY));

void clear(int n) {
    for (int i=0; i<=n; i++) {
        for (int j=0; j <= n; j++) {
            dik[i][j] = INFINITY;
        }
    }

    for (int i=0; i< n; i++) {
        for (int j=0;j <n;j++)  {
            cin >> arr[i][j];
        }
    }
}

int main () {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int index = 0;
    while (true) {
        index++;
        int n;
        cin >> n;
        if (n == 0) {
            break;
        }

        clear(n);

        priority_queue<tuple<int, int, int>> pq;
        pq.push({-1 * arr[0][0], 0, 0});
        dik[0][0] = arr[0][0];
        while (!pq.empty()) {
            tuple<int, int, int> f = pq.top();
            pq.pop();
            
            int cur = get<0>(f);
            int row = get<1>(f);
            int col = get<2>(f);

            if (row-1 >=0 && dik[row-1][col] > cur*-1 + arr[row-1][col]) {
                int nxt = cur*-1 + arr[row-1][col];
                dik[row-1][col] = nxt;
                pq.push({-1*nxt, row-1, col});
            }
            if (row+1 <n && dik[row+1][col] > cur*-1 + arr[row+1][col]) {
                int nxt = cur*-1 + arr[row+1][col];
                dik[row+1][col] = nxt;
                pq.push({-1*nxt, row+1, col});
            }
            if (col-1 >=0 && dik[row][col-1] > cur*-1 + arr[row][col-1]) {
                int nxt = cur*-1 + arr[row][col-1];
                dik[row][col-1] = nxt;
                pq.push({-1*nxt, row, col-1});
            }
            if (col+1 <n && dik[row][col+1] > cur*-1 + arr[row][col+1]) {
                int nxt = cur*-1 + arr[row][col+1];
                dik[row][col+1] = nxt;
                pq.push({-1*nxt, row, col+1});
            }
        }

        cout << "Problem " << index << ": " << dik[n-1][n-1] << "\n";
    }

    return 0;
}