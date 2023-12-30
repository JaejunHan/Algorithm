#include <iostream>
#include <vector>

using namespace std;

int main() {
    int N, a, b;
    cin >> N >> a >> b;

    if (a + b > N + 1) {
        cout << -1 << endl;
        return 0;
    }

    vector<int> heights(N);
    int curHeight = 1;

    // 가희가 볼 수 있는 건물 높이 설정
    for (int i = 0; i < a; i++) {
        heights[i] = curHeight++;
    }

    // 단비가 볼 수 있는 건물 높이 설정
    curHeight = max(curHeight, N - b + 2);
    for (int i = N - b; i < N; i++) {
        heights[i] = curHeight++;
    }

    // 출력
    for (int i = 0; i < N; i++) {
        cout << heights[i] << " ";
    }
    cout << endl;

    return 0;
}