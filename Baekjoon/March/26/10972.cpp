#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    short N;
    cin >> N;

    vector<int> v;

    for (short i=0; i< N; i++) {
        int temp;
        cin >> temp;
        v.push_back(temp);
    }

    bool isBreak = false;
    for (short i=v.size()-1; i>=0; i--){
        if (i-1>=0 && v[i-1] < v[i]) {
            for (short j=v.size()-1; j>=i; j--) {
                if (v[j] > v[i-1]) {
                    swap(v[j], v[i-1]);
                    break;
                }
            }
            sort(v.begin() + i, v.end());
            isBreak = true;
            break;
        }
    }

    if (isBreak) {
        for (short i=0; i <v.size(); i++) {
            cout << v[i] << " ";
        }
    } else {
        cout << -1;
    }


    return 0;
}