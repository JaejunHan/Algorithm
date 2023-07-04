#include <string>
#include <vector>

using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> ans;
    for (int i=0; i< arr1.size();i++) {
        int ele = arr1[i] | arr2[i];
        string tmp = "";
        for (int i=n-1;i >=0; i--) {
            if (ele & 1<<i) {
                tmp += "#";
            } else {
                tmp += " ";
            }
        }
        ans.push_back(tmp);
    }
    return ans;
}