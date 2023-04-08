#include <iostream>
#include <algorithm>
#include <deque>
#include <string>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N;
    cin >> N;

    string x;
    int num;
    deque<int> dq;
    for (int i=0; i< N; i++) {
        cin >> x;
        if (x == "push_front") {
            cin >> num;
            dq.push_front(num);
        } else if (x == "push_back") {
            cin >> num;
            dq.push_back(num);
        } else if (x == "pop_front") {
            if (!dq.empty()) {
                cout << dq.front() << "\n";
                dq.pop_front();
            } else {
                cout << -1 << "\n";
            }
        } else if (x == "pop_back") {
            if (!dq.empty()) {
                cout << dq.back() << "\n";
                dq.pop_back();
            } else {
                cout << -1 << "\n";
            }
        } else if (x == "size") {
            cout << dq.size() << "\n";
        } else if (x == "empty") {
            if (!dq.empty()) {
                cout << 0 << "\n";
            } else {
                cout << 1 << "\n";
            }
        } else if (x == "front") {
            if (!dq.empty()) {
                cout << dq.front() << "\n";
            } else {
                cout << -1 << "\n";
            }
        } else if (x == "back") {
            if (!dq.empty()) {
                cout << dq.back() << "\n";
            } else {
                cout << -1 << "\n";
            }
        }
    }

    return 0;
}