#include <string>
#include <iostream>

using namespace std;

int main () {
    string x;
    cin >> x;

    // ABCBA
    // 01234
    bool ispand = true;
    int len = x.length();
    for (int i=0; i < len/2; i++) {
        if (x[i] != x[len-1-i]) {
            ispand = false;
            break;
        }
    }

    bool isEqual = true;
    char ch = x[0];
    for (int i=0;i< len;i++) {
        if (x[i] != ch) {
            isEqual = false;
            break;
        }
    }


    if (isEqual) {
        cout << -1;
    } else if (ispand) {
        cout << x.length()-1;
    } else {
        cout << x.length();
    }

    return 0;
}