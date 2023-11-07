from collections import deque
import sys

res = []
case = int(input())
for _ in range(case):
    n, m = map(int, sys.stdin.readline().split())
    w = [(pos, val) for pos, val in enumerate(list(map(int, sys.stdin.readline().split())))]
    w = deque(w)
    
    cnt = 0
    while True:
        temp = w.popleft()
        if(any(temp[1]<x[1] for x in w)):
            w.append(temp)
        else:
            cnt += 1
            if(temp[0]==m):
                break
    res.append(cnt)

for x in res:
    print(x)