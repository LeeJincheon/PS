import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int[][] size = new int[n][2];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<2; j++) {
				size[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		
		int idx = 0;
		int[] result = new int[n];
		
		while(idx < n) {
			int cnt = 0;
			for (int i=0; i<n; i++) {
				if (i == idx) {
					continue;
				}
				if (size[idx][0] < size[i][0] && size[idx][1] < size[i][1]) {
					cnt++;
				}
			}
			result[idx] = cnt + 1;
			idx++;
		}
		
		for (int i=0; i<n; i++) {
			if (i == n-1) {
				System.out.print(result[i]);
			} else {
				System.out.print(result[i] + " ");
			}
		}
	}
}
