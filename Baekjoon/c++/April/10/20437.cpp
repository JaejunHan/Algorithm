#include <iostream>
#include <vector>
#include <string>
#include <string.h>
#include <algorithm>
#include <unordered_map>
using namespace std;
 
int main(){
    
    int T;
    cin >> T;
    
    for (int i=0; i< T; i++) {
        unordered_map<short, vector<int>> mp;

        int mini = 100000;
        int maxi = -100;

        string x;
        int k;
        cin >> x;
        cin >> k;
        for (int i=0; i< x.length(); i++) {
            short num = x[i]-'a';
            mp[num].push_back(i); // 인덱스 저장
        }

        for (auto ele: mp) {
            int size = ele.second.size();
            // 3, 5인경우 0, 1, 2, 3, 4// 4 3 2 // 5-3+1
            if(ele.second.size() - k <0) {
                continue;
            }
            int end = size-k+1;
            for (int i=0; i < end; i++) {
                mini = min(mini, ele.second[i+k-1]-ele.second[i]+1);
                maxi = max(maxi, ele.second[i+k-1]-ele.second[i]+1);
            }
        }
        if (mini == 100000 || maxi == -100) {
            cout << -1 << "\n";
        } else {
            cout << mini << " " << maxi << "\n";
        }
    }
    
    return 0;
}