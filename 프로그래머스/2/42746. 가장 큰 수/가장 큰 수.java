import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = Arrays.stream(numbers)
                                    .mapToObj(String::valueOf)
                                    .toArray(String[]::new);
        
        Arrays.sort(strNumbers, (num1, num2) -> {
            String order1 = num1 + num2;  // num1이 앞에 올 때
            String order2 = num2 + num1;  // num2가 앞에 올 때
            return order2.compareTo(order1); // 더 큰 값이 앞으로 오도록 내림차순 정렬
        });
        
        // 정렬된 결과가 "0"으로 시작하면 "0"을 반환 (모든 값이 0일 때)
        if (strNumbers[0].equals("0")) {
            return "0";
        }
        
        // 문자열을 이어 붙여서 반환
        return String.join("", strNumbers);
    }
}
