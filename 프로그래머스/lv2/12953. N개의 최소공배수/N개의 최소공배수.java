import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        Arrays.sort(arr);
        int max = arr[arr.length-1];
        int lcm = max; // 최대값의 배수 중에 최소공배수가 있음
        
        int cnt = 1;
        boolean flag = true;
        while(flag){
            answer = lcm;
            cnt++;
            for(int i=0; i<arr.length; i++){
                if(i == arr.length-1){
                    flag = false;
                }else{
                    if(lcm%arr[i] != 0){
                        lcm = max * cnt;
                        break;
                    }
                }
                
            }
        }
        
        return answer;
    }
}