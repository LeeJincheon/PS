import java.util.*;

public class Main {
	
	static int n;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int[][] visited;
	static ArrayList<Integer> area = new ArrayList<>();
	
	static void bfs(int x, int y, String[] map) {
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
				if(newX>=0 && newX<n && newY>=0 && newY<n && visited[newY][newX]==0) {
					if(map[newY].charAt(newX)-'0' == 1) {
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
		
		n = sc.nextInt();
		visited = new int[n][n];
		String[] map = new String[n];
		
		for(int i=0; i<n; i++) {
			map[i] = sc.next();
		}
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i].charAt(j)-'0'==1 && visited[i][j]==0) {
					bfs(j, i, map);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
		Collections.sort(area);
		for(int i=0; i<cnt; i++) {
			System.out.println(area.get(i));
		}
	}
}