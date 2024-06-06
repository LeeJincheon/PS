import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int m = Integer.valueOf(br.readLine());
		Set<Integer> s = new HashSet<>();
		StringBuilder answer = new StringBuilder();
		
		for (int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String method = st.nextToken();
			int number = 0;
			if (st.hasMoreElements()) {
				number = Integer.valueOf(st.nextToken());
			}
			
			if (method.equals("add")) {
				s.add(number);
			} else if (method.equals("remove")) {
				s.remove(number);
			} else if (method.equals("check")) {
				if (s.contains(number)) {
					answer.append(1).append("\n");
				} else {
					answer.append(0).append("\n");
				}
			} else if (method.equals("toggle")) {
				if (s.contains(number)) {
					s.remove(number);
				} else {
					s.add(number);
				}
			} else if (method.equals("all")) {
				s.clear();
				for (int j=1; j<=20; j++) {
					s.add(j);
				}
			} else if (method.equals("empty")) {
				s.clear();
			}
		}
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}
}
