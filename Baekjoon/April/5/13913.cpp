#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;
const int MAX = 100000;

int take[MAX+1] = {0, };
bool visited[MAX+1] = {false,};

int getMinIndex(int start) {
    if (start % 2 == 0) {
        
    } else {

    }
}

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
            cout << take[front] << "\n";
            break;
        }        
        if (front-1>=0 && !visited[front-1]) {
            q.push(front-1);
            visited[front-1] = true;
            take[front-1] = take[front] + 1;
        }
        if (front+1<=MAX && !visited[front+1]) {
            q.push(front+1);
            visited[front+1] = true;
            take[front+1] = take[front] + 1;
        }
        if (front*2<=MAX && !visited[front*2]) {
            q.push(front*2);
            visited[front*2] = true;
            take[front*2] = take[front] + 1;
        }
    }

    vector<int> v;
    q.push(K);
    v.push_back(K);
    while (!q.empty()) {
        int front = q.front();
        q.pop();
        if (take[front] == 1) {
            if (front-1 >= 0 && front-1 == N) {            
                v.push_back(front-1);
                break;
            } else if (front+1 >= 0 && front+1 == N) {
                v.push_back(front+1);
                break;
            } else if (front %2 == 0 && front/2 == N) {
                v.push_back(front/2);
                break;
            }
        }

        int ele;
        if (front-1 >= 0 && take[front-1] == take[front]-1) {
            q.push(front-1);
            v.push_back(front-1);
            // continue;
        } else if (front+1 <= MAX && take[front+1] == take[front]-1) {
            q.push(front+1);
            v.push_back(front+1);
            // continue;
        } else if (front % 2 == 0 && take[front/2] == take[front]-1) {
            q.push(front/2);
            v.push_back(front/2);
            // continue;
        }
    }

    for (int i=v.size()-1; i>=0; i--) {
        cout << v[i] << " ";
    }

    return 0;
}