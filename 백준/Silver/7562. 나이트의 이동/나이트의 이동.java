import java.util.*;
public class Main {
	
	static int n;
	static int[][] map;
	static int[][] visited;
	static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	static void bfs(int x, int y, int endX, int endY) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		q.add(y);
		
		while(!q.isEmpty()) {
			int nowX = q.poll();
			int nowY = q.poll();
			for(int i=0; i<8; i++) {
				int newX = nowX + dx[i];
				int newY = nowY + dy[i];
				
				if(newX==endX && newY==endY) {
					visited[newY][newX] = visited[nowY][nowX] + 1;
					return;
				}
				
				if(newX>=0 && newX<n && newY>=0 && newY<n) {
					if(visited[newY][newX]==0) {
						q.add(newX);
						q.add(newY);
						visited[newY][newX] = visited[nowY][nowX] + 1;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int i=0; i<tc; i++) {
			n = sc.nextInt();
			int startX = sc.nextInt();
			int startY = sc.nextInt();
			int endX = sc.nextInt();
			int endY = sc.nextInt();
			
			visited = new int[n][n];
			
			bfs(startX, startY, endX, endY);
			
			if(startX==endX && startY==endY) {
				System.out.println(0);
			}else {
				System.out.println(visited[endY][endX]);
			}
		}
	}
}