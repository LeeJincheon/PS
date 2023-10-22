import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] h = new int[9];
		for(int i=0; i<9; i++) {
			h[i] = sc.nextInt();
		}
		
		Arrays.sort(h);
		
		int total = 0;
		for(int i=0; i<9; i++) {
			total += h[i];
		}
		
		int idx1 = 0;
		int idx2 = 0;
		int sum = 0;
		
		for(int i=0; i<8; i++) {
			idx1 = i;
			int out1 = h[i];
			for(int j=i+1; j<9; j++) {
				idx2 = j;
				int out2 = h[j];
				sum = out1 + out2;
				
				if(total-sum == 100) {
					for(int k=0; k<9; k++) {
						if(k==idx1 || k==idx2) {
							continue;
						}
						System.out.println(h[k]);
					}
					break;
				}
			}
			if(total-sum == 100) {
				break;
			}
		}
	}
}