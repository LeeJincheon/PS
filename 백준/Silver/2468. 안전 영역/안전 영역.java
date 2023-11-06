import java.util.*;

public class Main {
	
	static int n, h;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static void dfs(int x, int y) {
		visited[y][x] = true;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx<n && ny>=0 && ny<n) {
				if(visited[ny][nx]==false && map[ny][nx]>h) {
					dfs(nx, ny);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int cnt = 0;
		int res = 0;
		for(h=0; h<100; h++) {
			visited = new boolean[n][n];
			cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j]>h && visited[i][j]==false) {
						dfs(j, i);
						cnt++;
					}
				}
			}
			res = Math.max(res, cnt);
			if(cnt == 0) {
				break;
			}
		}
		System.out.println(res);
	}
}