import java.util.*;

class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int mx, my;
    static int[][] visited;
    
    void bfs(int x, int y, int[][] maps) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        q.add(y);
        visited[y][x] = 1;
        
        while (!q.isEmpty()) {
            int nowX = q.poll();
            int nowY = q.poll();
            for (int i=0; i<4; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                if (newX < mx && newX >= 0 && newY < my && newY >= 0) {
                    if (visited[newY][newX] == 0 && maps[newY][newX] == 1) {
                        q.add(newX);
                        q.add(newY);
                        visited[newY][newX] = visited[nowY][nowX] + 1;
                    }
                }
            }
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        mx = maps[0].length;
        my = maps.length;
        visited = new int[my][mx];
        
        bfs(0, 0, maps);
        answer = visited[my - 1][mx - 1];
        
        if (visited[my - 1][mx - 1] == 0) {
            answer = -1;
        }
        
        return answer;
    }
}