# MAP

## Methods

### 1. `put(key, value)`
Inserts the specified key-value pair into the map.

### 2. `get(key)`
Returns the value to which the specified key is mapped.

**Example:**

```java
Map<Character, Integer> mp = new HashMap<>();
mp.put('A', 0);
int zero = mp.get('A');
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