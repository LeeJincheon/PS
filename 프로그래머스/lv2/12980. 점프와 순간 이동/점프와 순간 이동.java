import java.util.*;

public class Solution {
    
    public int solution(int n) {
        int ans = 0;
        // 도착지에서 거꾸로 이동
        while(n != 0){
            if(n%2 == 0){ // 현재 위치가 짝수이면 순간이동 전으로 이동
                n /= 2;
            }else{ // 홀수이면 1칸 점프 전으로 이동
                n -= 1;
                ans++;
            }
        }

        return ans;
    }
}