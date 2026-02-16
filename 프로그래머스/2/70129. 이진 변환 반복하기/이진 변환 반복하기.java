import java.util.*;

class Solution {
    static String process(int len) {
        String res = "";
        List<Integer> numbers = new ArrayList<>();
        while(len != 1) {
            numbers.add(len%2);
            len = len/2;
        }
        numbers.add(1);
        
        for (int num : numbers) {
            res += num+"";
        }
        return res;
    }
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 0;
        int zero = 0;
        
        while (!s.equals("1")) {
            String one = "";
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zero++;
                }else {
                    one += "1";
                }
            }
            int c = one.length();
            s = process(c);
            cnt++;
        }
        
        answer[0] = cnt;
        answer[1] = zero;
        return answer;
    }
}