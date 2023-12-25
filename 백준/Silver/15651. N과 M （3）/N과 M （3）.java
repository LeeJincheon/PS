import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] selected;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		selected = new int[m+1];
	}
	
	static void rec_func(int k) {
		if(k==m+1) {
			for(int i=1; i<=m; i++) {
				sb.append(selected[i]).append(' ');
			}
			sb.append("\n");
		} else {
			for(int cand=1; cand<=n; cand++) {
				selected[k] = cand;
				rec_func(k+1);
				selected[k] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		input();
		rec_func(1);
		System.out.println(sb.toString());
	}
}