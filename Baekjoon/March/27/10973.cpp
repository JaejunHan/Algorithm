#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {

    int N;
    cin >> N;

    vector<int> v;

    for (short i = 0; i < N; i++) {
        int temp;
        cin >> temp;
        v.push_back(temp);
    }

    bool isBreak = false;
    for (short i=v.size()-1; i>= 0; i--) {
        if (i >=1 && v[i-1] > v[i]) {
            for (short j=v.size()-1; j>= i;j--) {
                if (v[i-1] > v[j]) {
                    swap(v[i-1], v[j]);            
                    sort(v.begin()+i, v.end(), greater<int>());
                    isBreak = true;
                    break;
                }
            }
            if (isBreak) break;
        }
    }

    if (isBreak) {
        for (short i=0; i < N; i++ ){
            cout << v[i] << " ";
        }
    } else {
        cout << -1;
    }


    return 0;
}