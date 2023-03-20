#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<int> dp;
vector<bool> mal(10, false);

bool direct_possible(int num) {
    string s = to_string(num);
    for (int i=0;i < s.length();i++) {
        if (mal[s[i] - '0']) {
            return false;
        }
    }

    return true;
}

int main() {

    int n, c;
    cin >> n >> c;

    int tmp;

    for (int i=0; i < c; i++){
        cin >> tmp;
        mal[tmp] = true;
    }

    string st = to_string(n);

    int minimum = abs(n-100);
    for (int i=0; i <= 1000000; i++) {
        if (direct_possible(i)) {
            int temp = abs(n-i) + to_string(i).length();
            minimum = min(minimum, temp);
        }
    }

    cout << minimum << endl;
    return 0;
}