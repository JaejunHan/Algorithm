#include <string>
#include <vector>
#include <unordered_set>
#include <set>
#include <iostream>

using namespace std;

int solution(int m, int n, vector<vector<int>> puddles) {
    // unordered_set<pair<int, int>> s;
    
    // for (auto ele: puddles) {
    //     s.insert({ele[0], ele[1]});
    // }
    
    // int dp[m+1][n+1];
    // fill_n(&dp[0][0], (m+1)*(n+1), 0);
    
    // for (int i=1; i<=m; i++) {
    //     if (s.count({i, 1}) == 0) {
    //         dp[i][1] = 1;
    //     }
    // }
    
    // for (int i=1; i<=m; i++) {
    //     if (s.count({1, i}) == 0) {
    //         dp[1][i] = 1;
    //     }
    // }
       
    int answer = 0;
    
    return answer;
}

int main() {
    vector<vector<int>> pd = {{2, 3}};
    char x[] = "1-2";
    cout << atoi(x);
    solution(4, 3, pd);
    return 0;
}