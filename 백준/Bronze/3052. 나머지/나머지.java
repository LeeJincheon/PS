import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[42];
		
		for(int i=0; i<10; i++) {
			int num = sc.nextInt();
			int tmp = num % 42;
			if(arr[tmp] == 0) {
				arr[tmp] = 1;
			}
		}
		
		int res = 0;
		for(int i=0; i<42; i++) {
			if(arr[i] == 1) {
				res++;
			}
		}
		System.out.println(res);
	}
}