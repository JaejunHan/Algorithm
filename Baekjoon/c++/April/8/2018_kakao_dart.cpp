// #include <string>

// using namespace std;


// int main() {

//     return 0;
// }

#include <iostream>
#include <regex>
#include <vector>
#include <cctype>

using namespace std;


int solution(string dartResult) {
    regex regex("\\d+\\D*");
    vector<string> split(sregex_token_iterator(dartResult.begin(), dartResult.end(), regex), sregex_token_iterator());

    int ans = 0;
    int prev = 0;
    for (const auto ele: split) {
        int temp = 0;
        int endIndex = 0;
        for (int i=0; i < ele.size();i++) {
            if (isdigit(ele[i]) && isdigit(ele[i+1])) {
                temp += 10;
                endIndex = i+2;
                i++;
                continue;
            } else if (isdigit(ele[i])) {
                temp += ele[i]-'0';
                endIndex = i+1;
            }
            else if (i == endIndex) {
                if (ele[i] == 'S') {
                    temp = temp;
                } else if (ele[i] == 'D') {
                    temp = temp*temp;
                } else { // T
                    temp = temp*temp*temp;
                }
            } else if (i == endIndex+1) {
                if (ele[i] == '*') {
                    temp *=2;
                    ans += prev;
                } else if (ele[i] == '#') {
                    temp *= -1;
                }
            }
        }
        prev = temp;
        ans += temp;
    }

    return ans;
}

int main() {
    string x = 	"1D2S3T*";
    int a = solution(x);
    return 0;
}