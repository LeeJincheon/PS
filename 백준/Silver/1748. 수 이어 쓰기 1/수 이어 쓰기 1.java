import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int res = 0;
		
		for(int i=1; i<=n; i++) {
			if(i<10) {
				res += 1;
			}else if(i<100) {
				res += 2;
			}else if(i<1000) {
				res += 3;
			}else if(i<10000) {
				res += 4;
			}else if(i<100000) {
				res += 5;
			}else if(i<1000000) {
				res += 6;
			}else if(i<10000000) {
				res += 7;
			}else if(i<100000000) {
				res += 8;
			}else {
				res += 9;
			}
		}
		
		System.out.println(res);
	}
}