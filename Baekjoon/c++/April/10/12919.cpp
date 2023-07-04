#include <iostream>
#include <vector>
#include <cstring>
#include <algorithm>
#include <deque>
using namespace std;
 
int n, k, x;
int ans = 0;
 
// 컨베이어 벨트의 내구도 측정 -> 0이 몇 개 인지 반환
int find(deque <int>& dq) {
	int ret = 0;
	for (int i = 0; i < dq.size(); i++) {
		if (dq[i] == 0) ret++;
	}
	return ret;
}
 
void simul(deque <bool>& check, deque <int>& dq) {
	while (1) {
		ans++;
		// 1. 벨트 회전
		dq.push_front(dq.back());
		dq.pop_back();
		// 벨트가 회전하면 위의 로봇들도 회전해야 함
		check.push_front(check.back());
		check.pop_back();
		if (check[n - 1] == true) check[n - 1] = false; // N번째 위치라면 로봇을 땅에 내림
		// 2. 가장 먼저 벨트에 올라간 로봇부터 회전하는 방향으로 한칸 이동
		// 로봇은 반드시 위 컨베이어 벨트에만 있을 것이다. (N 번째에 무조건 내리니까)
		for (int i = n - 2; i >= 0; i--) { // 어차피 먼저 벨트에 올라갔으면 맨 앞쪽에 있겠지
			if (check[i] == true && dq[i + 1] >= 1 && check[i + 1] == false) {// i번째에 로봇이 있다면, i+1 번째 내구도가 남아있다면
				dq[i + 1]--; // i+1번째로 옮길 것임 -> 즉 내구도 깎임
				check[i] = false; // 갱신
				if (i == n - 2) continue; // i+1 == n-1, 로봇을 땅에 내려야 함
				check[i + 1] = true;
			}
		}
		// 3. 로봇 올리기
		// 로봇이 올라갈 수 있는 조건 : 0번 칸에 내구도가 1 이상, 로봇이 없어야 함
		if (dq[0] >= 1 && check[0] == false) {
			check[0] = true;
			dq[0]--;
		}
		if (find(dq) >= k) break;
	}
}
 
int main() {
	cin >> n >> k;
    deque <bool> check; // 로봇이 있는지 없는지를 판단
    deque <int> dq; // 내구도가 저장된 덱
	for (int i = 0; i < 2 * n; i++) {
		cin >> x;
		dq.push_back(x);
		check.push_back(false);
	}
	simul(check, dq);
	cout << ans << "\n";
}