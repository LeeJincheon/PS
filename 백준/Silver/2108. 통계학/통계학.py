import sys
input = sys.stdin.readline

n = int(input())

arr = []
mfv = []
dic = {}

for _ in range(n):
    num = int(input())
    arr.append(num)
    dic[num] = 0
    
sum = 0
arr.sort()
for i in range(n):
    sum += arr[i]
    dic[arr[i]] += 1
    
mxm = -1
for key, val in dic.items():
    if(val>mxm):
        mfv.clear()
        mfv.append(key)
        mxm = val
    elif(val==mxm):
        mfv.append(key)

mfv.sort()
print(round(sum/n)) #산술평균
print(arr[n//2]) #중앙값
if(len(mfv)>=2):
    print(mfv[1])
elif(len(mfv)==1):
    print(mfv[0]) #최빈값
print(arr[-1]-arr[0]) #범위