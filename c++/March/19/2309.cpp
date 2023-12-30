#include <stdio.h>
#include <vector>
#include <algorithm>

using namespace std;


int main () {
    short sum = 0;
    
    vector<short> v;
    for (short i=0;i<9;i++) {
        int tall;
        scanf("%d", &tall);
        sum += tall;
        v.push_back(tall);
    }

    sort(v.begin(), v.end());
    short diff = sum - 100;
    bool isBreak=false;
    short no1, no2;
    for (short i=0; i< 9; i++) {
        if (isBreak) {
            break;
        }
        for (short j=i+1;j<9;j++) {
            if (v[i] + v[j] == diff) {
                no1 = i;
                no2 = j;
                isBreak;
                break;
            }
        }
    }

    for (short i=0;i<9;i++) {\
        if (i == no1 || i == no2)
            continue;
        printf("%d\n", v[i]);
    }

    

    return 0;
}