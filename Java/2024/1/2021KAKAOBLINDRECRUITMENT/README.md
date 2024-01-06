# 2021 KAKAO BLIND RECRUITMENT

## 1. 신규 아이디 추천

**풀이**
은근 어려웠던 문제...
1. substring(start, end)
2. replace(fromString, toString)
   - replace 시 while의 조건으로 contains(str)을 사용해서 replace 후에도 계속 남아있는지 확인 해야함.
3. char Compare (c >= 'a' && c <= 'z')
4. toLowerCase(), toUpperCase()

## 2. 메뉴 리뉴얼

**풀이**
1. 모든 combination을 가져와서, MultiSet에 해당하는 MAP<String, Integer>에 넣어줌.
2. 각 길이마다 최대 회수를 가지는 String의 집합이 필요하므로 Map<Integer, PriorityQueue < Node>>를 사용함.
   - key: 문자열의 길이
   - Node: 횟수와 문자열을 담은 class. 횟수 내림차순을 기준으로 정렬하도록 구현.


## 3. 순위 검색

1. 모든 경우의 수에 대한 점수를 입력해줌.
   - 예를 들어, Java backend junior pizza의 조건의 경우
        1. ----
        2. ---pizza
        3. --junior-
        4. -backend--
        5. ...
    과 같이 key를 만듬.
        - 재귀 함수로 구현.
   - Map의 value는 점수를 담을 List<Integer>임.
     - Collections.sort를 이용하여 List를 오름차순 정렬해야함
       - 이분 탐색 사용
  
**중요 포인트**
1. 이분 탐색 사용 시 조건문
   - 가능하면 외우기
2. 모든 경우의 수를 구현할 때 recursion(재귀) 함수를 사용.


## 4. 탑승 택시 요금

**풀이**
- 처음에 DFS를 떠올렸음
- 하지만, Edge가 N^2이므로 DFS의 시간 복잡도는 O(N^2)
- Dijsktra를 사용하면 O(NLogN)
- 하나의 node로부터 A와 B의 거리를 미리 계산 해두면 DP처럼 반복된 연산을 하지 않고 사용할 수 있겠다 싶었음
  - 모든 node를 시작점으로 해서 Dijsktra를 시행. -> O(N^2 * logN)
    - 모든 node로부터 A와 B의 최단 거리를 구함.
- Start에서 node들의 dijsktra를 통해 최단 경로를 구하면서, 해당 노드에서 A와 B사이의 거리를 미리 계산해둔 것을 사용 -> O(NlogN)

**시간복잡도**
O(N^2 * logN)

## 5. 광고 삽입

**풀이**
1차원 누적합