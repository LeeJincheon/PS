import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Queue<String> name = new LinkedList<>();
		Queue<Integer> num = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			name.add(sc.next());
			num.add(sc.nextInt());
		}
		
		while(num.size() > 1) {
			int first = num.poll();
			name.poll();
			
			for(int i=0; i<first-1; i++) {
				name.add(name.poll());
				num.add(num.poll());
			}
			
			name.poll();
			num.poll();
		}
		
		System.out.println(name.poll());
	}
}