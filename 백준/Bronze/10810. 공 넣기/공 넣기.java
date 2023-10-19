import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] num = new int[n+1];
		
		for(int idx=0; idx<m; idx++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int k = sc.nextInt();
			
			for(int t=i; t<=j; t++) {
				num[t] = k;
			}
		}
		
		for(int i=1; i<num.length; i++) {
			System.out.print(num[i]);
			System.out.print(" ");
		}
	}
}