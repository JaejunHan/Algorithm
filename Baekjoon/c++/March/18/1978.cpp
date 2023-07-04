#include <iostream>

using namespace std;

bool isPrime(int n){
    if (n == 1) {
        return false;
    }

    for (int i=2;i*i<=n;i++) {
        if (n%i == 0){
            return false;
        }
    }
    return true;
}

int main () {
    short N;
    cin >> N;

    int cnt = 0;
    for (short i=0;i<N;i++) {
        int num;
        cin >> num;
        if (isPrime(num)) {
            cnt += 1;
        }
    }

    cout << cnt;

    return 0;
}