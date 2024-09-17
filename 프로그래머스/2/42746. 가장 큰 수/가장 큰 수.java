import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> strNumbers = Arrays.stream(numbers)
                                    .mapToObj(String::valueOf)
                                    .collect(Collectors.toList());
        
        Collections.sort(strNumbers, (n1, n2) -> (n2+n1).compareTo(n1+n2));
        
        // 정렬된 결과가 "0"으로 시작하면 "0"을 반환 (모든 값이 0일 때)
        if (strNumbers.get(0).equals("0")) {
            return "0";
        }
        
        // 문자열을 이어 붙여서 반환
        return strNumbers.stream().collect(Collectors.joining());
    }
}
