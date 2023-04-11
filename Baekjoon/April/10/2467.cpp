#include <iostream>
#include <vector>
#include <deque>
#include <set>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N;
    cin >> N;

    vector<int> v;

    int temp;
    for (int i= 0; i< N;i++) {
        cin >> temp;
        v.push_back(temp);
    }

    int a= v[0], b=v[v.size()-1], sum = abs(a + b);
    for (int i=0; i < v.size()-1; i++) {
        int ans;
        int target = -1 * v[i];
        
        int left = i+1;
        int right = v.size() - 1;
        int mid= (left + right) / 2;

        while (left < right) {
            if (target < v[mid]) {
                right = mid;
            } else if (target > v[mid]) {
                left = mid + 1;
            } else {
                break;
            }
            mid = (left + right) / 2;
        }

        ans = mid;
        if (i == mid) {
            ans = mid + 1;
        } else {
            if (mid-1 >=0 && abs(v[i]+v[mid-1]) < abs(v[i] + v[mid]) && mid-1 != i) {
                ans = mid - 1;
            }
            if (mid+1 < v.size() && abs(v[i]+v[mid+1]) < abs(v[i] + v[mid])) {
                ans = mid + 1;
            }
        }

        if (abs(v[i]+ v[ans]) <= sum) {
            a = v[i];
            b = v[ans];
            sum = abs(v[i]+ v[ans]);
        }
    }

    // int l = 0, r = N - 1;
    // int a,b;
    // int sum = 2000000000;
    // while(l<r){
    //     int tmpSum = v[l] + v[r];

    //     if(abs(sum) > abs(tmpSum)) {
    //         sum = tmpSum;
    //         a = v[l];
    //         b = v[r];
    //     }

    //     if(tmpSum == 0) break;
    //     else if(tmpSum > 0) r--;
    //     else l++;
    // }   
    
    cout << a << " " << b;

    return 0;
}