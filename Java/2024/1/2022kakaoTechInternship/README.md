# 2022 KAKAO TECH INTERNSHIP

## 1. 성격 유형 검사하기

- Map을 사용. key space가 크지 않으므로 HashMap 사용
  - key: Character, value: Integer
- mp.put을 이용한 값 초기화
- if-else 문을 사용하여 값 update
- if-else 문을 통해 사전 순 비교


## 2. 두 큐 합 같게 만들기

**발상법**
- 명확한 규칙성이 존재하지 않음 -> 그리디 알고리즘 시도

**풀이**
1. Queue를 문제 풀이와 똑같이 구현하여 사용
2. while loop의 종료 조건: q1, q2의 pop한 횟수가 q1.length + q2.length보다 크거나 같을 때 (원래 상태가 됨)

**중요 포인트**
1. long 사용
2. while loop의 종료 조건


## 3. 코딩 테스트 공부

**아이디어**
두 정수가 주어지고, 도달할 때까지의 최솟값을 묻고 있으므로 dp 사용

**풀이**
총 3가지 조건이 있음
```java
dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 1);
dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] + 1);
dp[nxt1][nxt2] = Math.min(dp[nxt1][nxt2], dp[i][j] + t);
```

여기에 <span style='background-color: #fff5b1'>**조건문**</span>을 꼭 사용해서 범위에 벗어나지 않도록 처리해야함.

**중요 포인트**
1. dp 사용 시 범위에 벗어나는지 여부를 if 문을 사용하여 판단.
2. Math.min 사용해서 범위 밖으로 나가지 않게 함.
3. 특이 테스트 케이스 고려:
   - 주어진 alp, cop 값이 max_alp, max_cop보다 큰 경우 고려
     - 이 경우 alp, cop 값을 max_alop, max_cop으로 초기화.


## 4. 등산코스 정하기

**기존 풀이**
- DFS로 구현
- gates로부터 summit까지의 경로를 DFS로 찾음
- DFS의 시간 복잡도: O(N+E)
  
**풀이**
1. Dijkstra를 사용하여 시간 복잡도가 O(NlogN)이 되도록 함.
   - Node의 길이가 최솟값이 되면 업데이트 함.
   - PriorityQueue를 사용함.
      - PQ의 기준은 node의 거리를 ascending order로 함.
2. 시작점으로부터 summit까지의 거리를 구함.


**중요 포인트**
- ArrayList[] 를 사용하여 인접한 노드 사이의 정보를 저장.
  - C++의 vector<vector>와 같음.
  - ArrayList[]를 초기화 하는 방법:
    ```java
    ArrayList[] adj = new ArrayList[n+1];
    for (int i=0; i< n+1; i++) {
        adj[i] = new ArrayList<Node>();
    }
    ```
