#include <vector>
#include <iostream>
#include <algorithm>


using namespace std;

void dfs(vector<short>& v, vector<short>& arr, int level, int cnt, int index) {
    if (cnt == 6) {
        for (int i=0; i < 6; i++) {
            cout << arr[i] << " ";
        }
        cout << "\n";
        return;
    } else if (cnt > 6) {
        return;
    }

    for (int i=index; i < level; i++) {
        arr.push_back(v[i]);
        dfs(v, arr, level, cnt+1, i+1);
        arr.pop_back();
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    while (true) {
        short temp;
        cin >> temp;
        if (temp == 0) break;

        vector<short> v;
        vector<short> arr;
        for (short i=0; i< temp; i++) {
            int t;
            cin >> t;
            v.push_back(t);
        }

        dfs(v, arr, temp, 0, 0);
        cout << "\n";
    }
    
    return 0;
}