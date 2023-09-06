import java.util.*;

class Solution {
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] visited;
    static int row, col;
    
    static void bfs(int x, int y, int[][] maps){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        q.add(y);
        visited[y][x] = 1;
        
        while(!q.isEmpty()){
            int nowX = q.poll();
            int nowY = q.poll();
            for(int i=0; i<4; i++){
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                if(newX>=0 && newX<col && newY>=0 && newY<row){
                    if(maps[newY][newX]==1 && visited[newY][newX]==0){
                        q.add(newX);
                        q.add(newY);
                        visited[newY][newX] = visited[nowY][nowX] + 1;
                    }
                }
            }
        }
    }
    
    public int solution(int[][] maps) {
        row = maps.length;
        col = maps[0].length;
        visited = new int[row][col];
        
        bfs(0, 0, maps);
        
        int res = visited[row-1][col-1];
        
        if(visited[row-1][col-1] == 0){ // 목적지까지 도달하지 못한 경우
            res = -1;
        }
        
        return res;
    }
}