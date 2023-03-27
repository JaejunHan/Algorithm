#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
using namespace std;
 
int main(int argc, char** argv) {
    int n, s, ans = 0;
    scanf("%d %d", &n, &s);
 
    vector<int> v(n);
    for (int i = 0; i < n; i++)
        scanf("%d", &v[i]);
 
    //1<<n으로 하는 이유는 집합을 { x, x, x, x }라 했을 때 각 위치를 이진수의 위치와 같다고 생각하기 위함이다.
    //만약 주어진 집합의 원소의 개수가 5개라고 한다면 { x, x, x, x, x }와 같을 것이다.
    //(1 << 5)는 32이고 이진수로 나타내면 100000이다. 따라서 (1 << 5) - 1은 31이고 이진수로 나타내면 11111이다.
    //이 이진수를 원소의 집합과 matching시킨다면 이진수의 자리수가 1비트이면 해당 원소값을 가지는 것이고, 0이면 해당 원소값을 가지지 않는 것이라 할 수 있다.
    //따라서 i값을 (1 << n) - 1까지 돌려보는 것은 모든 부분집합을 살펴보는 것이라 할 수 있다.
    //i가 16이 되면 10000이고 이는 집합의 첫 번째 원소만을 가지는 부분집합이다.
    //공집합은 포함하지 않으므로 i는 1부터 시작한다.
    for (int i = 1; i < (1 << n); i++) {
        //k는 0부터 시작하여 n - 1까지 가면서 해당 부분집합(i의 값 자체가 부분집합임)이 어떤 index의 원소를 가지고 있는 확인한다.
        int sum = 0;
        for (int k = 0; k < n; k++) {
            //해당 부분집합에 들어있는 값을 더해준다.
            if (i & (1 << k)) {
                sum += v[k];
            }
        }
        if (sum == s) ans++;
    }
 
    printf("%d\n", ans);
 
    return 0;
}
