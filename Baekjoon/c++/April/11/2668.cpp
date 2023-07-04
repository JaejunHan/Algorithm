#include <vector>
#include <algorithm>
#include <iostream>
#include <set>
#define MAX 101

using namespace std;

int index[MAX] = {0};
bool visited[MAX] = {false};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N;
    cin >> N;

    int df = 0;
    set<int> df_set;

    for (int i=1; i<= N; i++) {
        cin >> index[i];
        if (index[i] == i) {
            df++;
            df_set.insert(i);
        }
    }

    vector<int> ans;

    int max_len=0;
    
    for (int i=1; i <= N; i++) {
        for (int j=1; j<= N; j++) {
            visited[j] = false;
        }
        vector<int> temp;
        temp.push_back(i);
        visited[i] = true;

        int nxt = index[i];
        while (!visited[nxt]) {
            temp.push_back(nxt);
            visited[nxt] = true;
            nxt = index[nxt];
        }

        if (nxt == i) {
            for (auto ele: temp) {
                df_set.insert(ele);
            }
        }
    }

    cout << df_set.size() << "\n";
    for (auto ele: df_set) {
        cout << ele << "\n";
    }


    return 0;
}