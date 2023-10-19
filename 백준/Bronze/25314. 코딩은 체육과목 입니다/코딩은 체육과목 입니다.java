import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String res = "";
		int n = sc.nextInt();
		int cnt = n/4;
		
		for(int i=0; i<cnt; i++) {
			res += "long ";
		}
		
		res += "int";
		System.out.println(res);
	}
}