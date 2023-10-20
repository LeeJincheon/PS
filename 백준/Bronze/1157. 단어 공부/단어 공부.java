import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Map<Character, Integer> alpha = new HashMap<>();
        
		String str = sc.next();
		str = str.toUpperCase();
		
		for(int i=0; i<str.length(); i++) {
			if(alpha.containsKey(str.charAt(i))) {
				alpha.put(str.charAt(i), alpha.get(str.charAt(i))+1);
			}else {
				alpha.put(str.charAt(i), 1);
			}
		}
		
		Set<Character> keys = alpha.keySet();
		
		int max = -1;
		char res = ' ';
		for(char key : keys) {
			if(alpha.get(key) > max) {
				max = alpha.get(key);
				res = key;
			}
		}
		
		int cnt = 0;
		Collection<Integer> values = alpha.values();
		for(int value : values) {
			if(value == max) {
				cnt++;
			}
		}
		
		if(cnt == 1) {
			System.out.println(res);
		}else {
			System.out.println("?");
		}
	}
}