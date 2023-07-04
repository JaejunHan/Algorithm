#include <iostream>
#include <vector>
#include <algorithm>
#define MAX 20

using namespace std;


int n, m;

void dfs(int index, int v_cnt, int c_cnt, char* arr, bool* visited, vector<char>& v) {
    if (v_cnt + c_cnt == n) {
        if (v_cnt >= 1 && c_cnt >= 2) {
            for (int i=0;i <n;i++) {
                cout << arr[i];
            }
            cout << endl;
        }
        return;
    }

    for (int i=index;i < m; i++) {
        if (!visited[i]) {
            visited[i] = true;
            arr[v_cnt+c_cnt] = v[i];
            if (v[i] == 'a' || v[i] == 'e' || v[i] == 'i' || v[i] == 'o' || v[i] == 'u') {            
                dfs(i+1, v_cnt+1, c_cnt, arr, visited, v);
            } else {
                dfs(i+1, v_cnt, c_cnt+1, arr, visited, v);
            }
            visited[i] = false;
        }
    }
}


int main() {
    char arr[MAX];
    bool visited[MAX] = {false, };
    vector<char> v;

    cin >> n >> m;

    for (int i=0;i<m;i++) {
        char temp;
        cin >> temp;
        v.push_back(temp);
    }
    sort (v.begin(), v.end());

    dfs(0, 0, 0, arr, visited, v);

    return 0;
}


// 1, 2, 3, 4, 5
// 1, 2, 3, 5, 4
// 1, 2, 