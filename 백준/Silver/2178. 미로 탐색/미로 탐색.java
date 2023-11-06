import java.util.*;

public class Main {
	
	static int n, m;;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int[][] dis;
	
	static int bfs(int x, int y, String[] map) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(x);
		q.add(y);
        dis[y][x] = 1;
		
		while(!q.isEmpty()) {
			int nowX = q.poll();
			int nowY = q.poll();
			for(int i=0; i<4; i++) {
				int newX = nowX + dx[i];
				int newY = nowY + dy[i];
				if(newX>=0 && newX<m && newY>=0 && newY<n && dis[newY][newX]==0) {
					if(map[newY].charAt(newX)-'0' == 1) {
						q.add(newX);
						q.add(newY);
						dis[newY][newX] = dis[nowY][nowX] + 1;
					}
				}
			}
		}
		return dis[n-1][m-1];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // 행
		m = sc.nextInt(); // 열
		dis = new int[n][m];
		String[] map = new String[n];
		
		for(int i=0; i<n; i++) {
			map[i] = sc.next();
		}
		System.out.println(bfs(0, 0, map));
	}
}