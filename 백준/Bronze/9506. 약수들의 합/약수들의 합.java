import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			List<Integer> list = new ArrayList<>();
			int num = sc.nextInt();
			
			if(num == -1)
				break;
			
			for(int i=1; i<=Math.sqrt(num); i++) {
				if(num%i == 0) {
					list.add(i);
					list.add(num/i);
				}
			}
			
			list.remove(Integer.valueOf(num)); // list에서 index가 num인 값이 아닌 num 자체를 삭제
			
			int sum = 0;
			for(int e : list) {
				sum += e;
			}
			
			if(sum == num) {
				Collections.sort(list);
				System.out.print(num + " = ");
				for(int i=0; i<list.size()-1; i++) {
					System.out.print(list.get(i) + " + ");
				}
				System.out.println(list.get(list.size()-1));
			}else {
				System.out.println(num + " is NOT perfect.");
			}
		}
	}
}