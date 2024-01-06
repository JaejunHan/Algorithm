# ArrayList

## Methods

### 1. `add(element)`
Inserts the element to the list.

### 2. `get(index)`
Get the element with the given index.

### 3. `remove(index)`
Remove the element with the given index.

**Example**

```java
ArrayList<Integer> arr = new ArrayList<>();
arr.add(122);
int a = arr.get(0); // a == 122
remove(0);
```

# Stack

## Methods

### 1. `push(element)`
Add the element to the stack.

### 2. `pop()`
Get and remove the top element from the stack.

### 3. `peek()`
Get the top element from the stack.

**Example**
```java
Stack<Integer> s = new Stack<>();
s.add(123);
if (s.peek() == 123) {
  int a = s.pop();
  System.out.println(a);
}
```

# MAP

## Methods

### 1. `put(key, value)`
Inserts the specified key-value pair into the map.

### 2. `get(key)`
Returns the value to which the specified key is mapped.

### 3. `keySet()`
Returns the key set of the map. Use this function when iterating the map.

### 4. `forEach((key, value) -> {})`
Use this function for iterating the map.

### 5. `remove(key)`
Remove the key-value pair from the Map.

### 6. `containsKey(key)`
Return true if the Map contians the key-value pair with the given key.

### 7. `getOrDefault(Object key, V DefaultValue)`


**Example:**

```java
Map<Character, Integer> mp = new HashMap<>();
mp.put('A', 0);
int zero = mp.get('A');
for (String key: mp.keySet()) {
  String value = mp.get(key);
}
mp.forEach((key, value) -> {
  System.out.println(key + " " + value);
})

```

## Types of MAP

### 1. HashMap
- Similar to C++'s `unordered_map`.
- Keys are not ordered.
- Ideal when the number of keys is not large.
- **Time Complexity:**
  - `put`: O(1)
  - `get`: O(1)

### 2. TreeMap
- Similar to C++'s `ordered_map`.
- Keys are sorted.
- Preferable for a larger number of keys.
- **Time Complexity:**
  - `put`: O(logN)
  - `get`: O(logN)


# Set

## Methods

### 1. `add(element)`;
Add the element to the set.

### 2. `remove(element)`
Remove the element from the set.

### 3. `contains(element)`
Return true if the set contains the element, otherwise return false.

### 4. `isEmpty()`
Return true if the set is emtpy, otherwise return false.

# Queue

## Methods

### 1. `add(element)`
Add the element to the Queue

### 2. `poll()`
Get the first element from the Queue

### 3. `isEmpty()`
Returns true if the Queue is empty.

### 4. `peek()`
Get the first element from the Queue

### 5. `clear()`
Clear the Queue

**Example**
```java
Queue<Integer> q = new Queue<>();
q.add(1);
q.add(2);
whlie (!q.isEmpty()) {
  int tmp = q.peek();
  int f = q.poll();
}
q.clear();
```

## Types of Queue

### 1. ArrayDeque

#### Methods
- `pollLast()`
- `addFirst()`

### 2. PriorityQueue
- class에 implements Comparable<Npde>을 붙이고,
- @Override int compareTo(Node o) {} 를 작성해줘야 함.
  - this.cnt - o.cnt; 로 작성 시 cnt 기준으로 오름차순 
  - Example: 
  ```java
  public static class Node implements Comparable<Node> {
        int x;
        int cost;
        
        public Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
  ```


# Sorting

1. Array 정렬하기
  ```java
  Arrays.sort(arr);
  Arrays.sort(arr, Collections.reverseOrder());
  ```

1. List 정렬하기
   ```java
   Collections.sort(list);
   Collections.sort(list, Collections.reverseOrder());
   ```



# 알고리즘 시간 복잡도
## 1. `DFS : O(N+E)`
## 2. `BFSL O(N+E)`
## 3. `Dijkstra: O(NlogN)`


# String

## Methods

1. substring(start, end)
2. replace(fromString, toString)
   - replace 시 while의 조건으로 contains(str)을 사용해서 replace 후에도 계속 남아있는지 확인 해야함.
3. char Compare (c >= 'a' && c <= 'z')
4. toLowerCase(), toUpperCase()

5. String의 char를 순서대로 정렬하기
   ```java
   char[] cArr = order.toCharArray();
   Arrays.sort(cArr);
   s = new String(cArr);
   ```

6. repeat(int n)
   String을 n번 반복하기
   ```java
   StringBuilder sb = new StringBuilder("O".repeat(n));
   ```




# 이분 탐색

**코드 외우기**

```java
while (start <= end) {
   mid = (start+end) / 2;
   if (list.get(mid) < num) {
       start = mid + 1;
   } else {
       end = mid - 1;
   }
}
```
start가 해당 원소의 index를 가지게 됨.
해당 원소가 없을 경우 그것보다 작고, 최대인 원소의 index 값을 start가 가짐.
- ex: 1, 3, 4, 6에서 5의 index를 찾을 경우 5보다 작고, 가장 큰 값인 4의 index를 반환함.


# StringBuilder

## Methods

1. toString()
2. setCharAt(int index, char c);
   - index에 있는 char을 char c로 바꿈.
   