import java.util.*;
public class Main {
	
	static long f(long n) {
		if(n<2)
			return n;
		else {
			return f(n-1) + f(n-2);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		
		System.out.println(f(n));
	}
}