#include<iostream>
#include <queue>
#include <vector>

using namespace std;

char map[11][11];
int num;
vector<int> v;

bool possible(int idx)
{
    int sum = 0;

    for (int i = idx; i >= 0; i--)
    {
        // V[idx] 부터 V[i] 까지의 합
        sum += v[i];

        // V[idx] 부터 V[i] 까지의 합은 map[i][idx] 의 부호를 만족해야 한다
        if (map[i][idx] == '+' && sum <= 0)	return false;
        if (map[i][idx] == '-' && sum >= 0)	return false;
        if (map[i][idx] == '0' && sum != 0)	return false;
    }
    return true;
}

void solve(int idx)
{
    // 모든 조건을 만족하는 경우
    if (idx == num)
    {
        for (int i = 0; i < v.size(); i++)
            cout << v[i] << " ";
        return;
    }

    // -10 부터 10 까지
    for (int i = -10; i <= 10; i++)
    {
        v.push_back(i);

        // idx 번째의 숫자가 모든 조건을 만족한다면 idx+1번째로 진행
        if (possible(idx))
            solve(idx + 1);

        v.pop_back();
    }
}

int main(void)
{
    cin >> num;
    string s;
    cin >> s;

    int idx = 0;

    for (int i = 0; i < num; i++)
    {
        for (int j = i; j < num; j++)
        {
            map[i][j] = s[idx++];
        }
    }

    solve(0);

}