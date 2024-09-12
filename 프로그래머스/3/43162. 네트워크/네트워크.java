import java.util.*;

class Solution {
    
    static int[] visited;
    
    void bfs(int node, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = 1;
        
        while (!q.isEmpty()) {
            int nowNode = q.poll();
            for (int i=0; i<visited.length; i++) {
                if (i != nowNode && visited[i] == 0 && computers[nowNode][i] == 1) {
                    q.add(i);
                    visited[i] = 1;
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new int[n];
        
        for (int i=0; i<n; i++) {
            if (visited[i] == 0) {
                bfs(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
}