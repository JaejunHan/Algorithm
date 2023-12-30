#include <iostream>
#include <stdio.h>

using namespace std;

int main() {
    int a, b, c;
    cin >> a >> b >> c;

    if (a == 15) {
        a = 0;
    }
    if (c == 19) {
        c = 0;
    }

    int quo = 0;
    long long test;
    while (true) {
        test = quo * 28 + b;
        if (test % 15 == a && test % 19 == c) {
            break;
        }
        quo += 1;
    }

    cout << test << endl;

    return 0;
}