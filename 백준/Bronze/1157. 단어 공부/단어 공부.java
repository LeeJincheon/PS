import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine().toUpperCase();
		
		Map<Character, Integer> map = new HashMap<>();
		for (int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		int maxFreq = 0;
        char maxChar = '?';
        boolean isTie = false;
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                maxChar = entry.getKey();
                isTie = false;
            } else if (entry.getValue() == maxFreq) {
                isTie = true;
            }
        }
        
        System.out.println(isTie ? "?" : maxChar);
	}
}
