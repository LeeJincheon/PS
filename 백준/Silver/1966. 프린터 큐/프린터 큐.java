import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int i=0; i<tc; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			Queue<Integer> q = new LinkedList<>();
			Queue<Integer> idx = new LinkedList<>();
			for(int j=0; j<n; j++) {
				q.add(sc.nextInt());
				idx.add(j);
			}
			
			int cnt = 0;
			while(!q.isEmpty()) {
				int max = Collections.max(q);
				if(q.peek() == max) {
					q.poll();
					int index = idx.poll();
					cnt++;
					if(index == m) {
						System.out.println(cnt);
						break;
					}
				}else {
					q.add(q.poll());
					idx.add(idx.poll());
				}
			}
		}
	}
}