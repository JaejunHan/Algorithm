#include <algorithm>
#include <iostream>
#include <deque>
#include <cstring>

using namespace std;

int T, K, n, d;
deque<int> dq[1001];
short direction[1001];

int main() {
    memset(direction, 0, sizeof(direction));

    cin >> T;
    char tmp;
    for (int i=0; i < T; i++) {
        for (int j=0; j<8; j++) {
            cin >> tmp;
            dq[i].push_back(tmp-'0');
        }
    }

    cin >> K;
    for (int i=0; i< K; i++) {
        cin >> n >> d;
        direction[n-1] = d;
        for (int j=n-1; j < T-1;j++) {
            if (dq[j][2] != dq[j+1][6]) { // 극이 반대방향이면 회전
                direction[j+1] = -1* direction[j];
            } else { // 극이 같으면 회전 x
                break;
            }
        }
        for (int j=n-1; j >= 1; j--) {
            if (dq[j][6] != dq[j-1][2]) { // 극이 반대
                direction[j-1] = -1* direction[j];
            } else { // 극이 같으면 회전 x
                break;
            }
        }

        for (int j=0; j < T;j++) {
            if (direction[j] == 1) { // 시계 방향
                dq[j].push_front(dq[j].back());
                dq[j].pop_back();
            } else if (direction[j] == -1) { // 반시계 방향
                dq[j].push_back(dq[j].front());
                dq[j].pop_front();
            }
        }
        memset(direction, 0, sizeof(direction));
    }

    int ans = 0;
    for (int i=0; i< T; i++) {
        if (dq[i].front() == 1) {
            ans++;
        }
    }

    cout << ans;

    return 0;
}