#include <iostream>

using namespace std;

int main () {
    int n;
    int cnt = 0;

    while (cin >> n) {
        cnt = 1;
        int num = 1;
        
        while (num % n != 0) {
            num = num % n;
            num = 10 * num + 1;
            cnt += 1;
        }

        cout << cnt << endl;
    }

    return 0;
}