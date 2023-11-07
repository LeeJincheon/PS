import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			q.add(i+1);
		}
		
		int cnt = 1;
		List<Integer> res = new ArrayList<>();
		
		while(!q.isEmpty()) {
			if(cnt==k) {
				res.add(q.poll());
				cnt = 1;
			}else {
				int tmp = q.poll();
				q.add(tmp);
				cnt++;
			}
		}
		
		System.out.print("<");
		for(int i=0; i<res.size()-1; i++) {
			System.out.print(res.get(i) + ", ");
		}
		System.out.print(res.get(res.size()-1) + ">");
	}
}