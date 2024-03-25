public class Solution {
	public String solution(String s) {
        
        s = s.toLowerCase();
        String[] words = s.split(" ");
        String result = "";
        
        for (int i=0; i<words.length; i++) {
            if (words[i].length() != 0) {
                result += words[i].substring(0, 1).toUpperCase();
                result += words[i].substring(1);
                result += " ";
            } else {
                result += " ";
            }
        }
        if (s.substring(s.length()-1, s.length()).equals(" ")) {
            return result;
        }
        return result.substring(0, result.length()-1);
    }
}