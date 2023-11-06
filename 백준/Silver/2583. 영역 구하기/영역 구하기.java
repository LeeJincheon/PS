import java.util.*;
public class Main {
	
	static int n, m;
	static int[][] map;
	static int[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static List<Integer> area = new ArrayList<>();
	
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
				if(newX>=0 && newX<n && newY>=0 && newY<m) {
					if(map[newY][newX]==0 && visited[newY][newX]==0) {
						q.add(newX);
						q.add(newY);
						visited[newY][newX] = 1;
						sum++;
					}
				}
			}
		}
		area.add(sum);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt();
		n = sc.nextInt();
		int k = sc.nextInt();
		
		map = new int[m][n];
		visited = new int[m][n];
		
		for(int i=0; i<k; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for(int j=y1; j<y2; j++) {
				for(int t=x1; t<x2; t++) {
					map[j][t] = 1;
				}
			}
		}
		
		int cnt = 0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==0 && visited[i][j]==0) {
					bfs(j, i);
					cnt++;
				}
			}
		}
        
		Collections.sort(area);
		
		System.out.println(cnt);
		
		for(int e : area) {
			System.out.print(e + " ");
		}
	}
}