#include <iostream>
#include <deque>
#include <algorithm>
#include <cstring>
#define MAX 21

using namespace std;

int N, M, x, y, K;
int mp[MAX][MAX];
int bottom, top;
deque<int> vert = {0, 0, 0, 0};
deque<int> hori = {0, 0, 0, 0};

void copy(int x, int y) {
    if (mp[x][y] == 0) { //주사위의 수 -> 바닥에 복사
        mp[x][y] = bottom;
    } else { // 칸에 있는 수-> 주사위에 복사
        bottom = mp[x][y];
        mp[x][y] = 0;
        vert[0] = bottom;
        hori[0] = bottom;
    }
}

int main() {
    memset(mp, 0, sizeof(mp));

    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> N >> M >> x >> y >> K;

    for (int i=0; i< N; i++) {
        for (int j=0; j<M;j++) {
            cin >> mp[i][j];
        }
    }

    bottom = vert[0];
    top = vert[2];
    
    int tmp;
    for (int i=0; i < K; i++) {
        cin >> tmp;
        switch (tmp) {
            case 1:
                // check range
                y++;
                if (y >= M) {
                    y--;
                    continue;
                }

                // 주사위를 회전
                hori.push_back(hori.front());
                hori.pop_front();
                bottom = hori[0];
                top = hori[2];
                vert[0] = bottom;
                vert[2] = top;
                cout << top << "\n";

                copy(x, y);
                break;
            case 2:
                // check range
                y--;
                if (y < 0) {
                    y++;
                    continue;
                }

                // 주사위를 회전
                hori.push_front(hori.back());
                hori.pop_back();
                bottom = hori[0];
                top = hori[2];
                vert[0] = bottom;
                vert[2] = top;
                cout << top << "\n";

                copy(x, y);
                break;
            case 3:
                // check range
                x--;
                if (x < 0) {
                    x++;
                    continue;
                }

                
                // 주사위를 회전
                vert.push_front(vert.back());
                vert.pop_back();
                bottom = vert[0];
                top = vert[2];
                hori[0] = bottom;
                hori[2] = top;
                cout << top << "\n";

                copy(x, y);
                break;
            case 4:
                // check range
                x++;
                if (x >= N) {
                    x--;
                    continue;
                }

                // 주사위를 회전
                vert.push_back(vert.front());
                vert.pop_front();
                bottom = vert[0];
                top = vert[2];
                hori[0] = bottom;
                hori[2] = top;
                cout << top << "\n";
                copy(x, y);
                break;
        }
    }



    return 0;
}