import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] numList = new int[n];
		for(int i=0; i<n; i++) {
			numList[i] = sc.nextInt();
		}
		
		int v = sc.nextInt();
		
		int res = 0;
		for(int i=0; i<numList.length; i++) {
			if(numList[i] == v)
				res++;
		}
		
		System.out.println(res);
	}
}