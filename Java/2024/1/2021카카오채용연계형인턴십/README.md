# 1. 숫자 문자열과 영단어
replaceAll(prev, next)

# 2. 거리두기 확인하기

**풀이 방식**
BFS를 매 응시자마다 사용하여 인접한 응시자와의 거리가 2 이상인지 판단함.
O(25 * 25 * 5)

# 3. 표 편집

**풀이 방식**
LinkedList를
int[] prev[n], nxt[n]을 이용해서 구현하기.

삭제 내역은 Stack<Node>에 넣기
class Node: int prev, int curr, int nxt

커서 변경, 삽입, 삭제: O(1)

**중요 포인트**
StringBuilder 사용법
```java
StringBuilder sb = new StringBuilder("O".repeat(n));
sb.setCharAt(index, 'X');
```

# 4. 미로 탈출

**처음 접근 법**
2차원 ArrayList<Integer>[] adj 1: {2}, 2: {1, 3}, 3: {2}
2차원 cost[][]
    - 양 방향에 부호를 붙여서 구현함.
    - cost[from][to] = cost
    - cost[to][from] = -1  * cost

이후 DFS로 구현하였을 때, 3, 5, 6번 틀렸다 나오고 나머지 시간 초과가 나옴.

**풀이 방식**

Dijkstra 사용
중요 포인트: **visited[n][1<<traps.length] 2차원 배열 사용**
2차원 cost배열은 매번 바꾸지 말고, 그대로 사용할 것.


# 5. 시험장 나누기

dfs

중요! **이진탐색**
최대 트래픽의 값이 무엇인지 이진탐색으로 정한 뒤,
dfs로 그래프를 탐색하며 k개 내로 그래프를 분할할 수 있는지 알아봐야함.

tree 구조 만들기 (class Node: int left, int right)
    - root 값 int[] parent를 이용해 찾기
    - root에서 dfs를 시작해 왼쪽과 오른쪽의 dfs값을 재귀적으로 불러서 현재 노드와 합을 구해봄
      - 기준 값보다 크면 나뉘어야하므로 cnt++;