#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;
const char hello = '!';

bool conv(vector<vector<char>>& v, vector<vector<bool>>& res) {
    bool ans = false;
    for (int i=0; i <v.size()-1;i++) {
        for (int j=0; j<v[0].size()-1;j++){
            char tmp = v[i][j];
            if (tmp == hello) continue;
            if (tmp == v[i+1][j] && tmp == v[i][j+1] && tmp == v[i+1][j+1]){
                ans = true;
                res[i][j] = true;
                res[i+1][j] = true;
                res[i][j+1] = true;
                res[i+1][j+1] = true;
            }
        }
    }

    return ans;
}

void replace(vector<vector<char>>& v, vector<vector<bool>>& res) {
    for (int j=0; j< v[0].size();j++) {
        for (int i= 0; i< v.size(); i++) {
            if (res[i][j] == true) {
                res[i][j] = false;
                v[i][j] = hello;
            }
        }
    }
    int a = 1;

    for (int i=0; i < v.size(); i++) {
        stable_partition(v[i].begin(), v[i].end(), [](char c) { return c != hello; });
        // auto it = find(v[i].begin(), v[i].end(), hello);
        // rotate(it, it + 1, v[i].end());
    }
}


int solution(int m, int n, vector<string> board) {
    int answer = 0;

    vector<vector<char>> v;
    for (int j=0; j < n;j++) {
        vector<char> temp;
        for (int i=m-1; i >=0; i--) {
            temp.push_back(board[i][j]);
        }
        v.push_back(temp);
    }
    
    vector<vector<bool>> res(n, vector<bool>(m, false));
    while (conv(v, res)){
        replace(v, res);
    }

    for (int i=0 ; i< v.size(); i++) {
        for (int j=0;j <v[0].size();j++){
            if (v[i][j] == hello)
                answer += 1;
        }
    }

    return answer;
}

int main() {
    vector<string> x = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
    int a = solution(4, 5, x);
    cout << a;
    return 0;
}