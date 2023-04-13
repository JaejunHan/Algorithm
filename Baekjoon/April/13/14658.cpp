#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    int n,m,l,k; // n = 별똥뱔이 떨어지는 구역의 가로길이, m = 세로길이, l = 트램펄린의 한 변의 길이, k = 별똥별의 수
    cin >> n >> m >> l >> k;
    int y,x,ny,nx,ans=0,cnt=0;
    vector<pair<int,int>> v(k);
    for(int i=0; i<k; i++){
        cin >> x >> y;
        v[i] = {x,y};
    }
    for(int i=0; i<k; i++){
        for(int j=0; j<k; j++){
            cnt = 0;
            x = v[i].first;
            y = v[j].second;
            for(int a=0; a<k; a++){
                nx = v[a].first;
                ny = v[a].second;
                if(x<=nx&&x+l>=nx&&y<=ny&&y+l>=ny) cnt++;
            }
            ans = max(ans,cnt);
        }
    }
    cout << k-ans << "\n";
    return 0;
}