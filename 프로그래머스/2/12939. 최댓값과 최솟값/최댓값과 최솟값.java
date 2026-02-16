class Solution {
    public String solution(String s) {
        String answer = "";
        
        long min = 0;
        long max = 0;
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            long num = Integer.parseInt(arr[i]);
            if (i == 0) {
                min = num;
                max = num;
            }else {
                if (num > max) {
                    max = num;
                }else if (num < min) {
                    min = num;
                }
            }
        }
        answer = answer + min + " " + max;
        
        return answer;
    }
}