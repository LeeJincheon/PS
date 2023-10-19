import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n+1];
		for(int i=0; i<n+1; i++) {
			arr[i] = i;
		}
		
		for(int k=0; k<m; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int tmp = 0;
			
			while(i < j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		
		for(int i=1; i<n+1; i++) {
			System.out.print(arr[i]);
			System.out.print(" ");
		}
	}
}