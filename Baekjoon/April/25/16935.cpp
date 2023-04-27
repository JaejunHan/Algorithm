#include <iostream>
#include <algorithm>
#define MAX 101

using namespace std;

int mp[MAX][MAX];
int cp[MAX][MAX];


int N, M, R;

void print() {
    for (int i=0; i<N;i++) {
        for (int j=0; j< M; j++) {
            cout << mp[i][j] << " ";
        }
        cout << "\n";
    }
}

void copy() {
    for (int i=0; i < N; i++) {
        for (int j=0; j < M; j++) {
            mp[i][j] = cp[i][j];
        }
    }
}

void one() {
    for (int i =0; i< N/2; i++) {
        for (int j=0; j < M; j++) {
            swap(mp[i][j], mp[N-1-i][j]);
        }
    }
}

void two() {
    for (int i=0;i < N;i++) {
        for (int j=0; j < M/2; j++) {
            swap(mp[i][M-1-j], mp[i][j]);
        }
    }
}

void three() {
    for (int i=0; i < M; i++) {
        for (int j=0; j < N; j++) {
            cp[i][j] = mp[N-1-j][i];
        }
    }
    swap(N, M);
    copy();
}

void four() {
    for (int i=0; i < M; i++) {
        for (int j=0; j < N; j++) {
            cp[i][j] = mp[j][M-1-i];
        }
    }
    swap(N, M);
    copy();
}

void five() {
    for (int i=0; i < N/2; i++) {
        // 4-> 1
        for (int j=0; j < M/2; j++) {
            cp[i][j] = mp[i+N/2][j];
        }
        //1->2
        for (int j=M/2; j < M; j++) {
            cp[i][j] = mp[i][j-M/2];
        }
    }

    for (int i=N/2; i< N; i++) {
        // 3 -> 4
        for (int j=0; j < M/2; j++) {
            cp[i][j] = mp[i][j+M/2];
        }
        // 2 -> 3
        for (int j=M/2;j<M;j++) {
            cp[i][j] = mp[i-N/2][j];
        }
    }
    copy();
}

void six() {
    for (int i=0; i < N/2; i++) {
        // 2-> 1
        for (int j=0; j < M/2; j++) {
            cp[i][j] = mp[i][j+ M/2];
        }
        //3->2
        for (int j=M/2; j < M; j++) {
            cp[i][j] = mp[i+N/2][j];
        }
    }

    for (int i=N/2; i< N; i++) {
        // 1 -> 4
        for (int j=0; j < M/2; j++) {
            cp[i][j] = mp[i-N/2][j];
        }
        // 4 -> 3
        for (int j=M/2;j<M;j++) {
            cp[i][j] = mp[i][j-M/2];
        }
    }
    copy();
}


int main() {
    cin >> N >> M >> R;
    
    for (int i=0; i <N; i++) {
        for (int j=0; j< M; j++) {
            cin >> mp[i][j];
        }
    }
    int num;
    for (int i=0; i< R;i++) {
        cin >> num;
        switch (num) {
            case 1:
                one();
                break;
            case 2:
                two();
                break;
            case 3:
                three();
                break;
            case 4:
                four();
                break;
            case 5:
                five();
                break;
            case 6:
                six();
                break;
        }
    }
    print();
    return 0;
}