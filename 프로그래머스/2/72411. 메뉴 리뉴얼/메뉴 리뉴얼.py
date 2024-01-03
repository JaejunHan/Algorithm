from itertools import combinations 
from collections import Counter

def solution(orders, course):
    s = set() 
    for order in orders:
        s = s | set(order) 
    answer = [] 
    
    for i in course:
        tmp = [] 
        for order in orders:
            for c in combinations(list(order), i):
                tmp.append("".join(sorted(list(c))))
        
        cnt = Counter(tmp) 
        for i in cnt:
            if (cnt[i] == max(cnt.values())) and (max(cnt.values()) >= 2):
                answer.append(i) 
    return sorted(answer)
