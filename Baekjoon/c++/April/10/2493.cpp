#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios_base:: sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N;
    cin >> N;

    vector<pair<int, int>> v;
    
    int temp;
    for (int i=1; i <= N;i++){
        cin >> temp;
        while (v.size() != 0 && v.back().first < temp) {
            v.pop_back();
        }
        if (v.size() == 0) {
            cout << "0 ";
        } else {
            cout << v.back().second << " ";
        }
        v.push_back({temp, i});
    }

    return 0;
}