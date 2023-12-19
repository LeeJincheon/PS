import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int s = Integer.parseInt(input[0]); // 문자열 길이 4
		int p = Integer.parseInt(input[1]); // 부분문자열 길이 2
		
		String dnaString = br.readLine(); // DNA 문자열 GATA
		
		int[] cnt = new int[4]; // [A(개수), C, G, T]
		String[] input2 = br.readLine().split(" ");
		for(int i=0; i<cnt.length; i++) {
			cnt[i] = Integer.parseInt(input2[i]);
		}
		
		Map<Character, Integer> map = new HashMap<>();
		
		map.put('A', 0);
		map.put('C', 0);
		map.put('G', 0);
		map.put('T', 0);
		
		int res = 0;
		int startPoint = 0;
		int endPoint = startPoint + p;
		String subDna = dnaString.substring(startPoint, p);
		
		for(int i=0; i<subDna.length(); i++) {
			char c = subDna.charAt(i);
			map.put(c, map.get(c) + 1);
		}
		
		if(map.get('A')>=cnt[0] && map.get('C')>=cnt[1] && map.get('G')>=cnt[2] && map.get('T')>=cnt[3]) {
			res++;
		}
		
		for(int i=0; i<dnaString.length()-p; i++) {
			map.put(dnaString.charAt(startPoint + i), map.get(dnaString.charAt(startPoint + i))-1);
			map.put(dnaString.charAt(endPoint + i), map.get(dnaString.charAt(endPoint + i))+1);
			
			if(map.get('A')>=cnt[0] && map.get('C')>=cnt[1] && map.get('G')>=cnt[2] && map.get('T')>=cnt[3]) {
				res++;
			}
		}
		
		System.out.println(res);
	}
}
