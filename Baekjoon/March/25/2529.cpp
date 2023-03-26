#include <vector>
#include <iostream>


using namespace std;


int N;
bool visited[10] = {false, };

void dfs(int num, int cnt, vector<char>& v, vector<short>& s, vector<vector<short>>& ans) {
    if (cnt == N+1) {
        ans.push_back(s);
        return;
    }
    for (int i=0;i <= 9; i++) {
        if (cnt >0 && v[cnt-1] == '<') {
            if (s[cnt-1] >= i ) {
                continue;
            }
        } else if (cnt >0 && v[cnt-1] == '>') {
            if (s[cnt-1] <= i ) {
                continue;
            }
        }
        if (!visited[i]) {
            visited[i] = true;
            s.push_back(i);
            dfs(i, cnt+1, v, s, ans);
            s.pop_back();
            visited[i] = false;
        }
    }
}


int main() {

    cin >> N;

    vector<char> v;

    for (short i=0;i < N; i++) {
        char temp;
        cin >> temp;
        v.push_back(temp);
    }

    vector<short> s;
    vector<vector<short>> ans;

    dfs(0, 0, v, s, ans);
    
    for (int i=0;i <=N; i++){
        cout << ans[ans.size()-1][i];
    }
    cout << endl;
    
    for (int i=0;i <=N; i++){
        cout << ans[0][i];
    }
    cout << endl;


    return 0;
}