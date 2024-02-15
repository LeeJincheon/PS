import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 행
		int m = Integer.parseInt(st.nextToken()); // 열
		String[] map = new String[n];
		for (int i=0; i<n; i++)
			map[i] = br.readLine();
		
		int area = 1;
		for (int i=0; i<n-1; i++) {
			for (int j=0; j<m; j++) {
				for (int k=j+1; k<m; k++) {
					if (map[i].charAt(j) == map[i].charAt(k)) {
						if (i+k-j < n) {
							if (map[i+k-j].charAt(j) == map[i].charAt(j)) {
								if (map[i+k-j].charAt(k) == map[i].charAt(j)) {
									area = Math.max(area, (k-j+1)*(k-j+1));
								}
							}
						}
					}
				}
			}
		}
		System.out.println(area);
	} // main
}