#include <iostream>
#include <cstring>
#include <vector>
#include <stack>

typedef long long ll;
using namespace std;

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int n,ans=0; cin>>n;
    stack <int> st;
    for(int i=0; i<=n; i++){
        int x,y;
        if(i!=n) cin>>x>>y; //y에만 관심있음
        else y=0; // 마지막에 0넣어줌

        while(!st.empty()&&st.top()>=y){
            if(st.top()!=y) ans++;
            st.pop();
        }
        st.push(y);
    }
    cout<< ans;
    return 0;
}