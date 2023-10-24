import java.util.*;

public class Main {
	
	static int n, k;
	static int[] time;
	static int[] dx = {2, -1, 1};
	
	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(x);
		time[x] = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			int next = 0;
			
			if(now == k) {
				System.out.println(time[now]);
				return;
			}
			
			for(int i=0; i<3; i++) {
				if(i==0) {
					next = now * dx[i];
					if(next>0 && next<100001 && time[next]==-1) {
						q.add(next);
						time[next] = time[now];
					}
				}else {
					next = now + dx[i];
					if(next>0 && next<100001 && time[next]==-1) {
						q.add(next);
						time[next] = time[now] + 1;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		time = new int[100001];
		Arrays.fill(time, -1);
		
		if(n >= k) {
			System.out.println(n - k);
		}else {
			bfs(n);
		}
	}
}