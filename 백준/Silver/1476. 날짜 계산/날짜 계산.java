import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int e = sc.nextInt();
		int s = sc.nextInt();
		int m = sc.nextInt();
		
		int ee = 1;
		int ss = 1;
		int mm = 1;
		int year = 1;
		
		while(true) {
			if(ee==e && ss==s && mm==m) {
				System.out.println(year);
				break;
			}
			
			ee++; ss++; mm++; year++;
			
			if(ee > 15) {
				ee = 1;
			}
			
			if(ss > 28) {
				ss = 1;
			}
			
			if(mm > 19) {
				mm = 1;
			}
		}
	}
}