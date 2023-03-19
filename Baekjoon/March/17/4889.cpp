#include <string>
#include <iostream>
#include <stdio.h>
#include <deque>

using namespace std;

int main() {
    
    int count = 1;
    while (true) {
        string x;
        cin >> x;

        if (x.find('-') != string::npos) {
            break;
        }

        deque<char> dq;

        for (int i=0;i < x.length();i++) {
            if (x[i] == '{') {
                dq.push_back('{');
            } else {
                if (!dq.empty() && dq.back() == '{') {
                    dq.pop_back();
                } else {
                    dq.push_back('}');
                }
            }
        }

        short cnt=0;
        while (!dq.empty()) {
            char c1 = dq.front();
            dq.pop_front();
            char c2 = dq.front();
            dq.pop_front();

            if (c1 == c2) {
                cnt += 1;
            } else {
                cnt += 2;
            }
        }


        cout << count << ". " << cnt << "\n";
        count += 1;
    }
    return 0;
}