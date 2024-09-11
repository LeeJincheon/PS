import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] a = new int[n];
		for (int i=0; i<n; i++) {
			a[i] = Integer.valueOf(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int b = Integer.valueOf(st.nextToken());
		int c = Integer.valueOf(st.nextToken());
		
		long sum = 0;
		for (int i=0; i<n; i++) {
			int student = a[i];
			sum++;
			if (student > b) {
				int tmp = student - b;
				if (tmp < c) {
					sum = sum + 1;
				} else if (tmp >= c && tmp % c != 0) {
					sum = sum + (tmp / c) + 1;
				} else if (tmp >= c && tmp % c == 0) {
					sum = sum + (tmp / c);
				}
			}
		}
		System.out.println(sum);
	}
}
