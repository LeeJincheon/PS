import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>(); // key:귤의 크기(종류), value:개수
        for(int e : tangerine){
            // getOrDefault(key, defaultValue):key(e)의 value가 없으면 defaultValue
            map.put(e, map.getOrDefault(e, 0)+1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        // list.addAll(map.values());
        Collections.sort(list, Collections.reverseOrder()); // 내림차순 정렬
        
        for(int e : list){
            k -= e;
            answer++;
            if(k<=0){
                break;
            }
        }
        
        return answer;
    }
}