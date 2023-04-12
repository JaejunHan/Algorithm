#include<iostream>
#include<queue>
#include<algorithm> // fill

using namespace std;

#define X first // column
#define Y second // row

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

string maze[1002]; // 공백이 없어서 string으로 받는다.

// 불의 BFS결과가 지훈에게 영향을 주기 때문에 2개 이용
int visJ[1002][1002]; // 지훈
int visF[1002][1002];// 불

int m,n;


int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    queue<pair<int,int>> QJ;
    queue<pair<int,int>> QF;
    
    //행, 열 차례대로 입력
    cin>> m >> n;
    
    // 미로를 string으로 받음
    for(int i = 0; i < m; i++){
        cin>> maze[i];
    }
    
    // 거리초기화(단계 초기화)
    for(int i = 0; i < m; i++){
        fill(visJ[i], visJ[i]+n, -1);
        fill(visF[i], visF[i]+n, -1);
    }
    
    
    //시작점 찾기 -  불, 지훈
    for(int i = 0; i<m; i++){
        for(int j = 0; j<n; j++){
            if(maze[i][j] == 'F'){
                QF.push({i,j});
                visF[i][j] = 0;
            }else if(maze[i][j] == 'J'){
                QJ.push({i,j});
                visJ[i][j] = 0;
            }
        }
    }
    
    
    
    //불 BFS 돌림 
    while(!QF.empty()){
        auto cur = QF.front();
        QF.pop();
        for(int dir = 0; dir < 4; dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx < 0 || nx >= m || ny < 0 || ny >= n)
                continue;
            if(visF[nx][ny] >= 0 || maze[nx][ny] == '#')
                continue;
            visF[nx][ny] = visF[cur.X][cur.Y] + 1; // 단계 
            QF.push({nx,ny});
        }
    }
    
    
    
    //불 BFS 결과 이후 지훈 BFS 돌림  -> 만약 불이 났다면 지훈은 통과하지 못함.
    while(!QJ.empty()){
        auto cur = QJ.front();
        QJ.pop();
        
        for(int dir = 0; dir < 4; dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            
            //이 if문에 들어온다는 것은 지훈이 가장자리에 있다는 뜻
            if(nx < 0 || nx >= m || ny < 0 || ny >= n){
                cout << visJ[cur.X][cur.Y]+1;
                return 0;
                }
            if(visJ[nx][ny] >= 0 || maze[nx][ny] == '#')
                continue;
            
            // 지훈이가 가려는 시간 전에 불이 퍼지면 못감.
            // 다시 말해서 불의 BFS 단계가 더 커야함. 같아도 안된다.
            if(visF[nx][ny] != -1 && visF[nx][ny] <= visJ[cur.X][cur.Y] + 1)
                continue;
            
            
            visJ[nx][ny] = visJ[cur.X][cur.Y] + 1; // 지훈이 가려는 곳임.
            QJ.push({nx,ny});
        }
    }
    cout << "IMPOSSIBLE" ;  // 여기까지오면 탈출 실패

    
}