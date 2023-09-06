import java.util.*;

class Solution {
    
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int lt = 0;
        int rt = people.length-1;
        
        while(lt<=rt){
            if(lt == rt){ // 마지막 1명 남았을 때
                if(people[lt] <= limit){
                    answer++;
                    break;
                }
            }
            if(people[lt]+people[rt] <= limit){ // 2명을 태울 수 있으면 태움
                answer++;
                lt++;
                rt--;
            }else{ // 2명을 태울 수 없을 때 제일 무거운 사람을 태움
                answer++;
                rt--;
            }
        }
        
        return answer;
    }
}