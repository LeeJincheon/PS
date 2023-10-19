import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
		int total = sc.nextInt();
		int cnt_total = sc.nextInt();
		int sum = 0;
        
		for(int i=0; i<cnt_total; i++) {
			int price = sc.nextInt();
			int cnt = sc.nextInt();
			sum += price*cnt;
		}
        
		String res = (sum == total) ? "Yes" : "No";
		System.out.println(res);
	}
}