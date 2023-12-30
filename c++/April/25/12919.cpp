#include <iostream>
#include <queue>
#include <algorithm>
#include <string>

using namespace std;

int main() {
    string x, y;
    cin >> x >> y;

    queue<string> q;
    q.push(y);

    bool isBreak = false;
    while (!q.empty()) {
        string f = q.front();
        q.pop();

        if (f == x) {
            isBreak = true;
            break;
        }

        if (f[f.size()-1] == 'A') {
            q.push(f.substr(0, f.size()-1));
        }
        if (f[0] == 'B') {
            string tmp = f;
            reverse(tmp.begin(), tmp.end());
            q.push(tmp.substr(0, tmp.size()-1));
        }
    }

    if (isBreak) {
        cout << 1;
    } else {
        cout << 0;
    }
}