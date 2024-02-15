import java.io.*;
import java.util.*;

public class Main {
	
	static void change(int[] onOff, int pos) {
		if (onOff[pos] == 1)
			onOff[pos] = 0;
		else
			onOff[pos] = 1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] onOff = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=n; i++) {
			onOff[i] = Integer.parseInt(st.nextToken());
		}
		int s = Integer.parseInt(br.readLine());
		for (int i=0; i<s; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			
			if (gender == 1) {
				for (int j=number; j<=n; j++) {
					if (j%number == 0) {
						change(onOff, j);
					}
				}
			} else {
				int lt = number - 1;
				int rt = number + 1;
				while(true) {
					if (lt < 1 || rt > n || onOff[lt] != onOff[rt]) 
						break;
					
					if (onOff[lt] == onOff[rt]) {
						change(onOff, lt);
						change(onOff, rt);
						lt--;
						rt++;
					}
				}
				change(onOff, number);
			}
		}
		
		for (int i=1; i<=n; i++) {
			if (i != n) {
				System.out.print(onOff[i] + " ");
			} else {
				System.out.print(onOff[i]);
			}
            if (i%20 == 0) {
				System.out.println();
			}
		}
	} // main
}