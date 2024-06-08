import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		String game = st.nextToken();
		
		Map<String, Integer> map = new HashMap<>();
		
		int cnt = 0;
		int with = 0;
		int result = 0;
		
		if (game.equals("Y")) {
			with = 1;
		} else if (game.equals("F")) {
			with = 2;
		} else if (game.equals("O")) {
			with = 3;
		}
		
		for (int i=0; i<n; i++) {
			String name = br.readLine();
			map.put(name, map.getOrDefault(name, 0) + 1);
			
			if (map.get(name) == 1) {
				cnt++;
			}
			
			if (cnt == with) {
				result++;
				cnt = 0;
			}
		}
		
		System.out.println(result);
	}

}
