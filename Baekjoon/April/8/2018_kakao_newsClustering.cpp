#include <string>
#include <set>
#include <algorithm>
#include <iostream>
#include <cctype>

using namespace std;

const int mul = 65536;

string lowerCase(string x) {
    string ans= "";
    for (auto ele: x) {
        ans += tolower(ele);
    }
    return ans;
}

int solution(string str1, string str2) {
    multiset<string> set1;
    multiset<string> set2;

    for (int i=0; i<str1.size()-1;i++){
        if (isalpha(str1[i]) && isalpha(str1[i+1])) {
            string temp = "";
            temp += tolower(str1[i]);
            temp += tolower(str1[i+1]);
            set1.insert(temp);
        }
    }

    for (int i=0; i<str2.size()-1;i++){
        if (isalpha(str2[i]) && isalpha(str2[i+1])) {
            string temp = "";
            temp += tolower(str2[i]);
            temp += tolower(str2[i+1]);
            set2.insert(temp);
        }
    }

    if (set1.size() == 0 && set2.size() ==0) {
        return mul;
    }

    multiset<string> inter;
    set_intersection(set1.begin(), set1.end(), set2.begin(), set2.end(),
                          inserter(inter, inter.begin()));

    multiset<string> uni;
    set_union(set1.begin(), set1.end(), set2.begin(), set2.end(),
                   inserter(uni, uni.begin()));
    int answer =   (int) (((float) inter.size() / uni.size()) * mul);
    return answer;
}

int main() {
    string s1 = "E=M*C^2";
    string s2 = "e=m*c^2";
    int a = solution(s1, s2);
    cout << a;
    return 0;

}