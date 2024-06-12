import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < t; i++) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());
            
            if (k == 1) {
                result.append("1 1\n");
                continue;
            }
            
            int minLength = Integer.MAX_VALUE;
            int maxLength = Integer.MIN_VALUE;
            boolean found = false;
            
            Map<Character, List<Integer>> charPositions = new HashMap<>();
            
            for (int j = 0; j < w.length(); j++) {
                char c = w.charAt(j);
                charPositions.putIfAbsent(c, new ArrayList<>());
                charPositions.get(c).add(j);
                
                if (charPositions.get(c).size() >= k) {
                    found = true;
                    int startIdx = charPositions.get(c).get(charPositions.get(c).size() - k);
                    int length = j - startIdx + 1;
                    minLength = Math.min(minLength, length);
                    maxLength = Math.max(maxLength, length);
                }
            }
            
            if (found) {
                result.append(minLength).append(" ").append(maxLength).append("\n");
            } else {
                result.append(-1).append("\n");
            }
        }
        
        System.out.print(result.toString());
    }
}
