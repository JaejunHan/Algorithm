#include <string>
#include <vector>
#include <deque>
#include <iostream>
#include <cctype>
#include <cstring>

using namespace std;

bool find(deque<string>& dq, string x){
    for (int i=0; i< dq.size();i++) {
        if (dq[i] == x) {
            int j = i;
            while (true) {
                if (j == dq.size()-1) {
                    break;
                }
                swap(dq[j], dq[j+1]);
                j++;
            }
            return true;
        }
    }
    return false;
}

string lowercase(string x) {
    string ans = "";
    for (auto c: x) {
        ans += tolower(c);
    }
    return ans;
}

int solution(int cacheSize, vector<string> cities) {
    int ans = 0;
    if (cacheSize == 0) {
        return 5* cities.size();
    }
    deque<string> dq;
    for (int i=0; i<cities.size();i++) {
        if (find(dq, lowercase(cities[i]))) {
            ans +=1;
        } else {
            if (dq.size() == cacheSize) {
                dq.pop_front();
            }
            dq.push_back(lowercase(cities[i]));
            ans += 5;
        }
    }
    return ans;
}

int main() {
    vector<string> x = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
    int a = solution(10, x);
    cout << a;
    return 0;
}

// 	["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"]
// 5  5  5 1 1 1 1 1 1

// ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]
// 5 5 5 5 5 5 5 5 5 5