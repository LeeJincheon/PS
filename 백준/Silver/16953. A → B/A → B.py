a, b = map(int, input().split())
cnt = 0

while(b!=a):
    if(b%2==0 and b>=a):
        b //= 2
    elif(b%10==1):
        b //= 10
    else:
        cnt = -2
        break
    cnt += 1
    
print(cnt+1)