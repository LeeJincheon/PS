import java.util.*;
public class Main {
	
	static int n, m;
	static int[][] map;
	static int[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int area = 0;
	
	static void bfs(int x, int y) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		q.add(y);
		visited[y][x] = 1;
		int sum = 1;
		
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
						sum++;
					}
				}
			}
		}
		area = Math.max(area, sum);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visited = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==1 && visited[i][j]==0) {
					bfs(j, i);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(area);
	}
}