# 2022 KAKAO TECH INTERNSHIP

## 1. 신고 결과 받기

**아이디어**
- Map을 사용하여 id_list를 String에서 increment index로 받음.
- Map을 사용하여 신고 받은 String을 key로 하고, 신고한 String의 Set을 value로 하는 MAP을 만듬.
    - Map을 forEach를 통해 iterate하면서, value(Set)의 크기가 k 이상인 것들에 대해, ans++를 해줌.

**시간복잡도**
O(report + id_list)


## 2. k진수에서 소수 개수 구하기

**아이디어**
- 주어진 수를 n진수로 표현하는 함수 필요
- isPrime함수 필요
  - 시간 복잡도가 O(logN)이 되도록 할 것
- split 함수 필요
  - split('0+')로 하면 연속된 0에 대해 split 함.


**주의사항**
테케 1번과 11번 런타임 에러가 나왔음.
문제점:
1. 0으로만 구성된 String의 경우 split의 결과 값이 [""] 하나임. 이 경우 예외 처리 필요.
2. split한 결과를 int로 받았는데, long으로 받아야 함. (Integer Overflow)


## 3. 주차 요금 계산

**아이디어**
- 차량 번호가 작은 자동차부터 -> TreeMap사용
- 입차, 출차를 관리할 Map: timeMap 사용 (key: String carNumber, value: Intger Time)

**궁금한 점**
1. java에서 나누기 시 올림 처리 어떻게 했는지?


## 4. 양궁 대회

**아이디어**
- 중복 조합을 사용함
  - 11H10 = 20C10 = 대략 20만
  - 20만 x 11 = O(220만) (배열을 비교하고 점수를 계산해야하므로)
  - backTrack(int depth)사용
- backTrack을 사용하되, 기존의 수학 풀이처럼 하기 보단 원초적으로 생각하자

**주의 사항**
- backTrack의 종료 조건
- Edge Case 고려 (apeach와 lion이 비길 경우)

## 5. 양과 늑대

**아이디어**
- DFS 사용
  - 종료 조건: 더 이상 방문할 노드가 없거나, 양의 수와 늑대의 수가 같을 때
  - 방문 가능한 노드들을 iterate하면서 다음 방문 가능 node들의 set을 dfs에 넘겨줌.
  - dfs(Set<Integer> s, int cnt1, int cnt2)


## 5. 파괴되지 않은 건물

**아이디어**
- 문제에 주어진 그대로 구현하면 시간 초과가 남.
  - O(1000 * 1000 * 25000)
- 2차원 누적합을 사용해야 함.
  - 왼쪽 위와 오른쪽 아래에 +degree, 오른쪽 위와 왼쪽 아래에 -degree
  - 예시:
  
    ```java
    1 0 -1
    0  0 0
    -1 0 1

    ->

    1 0 -1
    1 0 -1
    0 0 0

    ->

    1 1 0
    1 1 0
    0 0 0

    ```

## 6. 사라지는 발판

**어려웠던 점**
1. 최대한 빨리 이기는 것, 최대한 늦게 지는 것 구현이 막혔음
   - 해당 아이디어 어떻게 떠올리면 좋을까?
   - dfs()가 int 형태를 return 하도록?








