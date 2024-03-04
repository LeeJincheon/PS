import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> list = new LinkedList<>();
        Map<String, String> map = new HashMap<>();
        
        for (String info : record) {
            String[] words = info.split(" ");
            if (words[0].equals("Enter") || words[0].equals("Change")) {
                map.put(words[1], words[2]);
            }
        }
        
        for (String info : record) {
            String[] words = info.split(" ");
            if (words[0].equals("Enter")) {
                list.add(map.get(words[1]) + "님이 들어왔습니다.");
            } else if (words[0].equals("Leave")) {
                list.add(map.get(words[1]) + "님이 나갔습니다.");
            }
        }
        String[] answer = list.toArray(new String[0]);
        
        return answer;
    }
}