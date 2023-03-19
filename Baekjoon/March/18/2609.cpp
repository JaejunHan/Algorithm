#include <algorithm>
#include <iostream>

using namespace std;

int main () {
    int A, B;
    cin >> A >> B;

    int minValue = min(A, B);

    int gcd = 1;
    int mul = A*B;
    for (int i=2; i<= minValue;i++) {
        while (A%i == 0 && B%i == 0) {
            gcd *= i;
            A = A/i;
            B = B/i;
            minValue = min(A, B);
        }
    }

    cout << gcd << endl;
    cout << mul / gcd <<endl;


    return 0;
}