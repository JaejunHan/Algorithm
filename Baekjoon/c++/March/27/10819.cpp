#include <iostream>
#include <vector>
#include <algorithm>
#define MAX 9

using namespace std;

int N;
int half;
vector<int> v;
int ans;

bool visited[MAX] = {false, };


int getAns (vector<int>& arr);
void dfs1(vector<int>& arr, int cnt);
void dfs2(vector<int>& arr, int cnt);

int main () {
    cin >> N;
    half = N/2;

    for (int i=0;i < N; i ++) {
        int temp;
        cin >> temp;
        v.push_back(temp);
    }

    sort(v.begin(), v.end());
    ans = getAns(v);

    vector<int> arr;

    dfs1(arr, 0);
    dfs2(arr, 0);

    sort(v.begin(), v.end(), greater<int>());
    dfs1(arr, 0);
    dfs2(arr, 0);

    cout << ans;

    return 0;
}



int getAns (vector<int>& arr) {
    int ret = 0;
    for (short i=0; i< arr.size()-1; i++) {
        ret += abs(arr[i] - arr[i+1]);
    }
    return ret;
}

void dfs1(vector<int>& arr, int cnt) {
    if (cnt == N) {
        int temp = getAns(arr);
        if (temp > ans) ans = temp;
        return;
    }
    for (int i=0; i < half; i++) {
        if (!visited[i]) {
            visited[i] = true;
            arr.push_back(v[i]);
            dfs2(arr, cnt+1);
            arr.pop_back();
            visited[i] = false;
        }
    }
}

void dfs2(vector<int>& arr, int cnt) {
    if (cnt == N) {
        int temp = getAns(arr);
        if (temp > ans) ans = temp;
        return;
    }

    for (int i=half;i <N;i++) {
        if (!visited[i]) {
            visited[i] = true;
            arr.push_back(v[i]);
            dfs1(arr, cnt+1);
            arr.pop_back();
            visited[i] = false;
        }
    }
}
