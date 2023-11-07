import java.util.*;
public class Main {
	
	static int m, n;
	static int[][] map, visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static void bfs(int x, int y) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		q.add(y);
		visited[y][x] = 1;
		
		while(!q.isEmpty()) {
			int nowX = q.poll();
			int nowY = q.poll();
			for(int i=0; i<4; i++) {
				int newX = nowX + dx[i];
				int newY = nowY + dy[i];
				if(newX>=0 && newX<m && newY>=0 && newY<n) {
					if(map[newY][newX]==1 && visited[newY][newX]==0) {
						q.add(newX);
						q.add(newY);
						visited[newY][newX] = 1;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int i=0; i<tc; i++) {
			m = sc.nextInt();
			n = sc.nextInt();
			int k = sc.nextInt();
			map = new int[n][m];
			visited = new int[n][m];
			
			for(int j=0; j<k; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[y][x] = 1;
			}
			
			int cnt= 0;
			for(int j=0; j<n; j++) {
				for(int t=0; t<m; t++) {
					if(map[j][t]==1 && visited[j][t]==0) {
						bfs(t, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}