#include <iostream>
#include <queue>
#include <algorithm>
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
    queue<int> q;
    for (int i=0; i< N;i++) {
        cin >> x;
        if (x == "push") {
            cin >> num;
            q.push(num);
        } else if (x == "pop") {
            if (!q.empty()) {
                cout << q.front() << "\n";
                q.pop();
            } else {
                cout << -1 << "\n";
            }
        } else if (x == "front") {
            if (!q.empty()) {
                cout << q.front() << "\n";
            } else {
                cout << -1 << "\n";
            }
        } else if (x == "back") {
            if (!q.empty()) {
                cout << q.back() << "\n";
            } else {
                cout << -1 << "\n";
            }
        } else if (x == "empty") {
            if (!q.empty()) {
                cout << 0 << "\n";
            } else {
                cout << 1 << "\n";
            }
        } else if (x == "size") {
            cout << q.size() << "\n";
        }
    }

    return 0;
}