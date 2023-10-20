import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			String blank = " ";
			String star = "*";
			String res = "";
			res = blank.repeat(n-i) + star.repeat(2*i-1);
			System.out.println(res);
		}
		
		for(int i=1; i<=n-1; i++) {
			String blank = " ";
			String star = "*";
			String res = "";
			res = blank.repeat(i) + star.repeat(2*n-1-2*i);
			System.out.println(res);
		}
	}
}