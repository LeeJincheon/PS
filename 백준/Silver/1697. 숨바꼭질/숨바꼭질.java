import java.util.*;
public class Main {
	
	static int[] time = new int[100001];
	
	static void bfs(int s, int e) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			int next;
			for(int i=0; i<3; i++) {
				if(i == 0) {
					next = now - 1;
				}else if(i == 1) {
					next = now + 1;
				}else {
					next = now * 2;
				}
				if(next>0 && next<100001 && time[next]==0) {
					q.add(next);
					time[next] = time[now] + 1;
				}
				if(next == e) {
					return;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		if(start >= end) {
			System.out.println(start - end);
		}else {
			bfs(start, end);
			System.out.println(time[end]);
		}
	}
}