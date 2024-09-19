import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> returns = new ArrayList<>();
        int[] day = new int[progresses.length];
        
        // 남은 일수 계산
        for (int i=0; i<progresses.length; i++) {
            day[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        
        // 배포 가능한 개수 세기
        int idx = 0;
        
        while(idx < day.length) {
            int count = 1;
            int now = day[idx];

            for (int i=idx+1; i<day.length; i++) {
                if (now >= day[i]) {
                    count++;
                } else {
                    break;
                }
            }
            
            returns.add(count);
            idx += count;
        }
        
        //7일 3일 9일
        //5일 10일 1일 1일 20일 1일
        
        // 리스트를 배열로
        int[] answer = returns.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}