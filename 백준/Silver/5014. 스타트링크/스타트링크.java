import java.util.*;

public class Main {
	
	static int F, S, G, U, D;
	static int[] cnt, dx;
	static boolean[] visited;
	
	static void bfs(int pos) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(pos);
		visited[pos] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now == G) {
				System.out.println(cnt[now]);
				return;
			}
            for(int i=0; i<2; i++) {
				int next = now + dx[i];
				if(next<=F && next>=1 && visited[next]==false) {
					q.add(next);
						visited[next] = true;
					cnt[next] = cnt[now] + 1;
				}
			}
		}
		System.out.println("use the stairs");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		
		cnt = new int[F+1];
		visited = new boolean[F+1];
		dx = new int[]{U, -D};
		
		bfs(S);
	}
}