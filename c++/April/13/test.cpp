#include <iostream>
#include <sstream>
#include <cctype>

using namespace std;

int main() {

    string temp = "10S2D*3T";
    int x, y, z;
    char x1, x2, y1, y2, z1, z2;
    x2 = '\0';
    y2 = '\0';
    z2 = '\0';


    istringstream iss(temp);
    iss >> x >> x1;
    // next is 2 so, not storeing in x2, store int into y,
    if (!isdigit(iss.peek())) {
        iss >> x2;
    }
    iss >> y >> y1;
    if (!isdigit(iss.peek())) {
        iss >> y2;
    }
    
    iss >> z >> z1;
    if (!isdigit(iss.peek())) {
        iss >> z2;
    }
    // how can I know next iss is digit or not?
    
    istringstream iss2(temp);
    string hello;
    while (getline(iss2, hello, '*')) {
        cout << hello << "\n";
    }

    return 0;
}