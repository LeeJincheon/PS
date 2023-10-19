import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] num = new int[n+1];
        for(int i=0; i<n+1; i++) {
			num[i] = i;
		}
		
		for(int idx=0; idx<m; idx++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			int tmp = num[i];
			num[i] = num[j];
			num[j] = tmp;
		}
		
		for(int i=1; i<num.length; i++) {
			System.out.print(num[i]);
			System.out.print(" ");
		}
		System.out.println();
	}
}