#include <vector>
#include <algorithm>
#include <string>
#include <iostream>
#include <deque>

using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    short N;
    cin >> N;
    for (short i=0; i < N; i++) {
        bool isReverse = false, error = false;
        string order;
        cin >> order;
        int m;
        cin >> m;
        string str;
        cin >> str;

        deque<int> dq;

        string s="";
        for (int j=0; j < str.length();j++) {
            if (isdigit(str[j])) {
                s += str[j];
            } else {
                if (!s.empty()) {
                    dq.push_back(stoi(s));       
                }         
                s = "";
            }
        }

        for (auto ele: order) {
            if (ele == 'R') {
                isReverse = !isReverse;
            } else {
                if (dq.empty()) {
                    cout << "error" << endl;
                    error = true;
                    break;
                }

                if (isReverse) {
                    dq.pop_back();
                } else {
                    dq.pop_front();
                }
            }
        }

        if (error) continue;
        
        cout << '[';

        if (!dq.empty() && isReverse) {
            for (auto ele = dq.rbegin(); ele != dq.rend(); ele++) {
                if (ele == dq.rend()-1)
                    cout << *ele;
                else
                    cout << *ele << ',';
            }
        } else if (!dq.empty() && !isReverse) {
            for (auto ele = dq.begin(); ele != dq.end(); ele++) {
                if (ele == dq.end()-1)
                    cout << *ele;
                else
                    cout << *ele << ',';
            }
        }
        cout << "]" << endl;

    }

    return 0;
}


