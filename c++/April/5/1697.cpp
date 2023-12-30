#include <algorithm>
#include <vector>
#include <iostream>
#include <queue>
#define MAX 100001

using namespace std;

const int M = 100000;
int take[MAX] = {0, };
bool visited[MAX] = {false};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N, K;
    cin >> N >> K;

    queue<int> q;
    q.push(N);
    take[N] = 0;
    visited[N] = true;

    while (!q.empty()) {
        int front = q.front();
        q.pop();
        if (front == K) {
            while (!q.empty()) {
                q.pop();
            }
            cout << take[front];
            break;
        }
        
        if (front+1 <= M && !visited[front+1]) {
            q.push(front+1);
            visited[front+1] = true;
            take[front+1] = take[front] +1;
        }
        if (front-1 >=0 && !visited[front-1]) {
            q.push(front-1);
            visited[front-1] = true;
            take[front-1] = take[front] +1;
        }
        if (front*2 <= M && !visited[front*2]) {
            q.push(front*2);
            visited[front*2] = true;
            take[front*2] = take[front] +1;
        }

    }


    return 0;
}