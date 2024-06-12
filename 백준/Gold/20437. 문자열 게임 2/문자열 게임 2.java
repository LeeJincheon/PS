import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(br.readLine());
        
        for (int i = 0; i < t; i++) {
            String w = br.readLine();
            int k = Integer.valueOf(br.readLine());
            
            if (k == 1) {
                System.out.println(1 + " " + 1);
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
                System.out.println(minLength + " " + maxLength);
            } else {
                System.out.println(-1);
            }
        }
    }
}
