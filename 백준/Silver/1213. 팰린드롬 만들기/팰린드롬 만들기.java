import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Comparator<Character> comparator = (c1, c2) -> c1.compareTo(c2); 
		
		Map<Character, Integer> map = new TreeMap<>(comparator);
		
		String name = sc.next();
		int len = name.length();
		
		for(int i=0; i<len; i++) {
			char alpha = name.charAt(i);
			map.put(alpha, map.getOrDefault(alpha, 0) + 1);
		}
		
		boolean allEven = true;
		int oddCount = 0;
		char oddChar = ' ';
		char[] evenChar = new char[len];
		int idx = 0;
		
		for(char key : map.keySet()) {
			if(map.get(key)%2 != 0) {
				oddChar = key;
				map.put(key, map.get(key) - 1);
				allEven = false;
				oddCount++;
			}
			
			if (map.get(key)%2 == 0) {
				for(int i=0; i<map.get(key); i++) {
					evenChar[idx] = key;
					idx++;
				}
			}
		}
		
		char[] res = new char[len];
		int lt = 0;
		int rt = len - 1;
		
		if(len%2 == 0) {
			if(allEven) {
				int toLt = 0;
				int toRt = 1;
				while(lt<rt) {
					res[lt] = evenChar[toLt];
					res[rt] = evenChar[toRt];
					toLt += 2; toRt += 2;
					lt++; rt--;
				}
				
				for(char c : res) {
					System.out.print(c);
				}
				
			} else {
				System.out.println("I'm Sorry Hansoo");
			}
		} else {
			if(oddCount == 1) {
				res[len/2] = oddChar;
				
				int toLt = 0;
				int toRt = 0;
				while(lt<rt) {
					res[lt] = evenChar[toLt];
					res[rt] = evenChar[toRt];
					toLt += 2; toRt += 2;
					lt++; rt--;
				}
				
				for(char c : res) {
					System.out.print(c);
				}
				
			} else {
				System.out.println("I'm Sorry Hansoo");
			}
		}
	}
}
